package de.max.SPAddressDB;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class UserInteractTests {
	private ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();

	/**
	 * runs before every test to redirect the standard output stream to be read by the
	 * tests generating that output
	 */
	@Before
	public void prepareTests() {
		System.setOut(new PrintStream(consoleOutput));
		try {
			Files.delete(Paths.get("." + File.separator + "DB.txt"));
		} catch (IOException e) {
		}
	}

	/**
	 * runs after every test
	 * resets the redirection to System.out and clears the output stream
	 */
	@After
	public void resetTestPreparations() {
		System.setOut(System.out);
		try {
			Files.delete(Paths.get("." + File.separator + "DB.txt"));
		} catch (IOException e) {
		}
		consoleOutput.reset();
	}


	/**
	 * tests if the Address DB Driver runs displays an empty Database as expected
	 */
	@Test
	public void testBrowseEmptyList() {
		ByteArrayInputStream in = new ByteArrayInputStream(("0\n5\n").getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		u.run();
		assertEquals("*-------------------------*\n" +
				"|                         |\n" +
				"|  Java Address manager:  |\n" +
				"|                         |\n" +
				"*-------------------------*\n" +
				"\n" +
				"\n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: \n" +
				"Current records:\n" +
				"|             ID|     First Name|      Last Name|          Email|          Phone|\n" +
				"|---------------|---------------|---------------|---------------|---------------|\n" +
				"\n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: until next time\n", consoleOutput.toString());
		System.setIn(System.in);
	}

	/**
	 * tests if the Address DB Driver runs displays an multi page Database as expected
	 */
	@Test
	public void testBrowseMultiPageList() {
		String commands = "0\n" +
				"2\n" +
				"first\n" +
				"last\n" +
				"email\n" +
				"phone\n" +

				"2\n" +
				"first\n" +
				"last\n" +
				"email\n" +
				"phone\n" +

				"2\n" +
				"first\n" +
				"last\n" +
				"email\n" +
				"phone\n" +

				"2\n" +
				"first\n" +
				"last\n" +
				"email\n" +
				"phone\n" +

				"2\n" +
				"first\n" +
				"last\n" +
				"email\n" +
				"phone\n" +

				"2\n" +
				"first\n" +
				"last\n" +
				"email\n" +
				"phone\n" +

				"2\n" +
				"first\n" +
				"last\n" +
				"email\n" +
				"phone\n" +

				"2\n" +
				"first\n" +
				"last\n" +
				"email\n" +
				"phone\n" +

				"2\n" +
				"first\n" +
				"last\n" +
				"email\n" +
				"phone\n" +

				"2\n" +
				"first\n" +
				"last\n" +
				"email\n" +
				"phone\n" +

				"2\n" +
				"first\n" +
				"last\n" +
				"email\n" +
				"phone\n" +

				"2\n" +
				"first\n" +
				"last\n" +
				"email\n" +
				"phone\n" +

				"2\n" +
				"first\n" +
				"last\n" +
				"email\n" +
				"phone\n" +
				"0\n" +
				"0\n" +
				"5\n";
		ByteArrayInputStream in = new ByteArrayInputStream(commands.getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		u.run();
		assertEquals("*-------------------------*\n" +
				"|                         |\n" +
				"|  Java Address manager:  |\n" +
				"|                         |\n" +
				"*-------------------------*\n" +
				"\n" +
				"\n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: \n" +
				"Current records:\n" +
				"|             ID|     First Name|      Last Name|          Email|          Phone|\n" +
				"|---------------|---------------|---------------|---------------|---------------|\n" +
				"\n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: \n" +
				"Current records:\n" +
				"|             ID|     First Name|      Last Name|          Email|          Phone|\n" +
				"|---------------|---------------|---------------|---------------|---------------|\n" +
				"|              1|          first|           last|          email|          phone|\n" +
				"|              2|          first|           last|          email|          phone|\n" +
				"|              3|          first|           last|          email|          phone|\n" +
				"|              4|          first|           last|          email|          phone|\n" +
				"|              5|          first|           last|          email|          phone|\n" +
				"|              6|          first|           last|          email|          phone|\n" +
				"|              7|          first|           last|          email|          phone|\n" +
				"|              8|          first|           last|          email|          phone|\n" +
				"|              9|          first|           last|          email|          phone|\n" +
				"Page (1/2) Type 0 to exit. Show page: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: until next time\n", consoleOutput.toString());
		System.setIn(System.in);
	}

	/**
	 * tests if the Address DB Driver displays no elements when the search query is invalid
	 */
	@Test
	public void testSearchNonExistent() {
		ByteArrayInputStream in = new ByteArrayInputStream("1\nj\n5\n".getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		u.run();
		assertEquals("*-------------------------*\n" +
						"|                         |\n" +
						"|  Java Address manager:  |\n" +
						"|                         |\n" +
						"*-------------------------*\n" +
						"\n" +
						"\n" +
						"Pick one of the following options:\n" +
						"\n" +
						"0: Browse Database entries\n" +
						"1: Search the Database\n" +
						"2: Create new entry\n" +
						"3: Delete an entry\n" +
						"4: Modify an existing entry\n" +
						"5: Exit\n" +
						"Your choice: Enter your search query: Matching the Database by j\n" +
						"\n" +
						"|             ID|     First Name|      Last Name|          Email|          Phone|\n" +
						"|---------------|---------------|---------------|---------------|---------------|\n" +
						"\n" +
						"Pick one of the following options:\n" +
						"\n" +
						"0: Browse Database entries\n" +
						"1: Search the Database\n" +
						"2: Create new entry\n" +
						"3: Delete an entry\n" +
						"4: Modify an existing entry\n" +
						"5: Exit\n" +
						"Your choice: until next time\n",
				consoleOutput.toString());
		System.setIn(System.in);
	}

	/**
	 * tests if the Address DB Driver displays all matching entries when the search query is valid
	 */
	@Test
	public void testSearchExistent() {
		ByteArrayInputStream in = new ByteArrayInputStream(("2\n" +
				"01010\n" +
				"010101\n" +
				"ß1ß1ß\n" +
				"ß1ß1ß1ß\n" +
				"1\n" +
				"01\n" +
				"5\n").getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		u.run();
		assertEquals("*-------------------------*\n" +
				"|                         |\n" +
				"|  Java Address manager:  |\n" +
				"|                         |\n" +
				"*-------------------------*\n" +
				"\n" +
				"\n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: Enter your search query: Matching the Database by 01\n" +
				"\n" +
				"|             ID|     First Name|      Last Name|          Email|          Phone|\n" +
				"|---------------|---------------|---------------|---------------|---------------|\n" +
				"|              1|          01010|         010101|          ß1ß1ß|        ß1ß1ß1ß|\n" +
				"\n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: until next time\n", consoleOutput.toString());
		System.setIn(System.in);
	}

	/**
	 * tests if the Address DB Driver modifies entries correctly
	 */
	@Test
	public void testModifyEntryThenShow() {
		ByteArrayInputStream in = new ByteArrayInputStream(("2\n" +
				"01010\n" +
				"010101\n" +
				"ß1ß1ß\n" +
				"ß1ß1ß1ß\n" +
				"4\n" +
				"1\n" +
				"John\n" +
				"Doe\n" +
				"email@mymail.com\n" +
				"+490115155\n" +
				"5\n").getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		u.run();
		assertEquals("*-------------------------*\n" +
				"|                         |\n" +
				"|  Java Address manager:  |\n" +
				"|                         |\n" +
				"*-------------------------*\n" +
				"\n" +
				"\n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: \n" +
				"Current records:\n" +
				"|             ID|     First Name|      Last Name|          Email|          Phone|\n" +
				"|---------------|---------------|---------------|---------------|---------------|\n" +
				"|              1|          01010|         010101|          ß1ß1ß|        ß1ß1ß1ß|\n" +
				"\n" +
				"Index of the Record to be edited: You can now edit the fields. Leave out fields to keep old data.\n" +
				"First Name: Last Name: Optional Email: Optional Phone: \n" +
				" successfully modified the entry:\n" +
				"|             ID|     First Name|      Last Name|          Email|          Phone|\n" +
				"|---------------|---------------|---------------|---------------|---------------|\n" +
				"|              1|           John|            Doe|email@mymail.co|     +490115155|\n" +
				"\n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: until next time\n", consoleOutput.toString());
	}

	/**
	 * tests if the Address DB Driver allows to modify an entry and then change none it's fields
	 */
	@Test
	public void testModifyEntryAllFieldsBlank() {
		ByteArrayInputStream in = new ByteArrayInputStream(("2\n" +
				"01010\n" +
				"010101\n" +
				"ß1ß1ß\n" +
				"ß1ß1ß1ß\n" +
				"4\n" +
				"1\n" +
				"\n" +
				"\n" +
				"\n" +
				"\n" +
				"5\n").getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		u.run();
		assertEquals("*-------------------------*\n" +
				"|                         |\n" +
				"|  Java Address manager:  |\n" +
				"|                         |\n" +
				"*-------------------------*\n" +
				"\n" +
				"\n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: \n" +
				"Current records:\n" +
				"|             ID|     First Name|      Last Name|          Email|          Phone|\n" +
				"|---------------|---------------|---------------|---------------|---------------|\n" +
				"|              1|          01010|         010101|          ß1ß1ß|        ß1ß1ß1ß|\n" +
				"\n" +
				"Index of the Record to be edited: You can now edit the fields. Leave out fields to keep old data.\n" +
				"First Name: Last Name: Optional Email: Optional Phone: \n" +
				" successfully modified the entry:\n" +
				"|             ID|     First Name|      Last Name|          Email|          Phone|\n" +
				"|---------------|---------------|---------------|---------------|---------------|\n" +
				"|              1|          01010|         010101|          ß1ß1ß|        ß1ß1ß1ß|\n" +
				"\n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: until next time\n", consoleOutput.toString());
	}

	/**
	 * tests if the Address DB Driver correctly deletes a single entry
	 */
	@Test
	public void testDeleteEntrySingleDelete() {
		ByteArrayInputStream in = new ByteArrayInputStream(("2\n" +
				"01010\n" +
				"010101\n" +
				"ß1ß1ß\n" +
				"ß1ß1ß1ß\n" +
				"3\n" +
				"1\n" +
				"5\n").getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		u.run();
		assertEquals("*-------------------------*\n" +
				"|                         |\n" +
				"|  Java Address manager:  |\n" +
				"|                         |\n" +
				"*-------------------------*\n" +
				"\n" +
				"\n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: Current Records:\n" +
				"\n" +
				"Current records:\n" +
				"|             ID|     First Name|      Last Name|          Email|          Phone|\n" +
				"|---------------|---------------|---------------|---------------|---------------|\n" +
				"|              1|          01010|         010101|          ß1ß1ß|        ß1ß1ß1ß|\n" +
				"\n" +
				"Index of the Record to be deleted: Successfully removed 1 entries\n" +
				"\n" +
				"\n" +
				"\n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: until next time\n", consoleOutput.toString());

	}

	/**
	 * tests if the Address DB Driver correctly deletes a range of multiple entries
	 */
	@Test
	public void testDeleteEntryRangeDelete() {
		ByteArrayInputStream in = new ByteArrayInputStream(("2\n" +
				"01010\n" +
				"010101\n" +
				"ß1ß1ß\n" +
				"ß1ß1ß1ß\n" +

				"2\n" +
				"01010\n" +
				"010101\n" +
				"ß1ß1ß\n" +
				"ß1ß1ß1ß\n" +

				"2\n" +
				"01010\n" +
				"010101\n" +
				"ß1ß1ß\n" +
				"ß1ß1ß1ß\n" +

				"2\n" +
				"01010\n" +
				"010101\n" +
				"ß1ß1ß\n" +
				"ß1ß1ß1ß\n" +

				"2\n" +
				"01010\n" +
				"010101\n" +
				"ß1ß1ß\n" +
				"ß1ß1ß1ß\n" +

				"2\n" +
				"01010\n" +
				"010101\n" +
				"ß1ß1ß\n" +
				"ß1ß1ß1ß\n" +

				"2\n" +
				"01010\n" +
				"010101\n" +
				"ß1ß1ß\n" +
				"ß1ß1ß1ß\n" +

				"2\n" +
				"01010\n" +
				"010101\n" +
				"ß1ß1ß\n" +
				"ß1ß1ß1ß\n" +

				"2\n" +
				"01010\n" +
				"010101\n" +
				"ß1ß1ß\n" +
				"ß1ß1ß1ß\n" +

				"2\n" +
				"01010\n" +
				"010101\n" +
				"ß1ß1ß\n" +
				"ß1ß1ß1ß\n" +

				"3\n" +
				"1-8\n" +
				"0\n" +
				"5\n").getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		u.run();
		assertEquals("*-------------------------*\n" +
				"|                         |\n" +
				"|  Java Address manager:  |\n" +
				"|                         |\n" +
				"*-------------------------*\n" +
				"\n" +
				"\n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: First Name: Last Name: Optional Email: Optional Phone: \n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: Current Records:\n" +
				"\n" +
				"Current records:\n" +
				"|             ID|     First Name|      Last Name|          Email|          Phone|\n" +
				"|---------------|---------------|---------------|---------------|---------------|\n" +
				"|              1|          01010|         010101|          ß1ß1ß|        ß1ß1ß1ß|\n" +
				"|              2|          01010|         010101|          ß1ß1ß|        ß1ß1ß1ß|\n" +
				"|              3|          01010|         010101|          ß1ß1ß|        ß1ß1ß1ß|\n" +
				"|              4|          01010|         010101|          ß1ß1ß|        ß1ß1ß1ß|\n" +
				"|              5|          01010|         010101|          ß1ß1ß|        ß1ß1ß1ß|\n" +
				"|              6|          01010|         010101|          ß1ß1ß|        ß1ß1ß1ß|\n" +
				"|              7|          01010|         010101|          ß1ß1ß|        ß1ß1ß1ß|\n" +
				"|              8|          01010|         010101|          ß1ß1ß|        ß1ß1ß1ß|\n" +
				"|              9|          01010|         010101|          ß1ß1ß|        ß1ß1ß1ß|\n" +
				"\n" +
				"Index of the Record to be deleted: Successfully removed 8 entries\n" +
				"\n" +
				"\n" +
				"\n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: \n" +
				"Current records:\n" +
				"|             ID|     First Name|      Last Name|          Email|          Phone|\n" +
				"|---------------|---------------|---------------|---------------|---------------|\n" +
				"|              9|          01010|         010101|          ß1ß1ß|        ß1ß1ß1ß|\n" +
				"|             10|          01010|         010101|          ß1ß1ß|        ß1ß1ß1ß|\n" +
				"\n" +
				"Pick one of the following options:\n" +
				"\n" +
				"0: Browse Database entries\n" +
				"1: Search the Database\n" +
				"2: Create new entry\n" +
				"3: Delete an entry\n" +
				"4: Modify an existing entry\n" +
				"5: Exit\n" +
				"Your choice: until next time\n", consoleOutput.toString());

	}

	/**
	 * tests if the correct range is returned when "1-2" is called
	 */
	@Test
	public void testGetIntRange() {
		ByteArrayInputStream in = new ByteArrayInputStream("1-2\n".getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		assertArrayEquals(new int[]{1, 2}, u.getInt(0, 10));
		System.setIn(System.in);
	}

	/**
	 * tests if the correct range is returned when multiple ranges are entered
	 */
	@Test
	public void testGetIntInvalidRange() {
		ByteArrayInputStream in = new ByteArrayInputStream("1-2\n3-5\n6-7\n".getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		assertArrayEquals(new int[]{6, 7}, u.getInt(5, 10));
		System.setIn(System.in);
	}

	/**
	 * tests if the correct range is returned when a single digit is entered
	 */
	@Test
	public void testGetIntSingle() {
		ByteArrayInputStream in = new ByteArrayInputStream("5\n".getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		assertArrayEquals(new int[]{5}, u.getInt(5, 10));
		System.setIn(System.in);
	}

	/**
	 * tests if the same string as the one that was entered gets returned
	 * when the string consists of Numbers
	 */
	@Test
	public void testGetStringNumber() {
		ByteArrayInputStream in = new ByteArrayInputStream("2\n".getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		assertEquals("2", u.getString(false));
		System.setIn(System.in);
	}

	/**
	 * tests if the same string as the one that was entered gets returned
	 * when the string consists of characters
	 */
	@Test
	public void testGetStringChars() {
		ByteArrayInputStream in = new ByteArrayInputStream("this is a word\n".getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		assertEquals("this is a word", u.getString(false));
		System.setIn(System.in);
	}

	/**
	 * tests if the same string as the one that was entered gets returned
	 * when the string consists of newline char
	 */
	@Test
	public void testGetStringOptional() {
		ByteArrayInputStream in = new ByteArrayInputStream("\n".getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		assertEquals("", u.getString(true));
		System.setIn(System.in);
	}

	/**
	 * tests if the same string as the one that was entered gets returned
	 * if the newline chars get removed
	 */
	@Test
	public void testGetStringInvalid() {
		ByteArrayInputStream in = new ByteArrayInputStream("\n\n\nasd\n".getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		assertEquals("asd", u.getString(false));
		System.setIn(System.in);
	}

	/**
	 * tests if the passed in range is evaluated to the correct array.
	 * here the range is all integeers form 1-6
	 */
	@Test
	public void testGetRange1To6() {
		UserInteract u = new UserInteract();
		int[] out = u.getRange("1-6");
		int[] a = {1, 2, 3, 4, 5, 6};
		assertArrayEquals(a, out);
	}

	/**
	 * tests if the passed in range is evaluated to the correct array.
	 * here the range is all integers form 1-6
	 */
	@Test
	public void testGetRange1To6V2() {
		UserInteract u = new UserInteract();
		int[] out = u.getRange("1;6");
		int[] a = {1, 6};
		assertArrayEquals(a, out);
	}

	/**
	 * tests if the passed in range is evaluated to the correct array.
	 * here the range is the integers 1,6
	 */
	@Test
	public void testGetRange6And1() {
		UserInteract u = new UserInteract();
		int[] out = u.getRange("6;1");
		int[] a = {1, 6};
		assertArrayEquals(a, out);
	}

	/**
	 * tests if the passed in range is evaluated to the correct array.
	 * here the range is the integers 1,5,6,9 with the , separator
	 */
	@Test
	public void testGetRangeSeparatedList1() {
		UserInteract u = new UserInteract();
		int[] out = u.getRange("1,5,8,9");
		int[] a = {1, 5, 8, 9};
		assertArrayEquals(a, out);
	}

	/**
	 * tests if the passed in range is evaluated to the correct array.
	 * here the range is invalid so and Exception is thrown
	 */
	@Test(expected = InputMismatchException.class)
	public void testGetRangeException() {
		UserInteract u = new UserInteract();
		u.getRange("dcklsfksdf-asdasd");
	}

	/**
	 * tests if the passed in range is evaluated to the correct array.
	 * here the range is the integers 1,5,8,9 with the ; separator
	 */
	@Test
	public void testGetRangeSeparatedList2() {
		UserInteract u = new UserInteract();
		int[] out = u.getRange("1;5;8;9");
		int[] a = {1, 5, 8, 9};
		assertArrayEquals(a, out);
	}

	/**
	 * tests if the passed in range is evaluated to the correct array.
	 * here the range is the integers 1,5,8,9 with the . seperator
	 */
	@Test
	public void testGetRangeSeparatedList3() {
		UserInteract u = new UserInteract();
		int[] out = u.getRange("1.5.8.9");
		int[] a = {1, 5, 8, 9};
		assertArrayEquals(a, out);
	}

	/**
	 * tests if the passed in range is evaluated to the correct array.
	 * here a combination of ranges and single selections is tested
	 */
	@Test
	public void testGetRangeSeparatedList4() {
		UserInteract u = new UserInteract();
		int[] out = u.getRange("6.5;4;1,5-10");
		int[] a = {1, 4, 5, 6, 7, 8, 9, 10};
		assertArrayEquals(a, out);
	}

}
