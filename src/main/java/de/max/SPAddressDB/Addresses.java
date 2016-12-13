package de.max.SPAddressDB;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeSet;

public class Addresses {
	private Scanner scan = new Scanner(System.in);
	// always up to date list
	private List<Address> addresses;
	// periodically updated list
	private Database<Address> db = new ListDB<>();
	private int lastIndex;
	private final int listLen = 10;

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
	 * recursive method that represents the main menu of the manager
	 */
	private void mainMenu() {
		System.out.println("\nPick one of the following options:\n");
		System.out.println("0: Browse Database entries");
		System.out.println("1: Search the Database");
		System.out.println("2: Create new entry");
		System.out.println("3: Delete an entry");
		System.out.println("4: Exit");
		System.out.println("5: Modify existing entry");
		
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
				exit();
				return;
			case 5 :
				modifyEntry();
				break;
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
			Menu.row(j.getId(), j.getFirstName(), j.getLastName(), j.getEmail(), j.getPhone());
		}
		if (len - 1 > 10) {
			System.out.format("Page (%d/%d) Type 0 to exit. Show page: ", start / listLen + 1, addresses.size() / listLen + 1);
			start = getInt(0, addresses.size() / listLen + 1)[0] - 1;
			if (start != -1) {
				browse(start*10);
			}
		}
	}

	/**
	 * gets user input for the entry
	 */
	private void createEntry() {
		lastIndex = addresses.isEmpty() ? 0 : Integer.parseInt(addresses.get(addresses.size() - 1).getId());
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
		addresses.add(address);
	}
	
	private void modifyEntry(){
		if (!isEmpty()) {
			System.out.println("Current Records:");
			browse(0);
			System.out.print("\nIndex of the Record to be edited: ");
			int input[] = getInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
			
			Address temp = addresses.get(input[0]);
			System.out.println("You can now edit the fields. Leave out fields to keep old data.");
			System.out.println("First Name: ");
			String in = getString(true);
			if(!in.equals("")){
				temp.setFirstName(in);
			}
			System.out.println("Last Name: ");
			in = getString(true);
			if(!in.equals("")){
				temp.setLastName(in);
			}
			System.out.println("Optional Email: ");
			in = getString(true);
			if(!in.equals("")){
				temp.setEmail(in);
			}
			System.out.println("Optional Phone: ");
			in = getString(true);
			if(!in.equals("")){
				temp.setPhone(in);
			}
			
			
			
		
		}
	}

	/**
	 * deletes records if there are any
	 */
	private void deleteEntry() {
		int removed = 0;
		if (!isEmpty()) {
			List<Address> deletion = new ArrayList<>();
			System.out.println("Current Records:");
			browse(0);
			System.out.print("\nIndex of the Record to be deleted: ");
			int[] input = getInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
			for (int i : input) {
				for (Address j : addresses) {
					if (j.getId().equals(i + "")){
						deletion.add(j);
						removed++;
					}
				}
			}
			// objects have to be deleted like this because of concurrency issues
			addresses.removeAll(deletion);
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
		Menu.head();
		for (Address i : addresses) {
			if (i.search(mask)) {
				Menu.row(i.getId(), i.getFirstName(), i.getLastName(), i.getEmail(), i.getPhone());
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
				getString(optionalField);
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
			TreeSet<Integer> range = new TreeSet<>();
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
