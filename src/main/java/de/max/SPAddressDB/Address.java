package de.max.SPAddressDB;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Address implements Serializable {

	private static final long serialVersionUID = -5733008229122025870L;
	private Map<String, String> data = new LinkedHashMap<>();

	/**
	 * enum to provide type safety (and to keep Key IDs consistant)
	 * 
	 * @author mk285
	 */
	public enum Types {
		ID ("ID"), FIRSTNAME("First Name"), LASTNAME("Last Name"), EMAIL("Email"), PHONE("Phone");
		private String get;

		private Types(String type) {
			this.get = type;
		}
	}

	/**
	 * Constructor of the class Address
	 * @param id The ID of the index in the database.
	 * @param firstName The First name of the person.
	 * @param lastName The last name of the person.
	 * @param email The email of the person.
	 * @param phone The phone number of the person.
	 */
	public Address(String id, String firstName, String lastName, String email, String phone) {
		this.data.put(Types.ID.get, id);
		this.data.put(Types.FIRSTNAME.get, firstName);
		this.data.put(Types.LASTNAME.get, lastName);
		this.data.put(Types.EMAIL.get, email);
		this.data.put(Types.PHONE.get, phone);
	}

	public Address() {
	}
	/**
	 * This method is used to get the ID. 
	 * @return Returns the ID.
	 */
	public String getId() {
		return data.get(Types.ID.get);
	}
	/**
	 * This method is used to set the ID.
	 * @param Sets the ID of this object to 'id'.
	 */
	public void setId(String id) {
		this.data.put(Types.ID.get, id);
	}
	
	/**
	 * This method is used to get the first name.
	 * @return Returns the first name.
	 */
	public String getFirstName() {
		return data.get(Types.FIRSTNAME.get);
	}

	/**
	 * This method is used to set the first name.
	 * @param Sets the first name to 'firstname'.
	 */
	public void setFirstName(String firstName) {
		this.data.put(Types.FIRSTNAME.get, firstName);
	}

	/**
	 * This method is used to get the last name.
	 * @return Returns the lastName.
	 */
	public String getLastName() {
		return data.get(Types.LASTNAME.get);
	}

	/**
	 * This method is used to set the last name.
	 * @param Sets the last name to 'lastName'.
	 */
	public void setLastName(String lastName) {
		this.data.put(Types.LASTNAME.get, lastName);
	}

	/**
	 * This method is used to get the email address.
	 * @return Returns the mail address.
	 */
	public String getEmail() {
		return data.get(Types.EMAIL.get);
	}

	/**
	 * This method is used to set the email address.
	 * @param Sets email address to 'email'.
	 */
	public void setEmail(String email) {
		this.data.put(Types.EMAIL.get, email);
	}

	/**
	 * This method is used to return the phone number.
	 * @return Returns the phone number.
	 */
	public String getPhone() {
		return data.get(Types.PHONE.get);
	}

	/**
	 * This method is used to set the phone number.
	 * @param Sets the phone number to 'phone'.
	 */
	public void setPhone(String phone) {
		this.data.put(Types.PHONE.get, phone);
	}

	/**
	 * This method is used to search through the database.
	 * @param Sets the search query to 'input'.
	 * @return Returns the entries that matched with the search query.
	 */
	public boolean search(String input) {
		for (Map.Entry<String, String> i : data.entrySet()) {
			String j = i.getValue().toUpperCase();
			if (j.contains(input.toUpperCase())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method is used to return the ID as a string.
	 * @return Returns the ID as a string.
	 */
	@Override
	public String toString(){
		return getId();
	}
}