package be.ipam.SGBD.classes;

import javax.persistence.*;

@Entity
public class Reader{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Readerid")
	private long ReaderId;
	
	private String Name;
	private String Lastname;
	private String Phone;
	private String Address;
	
	@Column(name="Email")
	private String Email;
	
	@Column(name="Hash")
	private String Password;

	//@OneToMany(mappedBy="BorrowingId")
	//public List<Borrowing> borrowing;
	
	public long getReaderId() {
		return ReaderId;
	}
	public void setReaderId(long readerId) {
		ReaderId = readerId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String eMail) {
		Name = eMail;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
	

	
}
