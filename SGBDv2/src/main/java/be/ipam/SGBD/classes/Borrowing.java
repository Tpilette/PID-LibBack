package be.ipam.SGBD.classes;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Borrowing")
public class Borrowing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BorrowingId")
	private long borrowingId;

	@Column(name = "StartDate")
	@DateTimeFormat(pattern="dd-MM-YYYY")
	private Timestamp startDate;

	@JoinColumn(name = "ReaderId") 
	private long readerId;

	@JoinColumn(name="CopyId")
	private long copyId;
	

	public Borrowing() {};
	public Borrowing(Timestamp startdate,long readerId,long copyId) {
		this.startDate = startdate;
		this.readerId = readerId;
		this.copyId = copyId;
	};
	

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp date) {
		this.startDate = date;
	}

	public long getBorrowingId() {
		return borrowingId;
	}

	public void setBorrowingId(long borrowingId) {
		this.borrowingId = borrowingId;
	}

	public long getReaderId() {
		return readerId;
	}

	public void setReaderId(long reader) {
		this.readerId = reader;
	}

	public long getCopyId() {
		return copyId;
	}

	public void setCopyId(long copyId) {
		this.copyId = copyId;
	}


}
