package be.ipam.SGBD.Model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.ipam.SGBD.classes.Reader;
import be.ipam.SGBD.Repositories.*;
import be.ipam.SGBD.classes.Amende;
import be.ipam.SGBD.classes.Cotisation;

@Service
public class ReaderModel {

	
	@Autowired
	ReaderDAO readerDAO;

	public Iterable<Reader> getReaders(){
			
		return readerDAO.findAll();
	}
	
	public Optional<Reader> getReaderById(long id){
		
		return readerDAO.findById(id);
	}
	
	public Optional<Reader> getReaderByMail(String mail){
		
		return readerDAO.findByemail(mail);
	}
	
	public Reader saveReader(Reader r) {
		
		return readerDAO.save(r);
	}	

	public List<Cotisation> getAffiliations(Reader reader){
		
		return readerDAO.getCotisations(reader.getReaderId());
	}

	public List<Amende> getAmende(Reader r) {
		return readerDAO.getAmende(r.getReaderId());
	}
	
	
}

