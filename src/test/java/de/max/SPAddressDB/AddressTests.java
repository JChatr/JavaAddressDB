package de.max.SPAddressDB;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTests {
	/**
	 * Tests weather or not the Address Object correctly stores the First Name
	 * Attribute
	 * checks for an arbitrary string
	 */
	@Test
	public void FirstName1() {
		Address a = new Address();
		a.setFirstName("awdawdawdawd");
		assertEquals("awdawdawdawd", a.getFirstName());
	}
	/**
	 * Tests weather or not the Address Object correctly stores the First Name
	 * Attribute
	 * Checks for empty values
	 */
	@Test
	public void FirstName2() {
		Address a = new Address();
		a.setFirstName("");
		assertEquals("", a.getFirstName());
	}
	/**
	 * Tests weather or not the Address Object correctly stores the First Name
	 * Attribute
	 * checks for unusual chars
	 */
	@Test
	public void FirstName3() {
		Address a = new Address();
		a.setFirstName("--;{}--.-.");
		assertEquals("--;{}--.-.", a.getFirstName());
	}
	/**
	 * Tests weather or not the Address Object correctly stores the Last Name
	 * Attribute
	 * checks for an arbitrary string
	 */
	@Test
	public void lastName1() {
		Address a = new Address();
		a.setFirstName("awdawdawdawd");
		assertEquals("awdawdawdawd", a.getFirstName());
	}
	/**
	 * Tests weather or not the Address Object correctly stores the Last Name
	 * Attribute
	 * checks for an empty string
	 */
	@Test
	public void lastName2() {
		Address a = new Address();
		a.setFirstName("");
		assertEquals("", a.getFirstName());
	}
	/**
	 * Tests weather or not the Address Object correctly stores the Last Name
	 * Attribute
	 * checks for unusual chars
	 */
	@Test
	public void lastName3() {
		Address a = new Address();
		a.setFirstName("--;{}--.-.");
		assertEquals("--;{}--.-.", a.getFirstName());
	}
	/**
	 * Tests weather or not the Address Object correctly stores the Last Name
	 * Attribute
	 * checks for an arbitrary string
	 */
	@Test
	public void email1() {
		Address a = new Address();
		a.setEmail("awdawdawdawd");
		assertEquals("awdawdawdawd", a.getEmail());
	}
	/**
	 * Tests weather or not the Address Object correctly stores the Email
	 * Attribute
	 * checks for an empty string
	 */
	@Test
	public void email2() {
		Address a = new Address();
		a.setEmail("");
		assertEquals("", a.getEmail());
	}
	/**
	 * Tests weather or not the Address Object correctly stores the Email
	 * Attribute
	 * checks for unusual chars
	 */
	@Test
	public void email3() {
		Address a = new Address();
		a.setEmail("--;{}--.-.");
		assertEquals("--;{}--.-.", a.getEmail());
	}
	/**
	 * Tests weather or not the Address Object correctly stores the Phone
	 * Attribute
	 * checks for an arbitrary string
	 */
	@Test
	public void phone1() {
		Address a = new Address();
		a.setPhone("00255200");
		assertEquals("00255200", a.getPhone());
	}
	/**
	 * Tests weather or not the Address Object correctly stores the Phone
	 * Attribute
	 * checks for an empty string
	 */
	@Test
	public void phone2() {
		Address a = new Address();
		a.setPhone("");
		assertEquals("", a.getPhone());
	}
	/**
	 * Tests weather or not the Address Object correctly stores the Phone
	 * Attribute
	 * checks for unusual chars
	 */
	@Test
	public void phone3() {
		Address a = new Address();
		a.setPhone("--;{}--.-.");
		assertEquals("--;{}--.-.", a.getPhone());
	}
	/**
	 * Tests weather or not the Address Object correctly stores all it's values
	 * when they are set by the Constructor instead of the getters and setters
	 *
	 */
	@Test
	public void addressTest1() {
		String id = "12";
		String firstName = "awdawd";
		String lastName = "gogrg";
		String email = "awdawdwd";
		String phone = "gdrgdrgdr";
		Address a = new Address(id, firstName, lastName, email, phone);
		assertEquals(id, a.getId());
		assertEquals(firstName, a.getFirstName());
		assertEquals(lastName, a.getLastName());
		assertEquals(email, a.getEmail());
		assertEquals(phone, a.getPhone());
	}

	/**
	 * Tests weather or not the Address Object's search method will find singe
	 * chars
	 * searches for the String "a"
	 */
	@Test
	public void searchTest1() {
		String id = "12";
		String firstName = "John";
		String lastName = "Doe";
		String email = "John@myCompany.com";
		String phone = "21215045";
		String searchQuery = "a";
		Address a = new Address(id, firstName, lastName, email, phone);
		assertTrue(a.search(searchQuery));
	}
	/**
	 * Tests weather or not the Address Object's search method will find entire fields
	 * searches for the String "John"
	 */
	@Test
	public void searchTest2() {
		String id = "12";
		String firstName = "John";
		String lastName = "Doe";
		String email = "John@myCompany.com";
		String phone = "21215045";
		String searchQuery = "John";
		Address a = new Address(id, firstName, lastName, email, phone);
		assertTrue(a.search(searchQuery));
	}
	/**
	 * Tests weather or not the Address Object's search method will not find
	 * strings that are not contained within the fields
	 * searches for the String "awlkkadwklawdl"
	 */
	@Test
	public void searchTest3() {
		String id = "12";
		String firstName = "John";
		String lastName = "Doe";
		String email = "John@myCompany.com";
		String phone = "21215045";
		String searchQuery = "awlkkadwklawdl";
		Address a = new Address(id, firstName, lastName, email, phone);
		assertFalse(a.search(searchQuery));
	}
	/**
	 * Tests weather or not the Address Object's search method will not partial
	 * matches
	 * searches for the String "-,-.-.;##+John"
	 */
	@Test
	public void searchTest4() {
		String id = "12";
		String firstName = "John";
		String lastName = "Doe";
		String email = "John@myCompany.com";
		String phone = "21215045";
		String searchQuery = "-,-.-.;##+John";
		Address a = new Address(id, firstName, lastName, email, phone);
		assertFalse(a.search(searchQuery));
	}
	/**
	 * Tests weather or not the Address Object's search method will ignore the
	 * case of the search query
	 * searches for the String "doe"
	 */
	@Test
	public void searchTest5() {
		String id = "12";
		String firstName = "John";
		String lastName = "Doe";
		String email = "John@myCompany.com";
		String phone = "21215045";
		String searchQuery = "doe";
		Address a = new Address(id, firstName, lastName, email, phone);
		assertTrue(a.search(searchQuery));
	}
	/**
	 * Tests weather or not the Address Object's search method will ignore the
	 * case of the search query
	 * searches for the String "COMPANY"
	 */
	@Test
	public void searchTest6() {
		String id = "12";
		String firstName = "John";
		String lastName = "Doe";
		String email = "John@myCompany.com";
		String phone = "21215045";
		String searchQuery = "COMPANY";
		Address a = new Address(id, firstName, lastName, email, phone);
		assertTrue(a.search(searchQuery));
	}

	/**
	 * Tests weather or not the Address Object will return the ID field when it's toString()
	 * is called
	 */
	@Test
	public void toStingTest1() {
		String id = "12";
		Address a = new Address();
		a.setId(id);
		assertEquals(id, a.toString());
	}
	/**
	 * Tests weather or not the Address Object will return the ID field when it's toString()
	 * is called
	 */
	@Test
	public void toStingTest2() {
		String id = "-2268";
		Address a = new Address();
		a.setId(id);
		assertEquals(id, a.toString());
	}
	/**
	 * Tests weather or not the Address Object will return the ID field when it's toString()
	 * is called
	 */
	@Test
	public void toStingTest3() {
		String id = "\\\\\\";
		Address a = new Address();
		a.setId(id);
		assertEquals(id, a.toString());
	}
}