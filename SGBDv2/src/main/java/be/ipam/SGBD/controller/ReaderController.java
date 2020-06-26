package be.ipam.SGBD.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import be.ipam.SGBD.Model.ReaderModel;
import be.ipam.SGBD.classes.Reader;

@RestController
public class ReaderController {

	@Autowired
	ReaderModel rm;
	@Autowired 
	BookController bc;
	

	//get all readers
	@RequestMapping("/Readers")
	public List<Reader> getReaders() {

		List<Reader> r = (List<Reader>) rm.getReaders();
		return r;
	}

	//get reader by ID
	@GetMapping("/Readers/{id}")
	public Optional<Reader> getReaderById(@PathVariable long id, Model model) {

		Optional<Reader> r = rm.getReaderById(id);
		return r;
	}

	//update a single user
	@Secured("ROLE_READER")
	@PutMapping("/Reader/Update/{id}")
	public Reader updateReader(@RequestBody Reader r, @PathVariable long id) {

		return rm.saveReader(r);

	}
	
	

	
	
	
	
}
