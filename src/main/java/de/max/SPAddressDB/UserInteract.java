package de.max.SPAddressDB;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;

public class UserInteract {
	private Scanner scan = new Scanner(System.in);
	// always up to date list
	private Map<String, Address> addresses;
	// periodically updated list
	private Database<String, Address> db = new MapDB<>();
	private int lastIndex;
	private final int displayLen = 10;

	/**
	 * This method is used to print the header,
	 * gets the database and starts the mainMenu method.
	 */
	public void run() {
		System.out.println("*-------------------------*");
		System.out.println("|                         |");
		System.out.println("|  Java Address manager:  |");
		System.out.println("|                         |");
		System.out.println("*-------------------------*");
		System.out.println();
		addresses = db.get();
		mainMenu();
	}

	/**
	 * This method is used to print the main menu.
	 * You are able to choose from an main menu entry.
	 * This method is recursive, it will only end when entry '5' is chosen. 
	 */
	private void mainMenu() {
		System.out.println("\nPick one of the following options:\n");
		System.out.println("0: Browse Database entries");
		System.out.println("1: Search the Database");
		System.out.println("2: Create new entry");
		System.out.println("3: Delete an entry");
		System.out.println("4: Modify an existing entry");
		System.out.println("5: Exit");
		
		System.out.print("Your choice: ");
		switch (getInt(0, 5)[0]) {
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
				modifyEntry();
				break;
			case 5 :
				exit();
				return;
		}
		db.update(addresses);
		mainMenu();
	}

	/**
	 * This method is used to print the database into the console.
	 * It will start at the offset 'offset' and will print 10 entries.
	 * @param Starts at the offset 'offset'.
	 */
	private void browse(int offset) {
		System.out.println("\nCurrent records:");
		List<Address> list = new ArrayList<>(addresses.values());
		int draw = offset;
		UI.head();
		// loop through the map and start printing at the offset value until the offset is reached
		list = list.subList(offset, addresses.size());
		for (Address j : list) {
			// is the current local index null?
			if (j == null) continue;
			if (++draw == displayLen + offset) break;
			UI.row(j.getId(), j.getFirstName(), j.getLastName(), j.getEmail(), j.getPhone());
		}
		if (draw < addresses.size()) {
			System.out.format("Page (%d/%d) Type 0 to exit. Show page: ", (draw - 1) / displayLen + 1, addresses.size() / displayLen + 1);
			offset = getInt(0, addresses.size() / displayLen + 1)[0];
			// recurse if the user requests another page
			if (offset != 0) { browse((offset - 1) * displayLen); }
		}
	}

	/**
	 * This method is used to create a new entry in the database.
	 * The user will be asked to enter the first name, last name and optional the email and phone number.
	 */
	private void createEntry() {
		if (addresses.isEmpty()) {
			lastIndex = 0;
		} else {
			Supplier<Integer> supp = () -> {
				String k = "";
				for (String i : addresses.keySet()){
					k = i;
				}; 
			return Integer.parseInt(k);
			};
			lastIndex = supp.get();
		}
		
		Address address = new Address();
		address.setId(++lastIndex + "");
		System.out.print("First Name: ");
			address.setFirstName(getString(false));
		System.out.print("Last Name: ");
			address.setLastName(getString(false));
		System.out.print("Optional Email: ");
			String a = getString(true);
			address.setEmail((a.equals("")) ? "-" : a);
		System.out.print("Optional Phone: ");
			String b = getString(true);
			address.setPhone((b.equals("")) ? "-" : b);
		addresses.put(lastIndex + "", address);
	}
	
