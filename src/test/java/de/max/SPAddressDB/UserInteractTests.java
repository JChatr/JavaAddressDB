package de.max.SPAddressDB;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class UserInteractTests {
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
	public void testSearchNonExistent(){
		ByteArrayInputStream in = new ByteArrayInputStream("0\nJohn\n".getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		u.run();
		assertEquals("awd",
				consoleOutput.toString());
		System.setIn(System.in);
	}
	@Test
	public void testGetIntRange() {
		ByteArrayInputStream in = new ByteArrayInputStream("1-2\n".getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		assertArrayEquals(new int[]{1, 2}, u.getInt(0, 10));
		System.setIn(System.in);
	}

	@Test
	public void testGetIntInvalidRange() {
		ByteArrayInputStream in = new ByteArrayInputStream("1-2\n3-5\n6-7\n".getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		assertArrayEquals(new int[]{6, 7}, u.getInt(5, 10));
		System.setIn(System.in);
	}

	@Test
	public void testGetIntSingle() {
		ByteArrayInputStream in = new ByteArrayInputStream("5\n".getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		assertArrayEquals(new int[]{5}, u.getInt(5, 10));
		System.setIn(System.in);
	}


	@Test
	public void testGetStringNumber() {
		ByteArrayInputStream in = new ByteArrayInputStream("2\n".getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		assertEquals("2", u.getString(false));
		System.setIn(System.in);
	}

	@Test
	public void testGetStringChars() {
		ByteArrayInputStream in = new ByteArrayInputStream("this is a word\n".getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		assertEquals("this is a word", u.getString(false));
		System.setIn(System.in);
	}

	@Test
	public void testGetStringOptional() {
		ByteArrayInputStream in = new ByteArrayInputStream("\n".getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		assertEquals("", u.getString(true));
		System.setIn(System.in);
	}

	@Test
	public void testGetStringInvalid() {
		ByteArrayInputStream in = new ByteArrayInputStream("\n\n\nasd\n".getBytes());
		System.setIn(in);
		UserInteract u = new UserInteract();
		assertEquals("asd", u.getString(false));
		System.setIn(System.in);
	}

	@Test
	public void testGetRange1To6() {
		UserInteract u = new UserInteract();
		int[] out = u.getRange("1-6");
		int[] a = {1, 2, 3, 4, 5, 6};
		assertArrayEquals(a, out);
	}

	/**
	 *
	 */
	@Test
	public void testGetRange1To6V2() {
		UserInteract u = new UserInteract();
		int[] out = u.getRange("1;6");
		int[] a = {1, 6};
		assertArrayEquals(a, out);
	}

	/**
	 *
	 */
	@Test
	public void testGetRange6And1() {
		UserInteract u = new UserInteract();
		int[] out = u.getRange("6;1");
		int[] a = {1, 6};
		assertArrayEquals(a, out);
	}

	/**
	 *
	 */
	@Test
	public void testGetRangeSeparatedList1() {
		UserInteract u = new UserInteract();
		int[] out = u.getRange("1,5,8,9");
		int[] a = {1, 5, 8, 9};
		assertArrayEquals(a, out);
	}

	/**
	 *
	 */
	@Test(expected = InputMismatchException.class)
	public void testGetRangeException() {
		UserInteract u = new UserInteract();
		u.getRange("dcklsfksdf-asdasd");
	}

	/**
	 *
	 */
	@Test
	public void testGetRangeSeparatedList2() {
		UserInteract u = new UserInteract();
		int[] out = u.getRange("1;5;8;9");
		int[] a = {1, 5, 8, 9};
		assertArrayEquals(a, out);
	}

	/**
	 *
	 */
	@Test
	public void testGetRangeSeparatedList3() {
		UserInteract u = new UserInteract();
		int[] out = u.getRange("1.5.8.9");
		int[] a = {1, 5, 8, 9};
		assertArrayEquals(a, out);
	}

	/**
	 *
	 */
	@Test
	public void testGetRangeSeparatedList4() {
		UserInteract u = new UserInteract();
		int[] out = u.getRange("6.5;4;1,5-10");
		int[] a = {1, 4, 5, 6, 7, 8, 9, 10};
		assertArrayEquals(a, out);
	}

}
