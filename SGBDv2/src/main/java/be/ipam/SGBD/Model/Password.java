package be.ipam.SGBD.Model;
import org.mindrot.jbcrypt.BCrypt;

public class Password {
	private String pw;
	private String hashandsalt;
	
	
	static public String hashMe(String pwreadable) {
		return BCrypt.hashpw(pwreadable, BCrypt.gensalt(12));
		
	}
	
	public Password(String pw)
	{
		this.pw=pw;
	}
	
	public String firstHash() {
		return hashandsalt = BCrypt.hashpw(pw, BCrypt.gensalt(12));
		
	}
	
	public void setHash(String h) {
		hashandsalt = h;
	}
	
	public String getHash() {
		return hashandsalt;
	}
	
	public boolean isCorrect() {
		if (BCrypt.checkpw(pw, hashandsalt))
			return true;
		else
			return false;
	}
}