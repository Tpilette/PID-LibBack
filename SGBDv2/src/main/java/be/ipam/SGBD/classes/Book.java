package be.ipam.SGBD.classes;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;


@Entity
@Table(name="Book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BookId")
	private long bookId;

	@Column(name="Title")
	private String title;

	@Column(name="Description")
	private String description;

		
	public Book() {};
	public Book(String title,String description){
		this.title = title;
		this.description = description;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getBookId() {
		return bookId;
	}	
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	


}

