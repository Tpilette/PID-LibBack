package be.ipam.SGBD.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import be.ipam.SGBD.classes.Borrowing;
import be.ipam.SGBD.classes.Copy;
import be.ipam.SGBD.classes.Location;
import be.ipam.SGBD.classes.Reader;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import be.ipam.SGBD.Model.BibliothequeModel;
import be.ipam.SGBD.Model.BookModel;
import be.ipam.SGBD.Model.ReaderModel;
import be.ipam.SGBD.classes.Bibliotheque;


@RestController
public class BibliothequeController {

	@Autowired
	BibliothequeModel bm;
	@Autowired
	BookModel bookm;
	@Autowired
	ReaderModel rm;
	

	public List<Copy> getCopies(Bibliotheque bib) {

		return (List<Copy>) bm.getCopies(bib);

	}

	@RequestMapping("/Bibliotheque")
	public List<Bibliotheque> getBibliotheque(Model model) {

		List<Bibliotheque> lb = (List<Bibliotheque>) bm.getLibraries();
		return lb;
	}

//@Secured({ "ROLE_READER", "ROLE_LIBRARIAN" })
@RequestMapping(value = "/Borrow", method = RequestMethod.POST)
public boolean BorrowBook(@RequestBody Location loc) {


	// get the reader as object
	Optional<Reader> reader = rm.getReaderById(loc.getUserId());
	//get the copy 
	Optional<Copy> copy = bookm.getAvailableCopyForEdition(loc.getISBN());
	//get date 
	SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");

	// if both are present save the borrowing
	if (copy.isPresent() && reader.isPresent()) {
		
		// borrow a book
		Borrowing b = bm.borrow(copy.get(), reader.get(), date);

		return b != null ? true : false;

	} else {
		return false;
	}
 }
}
