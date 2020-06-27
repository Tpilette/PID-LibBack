package be.ipam.SGBD.classes;

import javax.persistence.*;



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
	
	@Column(name="Price")
	private Float price;
	
	@Column(name="Edition")
	private String edition;

		
	public Book() {};
	public Book(String title,String description,float price,String edition){
		this.title = title;
		this.description = description;
		this.price = price;
		this.edition = edition;
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
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	


}

