package be.ipam.SGBD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import be.ipam.SGBD.Model.Password;

class PasswordTests {

	@Test
	void test() {
		Password p = new Password("toto123$+");
		
		p.firstHash();
		String hash = p.getHash();
		
		System.out.println(hash);		
		
	}

}
