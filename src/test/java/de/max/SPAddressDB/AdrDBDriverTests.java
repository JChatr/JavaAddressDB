package de.max.SPAddressDB;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
/**
 * Created by max on 10.01.17.
 */
public class AdrDBDriverTests {
	private ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();

	@Before
	public void prepareOutputStream() {
		System.setOut(new PrintStream(consoleOutput));
	}

	@After
	public void resetOutputStream() {
		System.setOut(System.out);
		consoleOutput.reset();
	}

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
