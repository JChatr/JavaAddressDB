package de.max.SPAddressDB;

import static org.junit.Assert.*;
import org.junit.Test;

public class AddressTest {

	@Test
	public void FirstName1() {
		Address a = new Address();
		a.setFirstName("awdawdawdawd");
		assertEquals("awdawdawdawd", a.getFirstName());
	}
	
	@Test
	public void FirstName2() {
		Address a = new Address();
		a.setFirstName("");
		assertEquals("", a.getFirstName());
	}
	
	@Test
	public void FirstName3() {
		Address a = new Address();
		a.setFirstName("--;{}--.-.");
		assertEquals("--;{}--.-.", a.getFirstName());
	}
	
	@Test
	public void lastName1() {
		Address a = new Address();
		a.setFirstName("awdawdawdawd");
		assertEquals("awdawdawdawd", a.getFirstName());
	}
	
	@Test
	public void lastName2() {
		Address a = new Address();
		a.setFirstName("");
		assertEquals("", a.getFirstName());
	}
	
	@Test
	public void lastName3() {
		Address a = new Address();
		a.setFirstName("--;{}--.-.");
		assertEquals("--;{}--.-.", a.getFirstName());
	}
	@Test
	public void email1() {
		Address a = new Address();
		a.setFirstName("awdawdawdawd");
		assertEquals("awdawdawdawd", a.getFirstName());
	}
	
	@Test
	public void 2() {
		Address a = new Address();
		a.setFirstName("");
		assertEquals("", a.getFirstName());
	}
	
	@Test
	public void FirstName3() {
		Address a = new Address();
		a.setFirstName("--;{}--.-.");
		assertEquals("--;{}--.-.", a.getFirstName());
	}
	
}
