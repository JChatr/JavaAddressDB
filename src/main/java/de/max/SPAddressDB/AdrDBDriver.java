package de.max.SPAddressDB;

/**
 * This class is used to start the program.
 *
 * @author mk285
 */
public class AdrDBDriver {
	/**
	 * @param args Not used.
	 * This class is used to start the AddressDB program.
	 * It creates an object of the class UserInteract and runs the method run in UserInterface.
	 */
	public static void main(String[] args) {
		UserInteract jADB = new UserInteract();
		jADB.run();
	}
}