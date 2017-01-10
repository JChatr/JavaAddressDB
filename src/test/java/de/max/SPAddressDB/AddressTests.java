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
	public void TestFirstNameArbitraryString() {
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
	public void TestFirstNameEmptyString() {
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
	public void TestFirstNameUnusualString() {
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
	public void TestLastNameArbitraryString() {
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
	public void TestLastNameEmptyString() {
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
	public void TestLastNameUnusualString() {
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
	public void TestEmailArbitraryString() {
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
	public void TestEmailEmptyString() {
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
	public void TestEmailUnusualString() {
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
	public void TestPhoneArbitraryString() {
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
	public void TestPhoneEmptyString() {
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
	public void TestPhoneUnusualString() {
		Address a = new Address();
		a.setPhone("--;{}--.-.");
		assertEquals("--;{}--.-.", a.getPhone());
	}

	/**
	 * Tests weather or not the Address Object correctly stores all it's values
	 * when they are set by the Constructor instead of the getters and setters
	 */
	@Test
	public void TestAddressValueStore() {
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
	public void TestSearchStringO() {
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
	public void TestSearchStringJohn() {
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
	public void TestSearchStringAwlkkadwklawdl() {
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
	public void TestSearchStringUnusualValues() {
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
	public void TestSearchStringDoe() {
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
	public void TestSearchStringCOMPANY() {
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
	public void TestToStingTestID12() {
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
	public void TestToStingIDVal() {
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
	public void TestToStingIDBackslash() {
		String id = "\\\\\\";
		Address a = new Address();
		a.setId(id);
		assertEquals(id, a.toString());
	}
}