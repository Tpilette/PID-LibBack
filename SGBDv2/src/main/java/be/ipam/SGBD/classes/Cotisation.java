package be.ipam.SGBD.classes;

import java.util.Date;

public class Cotisation {
	
	private long bibliothequeId;
	private Date expirationDate;
	private Double amount;

	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public long getBibliothequeId() {
		return bibliothequeId;
	}
	public void setBibliothequeId(long bibliothequeId) {
		this.bibliothequeId = bibliothequeId;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	

}
