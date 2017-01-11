package de.max.SPAddressDB;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class is used to store the data of one person.
 * @author mk285
 *
 */
public class Address implements Serializable {

	private static final long serialVersionUID = -5733008229122025870L;
	private Map<Enum, String> data = new LinkedHashMap<>();

	/**
	 * Enum to provide type safety (and to keep Key IDs consistent)
	 *
	 * @author mk28
	 */
	public enum Types {
		ID, FIRSTNAME, LASTNAME, EMAIL, PHONE;
	}

	/**
	 * Constructor of the class Address
	 *
	 * @param id        The ID of the index in the database.
	 * @param firstName The first name of the person.
	 * @param lastName  The last name of the person.
	 * @param email     The email of the person.
	 * @param phone     The phone number of the person.
	 */
	public Address(String id, String firstName, String lastName, String email, String phone) {
		this.data.put(Types.ID, id);
		this.data.put(Types.FIRSTNAME, firstName);
		this.data.put(Types.LASTNAME, lastName);
		this.data.put(Types.EMAIL, email);
		this.data.put(Types.PHONE, phone);
	}

	public Address() {
	}

	/**
	 * This method is used to get the ID.
	 *
	 * @return Returns the ID.
	 */
	public String getId() {
		return data.get(Types.ID);
	}

	/**
	 * This method is used to set the ID.
	 *
	 * @param id Sets the ID of this object to 'id'.
	 */
	public void setId(String id) {
		this.data.put(Types.ID, id);
	}

	/**
	 * This method is used to get the first name.
	 *
	 * @return Returns the first name.
	 */
	public String getFirstName() {
		return data.get(Types.FIRSTNAME);
	}

	/**
	 * This method is used to set the first name.
	 *
	 * @param firstName Sets the first name to 'firstname'.
	 */
	public void setFirstName(String firstName) {
		this.data.put(Types.FIRSTNAME, firstName);
	}

	/**
	 * This method is used to get the last name.
	 *
	 * @return Returns the lastName.
	 */
	public String getLastName() {
		return data.get(Types.LASTNAME);
	}

	/**
	 * This method is used to set the last name.
	 *
	 * @param lastName Sets the last name to 'lastName'.
	 */
	public void setLastName(String lastName) {
		this.data.put(Types.LASTNAME, lastName);
	}

	/**
	 * This method is used to get the email address.
	 *
	 * @return Returns the mail address.
	 */
	public String getEmail() {
		return data.get(Types.EMAIL);
	}

	/**
	 * This method is used to set the email address.
	 *
	 * @param email Sets email address to 'email'.
	 */
	public void setEmail(String email) {
		this.data.put(Types.EMAIL, email);
	}

	/**
	 * This method is used to return the phone number.
	 *
	 * @return Returns the phone number.
	 */
	public String getPhone() {
		return data.get(Types.PHONE);
	}

	/**
	 * This method is used to set the phone number.
	 *
	 * @param phone Sets the phone number to 'phone'.
	 */
	public void setPhone(String phone) {
		this.data.put(Types.PHONE, phone);
	}

	/**
	 * This method is used to search through the database.
	 *
	 * @param input Sets the search query to 'input'.
	 * @return Returns the entries that matched with the search query.
	 */
	public boolean search(String input) {
		for (String i : data.values()) {
			String j = i.toUpperCase();
			if (j.contains(input.toUpperCase())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method is used to return the ID as a string.
	 *
	 * @return Returns the ID as a string.
	 */
	@Override
	public String toString() {
		return getId();
	}
}