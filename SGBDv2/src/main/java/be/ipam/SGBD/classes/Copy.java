package be.ipam.SGBD.classes;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Copy")
public class Copy {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CopyId")
	private long copyId;

	@Column(name="CopyStateId")
	private long stateId;

	@Column(name="CopyStatusId")
	private long statusId;
	
	@ManyToOne
	@JoinColumn(name = "BibliothequeId")
	private Bibliotheque bibliotheque;

	public long getCopyId() {
		return copyId;
	}
	public void setCopyId(long copyId) {
		this.copyId = copyId;
	}
	public long getCopyState() {
		return stateId;
	}
	public void setCopyState(long copyState) {
		this.stateId = copyState;
	}
	public long getCopyStatus() {
		return statusId;
	}
	public void setCopyStatus(long copyStatus) {
		this.statusId = copyStatus;
	}
	public Bibliotheque getBibliotheque() {
		return bibliotheque;
	}
	public void setBibliotheque(Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}
}
