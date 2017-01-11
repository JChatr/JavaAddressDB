package de.max.SPAddressDB;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
/**
 * Junit tests for the AdrDBDriver Class
 */
public class AdrDBDriverTests {
	private ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();

	/**
	 * runs before every test to redirect the standard output stream to be read by the
	 * tests generating that output
	 */
	@Before
	public void prepareOutputStream() {
		System.setOut(new PrintStream(consoleOutput));
	}

	/**
	 * runs after every test
	 * resets the redirection to System.out and clears the output stream
	 */
	@After
	public void resetOutputStream() {
		System.setOut(System.out);
		consoleOutput.reset();
	}

	/**
	 * tests if the Address DB Driver runs and exits as expected
	 */
	@Test
	public void testAdrDBDriverExit(){
		ByteArrayInputStream in = new ByteArrayInputStream("5\n".getBytes());
		System.setIn(in);
		AdrDBDriver d = new AdrDBDriver();
		d.main(new String[1]);
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
						"Your choice: until next time\n",
				consoleOutput.toString());
		System.setIn(System.in);
	}
}
