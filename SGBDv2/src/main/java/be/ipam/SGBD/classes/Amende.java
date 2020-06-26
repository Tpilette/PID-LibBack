package be.ipam.SGBD.classes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Fine")
public class Amende {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FineId")
	private long fineId;	
	@Column(name="Amount")
	private double amount;
	@Column(name="Date")
	private Date date;
	@Column(name="ReaderId")
	private long readerId;
	
	
	public long getFineId() {
		return fineId;
	}
	public void setFineId(long fineId) {
		this.fineId = fineId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getReaderId() {
		return readerId;
	}
	public void setReaderId(long readerId) {
		this.readerId = readerId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	} 
	
}
