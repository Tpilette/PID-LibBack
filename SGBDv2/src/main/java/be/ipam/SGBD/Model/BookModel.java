package be.ipam.SGBD.Model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.ipam.SGBD.Repositories.BookDAO;
import be.ipam.SGBD.Repositories.CopyDAO;
import be.ipam.SGBD.classes.Book;
import be.ipam.SGBD.classes.Copy;

@Service
public class BookModel {
	
	@Autowired
	private BookDAO bookDAO;
	@Autowired
	private CopyDAO copyDAO;
	
	public Iterable<Book> getBooks(long bibliothequeId){		
		return bookDAO.getBooks(bibliothequeId);		
	}
	
	public Book addBook(Book book){
		return (bookDAO.save(book));
	}
	
	public Optional<Book> getBookById(long id){
	
		return bookDAO.findById(id);
	}
	
	public void deleteBook(long id) {
		
		 bookDAO.deleteById(id);
	}
	
	public List<Copy> getCopiesForEdition(String isbn){
		
		return copyDAO.getCopies(isbn);
	}
	
	public Optional<Copy> getAvailableCopyForEdition(String isbn){
		
		Optional<Copy> c = copyDAO.getAvailableCopy(isbn);
		return  c;
		
	}
}