	/**
	 * This method is used to modify an existing entry.
	 */
	private void modifyEntry(){
		if (!isEmpty()) {
			browse(0);
			System.out.print("\nIndex of the Record to be edited: ");
			int entry = getInt(Integer.MIN_VALUE, Integer.MAX_VALUE)[0];
			Address temp = addresses.get(entry + "");
			while(temp == null) {
				System.out.println("Entry not found. Try again!");
				entry = getInt(Integer.MIN_VALUE, Integer.MAX_VALUE)[0];
				temp = addresses.get(entry + "");
			}
			
			System.out.println("You can now edit the fields. Leave out fields to keep old data.");
			System.out.print("First Name: ");
				String in = getString(true);
				if(!in.equals(""))	temp.setFirstName(in);
			System.out.print("Last Name: ");
				in = getString(true);
				if(!in.equals(""))	temp.setLastName(in);
			System.out.print("Optional Email: ");
				in = getString(true);
				if(!in.equals(""))	temp.setEmail(in);
			System.out.print("Optional Phone: ");
				in = getString(true);
				if(!in.equals(""))	temp.setPhone(in);
				
			System.out.println("\n successfully modified the entry:");
			UI.head();
			UI.row(temp.getId(), temp.getFirstName(), temp.getLastName(), temp.getEmail(), temp.getPhone());
		} else {
			System.err.println("cannod modify entries of an empty database");;
		}
	}

	/**
	 * deletes records if there are any
	 */
	private void deleteEntry() {
		int removed = 0;
		if (!isEmpty()) {
			System.out.println("Current Records:");
			browse(0);
			System.out.print("\nIndex of the Record to be deleted: ");
			for (int i : getInt(Integer.MIN_VALUE, Integer.MAX_VALUE)) {
				Address j = addresses.get(i + "");
				if (j == null) continue;
				addresses.remove(i + "");
				removed++;
			}
			System.out.format("Successfully removed %d entries\n\n\n", removed);
		} else {
			System.err.println("Sorry,\n cannot delete entrys form an empty database");
		}
	}

	private void search() {
		System.out.print("Enter your search query: ");
		String mask = getString(false);
		System.out.println("Matching the Database by " + mask);
		System.out.println();
		UI.head();
		for (Map.Entry<String, Address> i : addresses.entrySet()) {
			Address ad = i.getValue();
			if (ad.search(mask)) {
				UI.row(i.getKey() + "", ad.getFirstName(), ad.getLastName(), ad.getEmail(), ad.getPhone());
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
			System.err.println("\nThere are no addresses!\n");
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
	private int[] getInt(int rangeMin, int rangeMax) {
		int[] input;
		try {
			input = getRange(scan.next());
			scan.nextLine();
		} catch (InputMismatchException e) {
			System.err.print("Your input is not valid \nTry again: ");
			return getInt(rangeMin, rangeMax);	
		}
		if (input.length !=0 && input[0] >= rangeMin && input[input.length - 1] <= rangeMax) {
			return input;
		} else {
			System.err.println("The input is in an invalid range\nTry again: ");
			return getInt(rangeMin, rangeMax);
		}
	}

	/**
	 * 
	 * @return
	 */
	private String getString(boolean optionalField) {
		String out = "";
		try {
			out = scan.nextLine();
			if (!optionalField && out.equals("")) {
				System.err.println("Invalid input");
				out = getString(optionalField);
			} else
				return out;
		} catch (NoSuchElementException e) {
			System.err.println("Invalid input");
			getString(optionalField);
		}
		return out;
	}
	
	/**
	 * does some basic parsing on the range
	 * any parse exceptions will bubble up (NumberFormatExecption) 
	 * @param in
	 * @return
	 * @throws InputMismatchException
	 */
	private int[] getRange(String in) {
		try {
			Set<Integer> range = new TreeSet<>();
			// do first split on input removing all explicit delimiter
			String[] exp = in.split("\\;|\\.|,|&");
			for (String i : exp) {
				// split the already split input again to get any possible ranges
				String[] tmp = i.split("\\D+");
				if (tmp.length > 2) {
					// if the input contains a separated list
					for (String j : tmp) {
						range.add(Integer.parseInt(j));
					}
				} else {
					// if the input is a range
					for (int k = Integer.parseInt(tmp[0]); k <= Integer.parseInt(tmp[tmp.length -1]); k++) {
						range.add(k);
					}
				}
			}
			// painful conversion of the sorted set to an int[]
			int[] out = new int[range.size()];
			Iterator<Integer> it = range.iterator();
			int i = 0;
			while (it.hasNext()) {
				out[i++] = it.next();
			}
			return out;
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			// this converts the out of bounds exception on a parse error to an 
			// InputMismatch one to give some better context to what is going on
			throw new InputMismatchException();
		}
	}
}
