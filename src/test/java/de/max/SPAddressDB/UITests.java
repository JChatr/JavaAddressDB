package de.max.SPAddressDB;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Junit Tests for the UI printed to the console
 */
public class UITests {
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
	 * tests if the print head method prints the correct output to the console
	 */
	@Test
	public void testHeadPrintOut() {
		UI u = new UI();
		u.head();
		assertEquals("|             ID|     First Name|      Last Name|          Email|          Phone|\n"
						+ "|---------------|---------------|---------------|---------------|---------------|\n",
				consoleOutput.toString());
	}

	/**
	 * tests if when only 2 arguments are passed that the remaining columns get filled.
	 * Also makes sure that if the strings are shorter they stay right aligned
	 */
	@Test
	public void testRowPrintOneArgSpaceFilling() {
		UI u = new UI();
		u.row("+++", "---");
		assertEquals("|            +++|            ---|            +++|            ---|            +++|\n",
				consoleOutput.toString());
	}

	/**
	 * tests if when only 1 argument is passed that the remaining columns get filled.
	 * Also makes sure that if the strings is linger they stay right aligned
	 */
	@Test
	public void testRowPrintOneArgOverflow() {
		UI u = new UI();
		u.row("123456789123456789");
		assertEquals("|123456789123456|123456789123456|123456789123456|123456789123456|123456789123456|\n",
				consoleOutput.toString());
	}

	/**
	 * tests if when more arguments than columns are passed that no overflow occurs
	 * Also makes sure that if the strings are shorter they stay right aligned
	 */
	@Test
	public void testRowPrintMoreArgsFilling() {
		UI u = new UI();
		u.row("1", "2", "3", "4", "5", "6", "7", "8");
		assertEquals("|              1|              2|              3|              4|              5|\n",
				consoleOutput.toString());
	}

	/**
	 * tests if when only 2 arguments are passed that the remaining columns get filled.
	 * Also makes sure that if the strings are shorter they stay right aligned
	 */
	@Test
	public void testRowPrintMoreArgsRepeating() {
		UI u = new UI();
		u.row("1", "2");
		assertEquals("|              1|              2|              1|              2|              1|\n",
				consoleOutput.toString());
	}
}
