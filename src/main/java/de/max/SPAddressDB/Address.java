package de.max.SPAddressDB;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Address implements Serializable {

	private static final long serialVersionUID = -5733008229122025870L;
	private Map<Enum, String> data = new LinkedHashMap<>();

	/**
	 * enum to provide type safety (and to keep Key IDs consistant)
	 *
	 * @author max
	 */
	public enum Types {
		ID, FIRSTNAME, LASTNAME, EMAIL, PHONE;
	}

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
	 * @return
	 */
	public String getId() {
		return data.get(Types.ID);
	}

	/**
	 * @param id
	 */
	public void setId(String id) {
		this.data.put(Types.ID, id);
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return data.get(Types.FIRSTNAME);
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.data.put(Types.FIRSTNAME, firstName);
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return data.get(Types.LASTNAME);
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.data.put(Types.LASTNAME, lastName);
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return data.get(Types.EMAIL);
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.data.put(Types.EMAIL, email);
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return data.get(Types.PHONE);
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.data.put(Types.PHONE, phone);
	}

	public boolean search(String input) {
		for (String i : data.values()) {
			String j = i.toUpperCase();
			if (j.contains(input.toUpperCase())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return getId();
	}
}