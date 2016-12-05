package de.max.SPAddressDB;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Address implements Serializable {

	private static final long		serialVersionUID	= -5733008229122025870L;
	private Map<String, String>	data							= new LinkedHashMap<>();

	/**
	 * enum to provide type safety (and to keep Key IDs consistant)
	 * 
	 * @author max
	 */
	public enum Types {
		FIRSTNAME("First Name"), LASTNAME("Last Name"), EMAIL("Email"), PHONE(
				"Phone");
		private String get;

		private Types(String type) {
			this.get = type;
		}
	}

	public Address(String firstName, String lastName, String email,
			String phone) {
		this.data.put(Types.FIRSTNAME.get, firstName);
		this.data.put(Types.LASTNAME.get, lastName);
		this.data.put(Types.EMAIL.get, email);
		this.data.put(Types.PHONE.get, phone);
	}

	public Address() {

	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return data.get(Types.FIRSTNAME.get);
	}

	/**
	 * @param firstName
	 *          the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.data.put(Types.FIRSTNAME.get, firstName);
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return data.get(Types.LASTNAME.get);
	}

	/**
	 * @param lastName
	 *          the lastName to set
	 */
	public void setLastName(String lastName) {
		this.data.put(Types.LASTNAME.get, lastName);
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return data.get(Types.EMAIL.get);
	}

	/**
	 * @param email
	 *          the email to set
	 */
	public void setEmail(String email) {
		this.data.put(Types.EMAIL.get, email);
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return data.get(Types.PHONE.get);
	}

	/**
	 * @param phone
	 *          the phone to set
	 */
	public void setPhone(String phone) {
		this.data.put(Types.PHONE.get, phone);
	}

	public boolean search(String input) {
		for (Map.Entry<String, String> i : data.entrySet()) {
			String j = i.getValue().toUpperCase();
			if (j.contains(input.toUpperCase())) {
				return true;
			}
		}
		return false;
	}
}