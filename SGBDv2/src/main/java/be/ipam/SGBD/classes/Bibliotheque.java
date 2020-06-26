package be.ipam.SGBD.classes;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name="Bibliotheque")
public class Bibliotheque {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BibliothequeId")
	private long bibliothequeId;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="Phone")
	private String phone;
	
	@Column(name="Email")
	private String email;
	
	
	@OneToMany(mappedBy="bibliotheque",fetch=FetchType.LAZY)
	public List<Copy> copies;
		

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String eMail) {
		this.email = eMail;
	}
	public long getBibliothequeId() {
		return bibliothequeId;
	}
	public void setBibliothequeId(long bibliothequeId) {
		this.bibliothequeId = bibliothequeId;
	}
	public List<Copy> getCopies() {
		return copies;
	}
	public void setCopies(List<Copy> copies) {
		this.copies = copies;
	}
	
}
