package be.ipam.SGBD.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import be.ipam.SGBD.Model.BookModel;
import be.ipam.SGBD.classes.Book;
import be.ipam.SGBD.classes.Copy;

@RestController
public class BookController {

    @Autowired
    BookModel bm;
    

    
    //GET All Books
	//@Secured({"ROLE_READER" , "ROLE_LIBRARIAN"})
    @GetMapping(value="/Books/{bibliothequeId}")
    public List<Book> getBooks(@PathVariable long bibliothequeId,Model model){

       List<Book> books = (List<Book>) bm.getBooks(bibliothequeId);
       return books;
    }
    
    //GET title of copy
     @RequestMapping(method=RequestMethod.GET,value="/copyTitle/{copyId}",produces="text/plain")
     @ResponseBody
     public String getCopyTitle(@PathVariable long copyId){

    	String title = bm.getCopyTitle(copyId);

        return title;
        
     }

    // ADD a book 
    @PostMapping(value="/Books/Add")
    public Book addBook(@RequestBody Book book){
        return (bm.addBook(book));
    }
    
    // get by ID
    @GetMapping("/Book/{id}")
    public Optional<Book> getBook(@PathVariable long id,Model model){
         
    	Optional<Book> b = bm.getBookById(id); 
        return b;
    }
    
    // Delete
    @GetMapping("/Book/{id}/Delete")
    public boolean deleteBook(@PathVariable long id) {
    	
    	bm.deleteBook(id);
    	return true;
    }
}
