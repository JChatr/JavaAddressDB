package de.max.SPAddressDB;

public class AdrDBDriver {
	/**
	 * @author mk285
	 * 
	 * This class is used to start the AdressDB program.
	 * It creates an object of the class UserInteract and runs the method run in UserInterface.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		UserInteract jADB = new UserInteract();
		jADB.run();
	}
}