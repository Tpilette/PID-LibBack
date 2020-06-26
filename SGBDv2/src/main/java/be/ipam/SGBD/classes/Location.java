package be.ipam.SGBD.classes;
import java.io.Serializable;

public class Location implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String ISBN;
	private long userId;
	
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

}
