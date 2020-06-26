package be.ipam.SGBD.classes;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Borrowing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Borrowingid")
	private long borrowingId;

	@Column(name = "Startdate")
	private SimpleDateFormat startDate;

	@ManyToOne
	@JoinColumn(name = "Readerid") 
	private Reader reader;

	
	private long copyId;


	public SimpleDateFormat getStartDate() {
		return startDate;
	}

	public void setStartDate(SimpleDateFormat date) {
		this.startDate = date;
	}

	public long getBorrowingId() {
		return borrowingId;
	}

	public void setBorrowingId(long borrowingId) {
		this.borrowingId = borrowingId;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public long getCopyId() {
		return copyId;
	}

	public void setCopyId(long copyId) {
		this.copyId = copyId;
	}


}
