package de.max.SPAddressDB;

public class AdrDBDriver {
	/**
	 * @param args Not used.
	 * @author mk285
	 * <p>
	 * This class is used to start the AdressDB program.
	 * It creates an object of the class UserInteract and runs the method run in UserInterface.
	 */
	public static void main(String[] args) {
		UserInteract jADB = new UserInteract();
		jADB.run();
	}
}