package be.ipam.SGBD.Model;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import be.ipam.SGBD.classes.Borrowing;
import be.ipam.SGBD.classes.Copy;
import be.ipam.SGBD.classes.Cotisation;
import be.ipam.SGBD.classes.Reader;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.stereotype.Service;

import be.ipam.SGBD.Repositories.BibliothequeDAO;
import be.ipam.SGBD.Repositories.BorrowingDAO;
import be.ipam.SGBD.Repositories.CopyDAO;
import be.ipam.SGBD.classes.Amende;
import be.ipam.SGBD.classes.Bibliotheque;


@Service
public class BibliothequeModel {
	

	@Autowired
	BorrowingDAO borrowingDAO;
	@Autowired 
	CopyDAO copyDAO;
	@Autowired 
	ReaderModel readerModel;
	
	@Autowired
	private BibliothequeDAO bibliDAO;

	public Iterable<Bibliotheque> getLibraries() {
		return bibliDAO.findAll();
		}

	public Iterable<Copy> getLibrariesCopies() {

		List<Copy> copies = new ArrayList<Copy>();
		List<Bibliotheque> listBiblio = (List<Bibliotheque>) bibliDAO.findAll();

		for (Bibliotheque bib : listBiblio) {

			copies.addAll(bib.copies);
		}
		return copies;

	}

	public Iterable<Copy> getCopies(Bibliotheque bib) {

		List<Copy> copies = new ArrayList<Copy>();
		List<Bibliotheque> listBiblio = (List<Bibliotheque>) bibliDAO.findAll();

		for (Bibliotheque biblio : listBiblio) {
			if (biblio.getBibliothequeId() == bib.getBibliothequeId()) {
				copies.addAll(bib.copies);
			}

		}
		return copies;

	}
	
	public List<Borrowing> getEmprunts(Reader r){
		
		return borrowingDAO.getBorrowingByReader(r.getReaderId());			
	}
	
	
	public Borrowing borrow(Copy copy, Reader reader, SimpleDateFormat date) {
		
		Borrowing borrow = new Borrowing();
		
		//if(checkReader(reader,1)) {

			borrow.setReader(reader);
			borrow.setStartDate(date);
			borrow.setCopyId(copy.getCopyId());
			
			borrow = borrowingDAO.save(borrow);
			
			copy.setCopyStatus(3);
			copyDAO.save(copy);
			
	//	}
		return borrow;
		
	}
	
	
	public boolean checkReader(Reader r,long bibId) {
		
		List<Cotisation> coti = readerModel.getAffiliations(r);
		List<Amende> amendes = readerModel.getAmende(r);
		Boolean cotisationOk = true;
		
		for (Cotisation cotisation : coti) {
			
			if(cotisation.getBibliothequeId() == bibId) {
				cotisationOk = cotisation.getExpirationDate().compareTo(Calendar.getInstance().getTime()) > 0 ? true : false ;
			}
		}
				
		if(cotisationOk && amendes.size() < 1) {
		
			return true;	
		}
		else {
			//ajouter : retour pour déterminer l'erreur
			return false;
		}	
	}

}
