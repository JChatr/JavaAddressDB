package de.max.SPAddressDB;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Addresses {
	private Scanner scan = new Scanner(System.in);
	// always up to date list
	private List<Address> addresses;
	// periodically updated list
	private Database<Address> db = new ListDB<>();
	private final int listLen = 10;

	public void run() {
		System.out.println("*-------------------------*");
		System.out.println("|                         |");
		System.out.println("|  Java Address manager:  |");
		System.out.println("|                         |");
		System.out.println("*-------------------------*");
		System.out.println();
		System.out.println("test");
		addresses = db.get();
		mainMenu();
	}

	/**
	 * recursive method that represents the main menu of the manager
	 */
	private void mainMenu() {
		System.out.println("\nPick one of the following options:\n");
		System.out.println("0: Browse Database entries");
		System.out.println("1: Search the Database");
		System.out.println("2: Create new entry");
		System.out.println("3: Delete an entry");
		System.out.println("4: Exit");

		System.out.print("Your choice: ");
		switch (getInt(0, 4)) {
			case Integer.MIN_VALUE :
				System.out.println("\n");
			case 0 :
				browse(0);
				break;
			case 1 :
				search();
				break;
			case 2 :
				createEntry();
				break;
			case 3 :
				deleteEntry();
				break;
			case 4 :
				exit();
				return;
		}
		db.update(addresses);
		mainMenu();
	}

	/**
	 * prints the current database to the console
	 */
	private void browse(int start) {
		System.out.println("\nCurrent records:");
		Menu.head();
		int len = addresses.size();
		// loop through the list with the offset of start
		// only display the elements from start -> start + listLen
		for (int i = start; i < Math.min(listLen + start, len); i++) {
			Address j = addresses.get(i);
			Menu.row(addresses.indexOf(j) + "", j.getFirstName(), j.getLastName(), j.getEmail(), j.getPhone());
		}
		// if there's entries that have not been displayed ask the user if he
		// wants to see the next page
		if (len - 1 > start + listLen) {
			System.out.format("Page (%d/%d) Show More (Y/N)?: ", start / listLen + 1, addresses.size() / listLen + 1);
			if (getString().toUpperCase().equals("Y")) {
				browse(start + listLen);
			}
		}
	}

	/**
	 * gets user input for the entry
	 */
	private void createEntry() {
		Address address = new Address();
		System.out.print("First Name: ");
		address.setFirstName(getString());
		System.out.print("Last Name: ");
		address.setLastName(getString());
		System.out.print("Optional Email: ");
		String a = getString();
		address.setEmail((a.equals("")) ? "-" : a);
		System.out.print("Optional Phone: ");
		String b = getString();
		address.setPhone((b.equals("")) ? "-" : b);
		addresses.add(address);
	}

	/**
	 * deletes records if there are any
	 */
	private void deleteEntry() {
		if (!isEmpty()) {
			System.out.println("Current Records:");
			browse(0);
			System.out.print("\nIndex of the Record to be deleted: ");
			addresses.remove(getInt(0, addresses.size() - 1));
		}
	}

	private void search() {
		System.out.print("Enter your search query: ");
		String mask = getString();
		System.out.println("Matching the Database by " + mask);
		System.out.println();
		Menu.head();
		for (Address i : addresses) {
			if (i.search(mask)) {
				Menu.row(addresses.indexOf(i) + "", i.getFirstName(), i.getLastName(), i.getEmail(), i.getPhone());
			}
		}
	}

	/**
	 * cleans up
	 */
	private void exit() {
		scan.close();
		db.push();
		System.out.println("until next time");
	}

	/**
	 * checks weather addresses is empty and prints error
	 * 
	 * @return
	 */
	private boolean isEmpty() {
		if (addresses.isEmpty()) {
			System.err.println("\nThere are no addresses to delete\n");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param rangeMin
	 * @param rangeMax
	 * @return
	 */
	private int getInt(int rangeMin, int rangeMax) {
		int input = 0;
		try {
			input = scan.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Your input is not a number try again:");
			scan.nextLine();
			getInt(rangeMin, rangeMax);
		}
		if (input >= rangeMin && input <= rangeMax) {
			return input;
		} else {
			System.err.println("The input is in an invalid range");
			System.err.print("Try again: ");
			return getInt(rangeMin, rangeMax);
		}
	}

	/**
	 * 
	 * @return
	 */
	private String getString() {
		String out = "";
		try {
			out = scan.next();
			if (out.equals("")) {
				System.err.println("Invalid input");
				getString();
			} else
				return out;
		} catch (NoSuchElementException e) {
			System.err.println("Invalid input");
			getString();
		}
		return out;
	}
}
