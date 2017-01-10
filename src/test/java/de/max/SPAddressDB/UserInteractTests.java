package de.max.SPAddressDB;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class UserInteractTests extends UserInteract {

	@Test
	public void TestGetString(){
		//ByteArrayInputStream in = new ByteArrayInputStream("2\n\n\n".getBytes());
		//System.setIn(in);
		//assertEquals("2",getString(false));
	}
	@Test
	public void TestGetRange1To6() {
		int[] out = getRange("1-6");
		int[] a = {1, 2, 3, 4, 5, 6};
		assertArrayEquals(a, out);
	}
	/**
	 *
	 */
	@Test
	public void TestGetRange1To6V2() {
		int[] out = getRange("1;6");
		int[] a = {1, 6};
		assertArrayEquals(a, out);
	}
	/**
	 *
	 */
	@Test
	public void TestGetRange6And1() {
		int[] out = getRange("6;1");
		int[] a = {1, 6};
		assertArrayEquals(a, out);
	}
	/**
	 *
	 */
	@Test
	public void TestGetRangeSeperatedList1() {
		int[] out = getRange("1,5,8,9");
		int[] a = {1, 5, 8, 9};
		assertArrayEquals(a, out);
	}
	/**
	 *
	 */
	@Test(expected = InputMismatchException.class)
	public void TestGetRangeException() {
		int[] out = getRange("dcklsfksdf-asdasd");
	}
	/**
	 *
	 */
	@Test
	public void TestGetRangeSeperatedList2() {
		int[] out = getRange("1;5;8;9");
		int[] a = {1, 5, 8, 9};
		assertArrayEquals(a, out);
	}

	/**
	 *
	 */
	@Test
	public void TestGetRangeSperatedList3() {
		int[] out = getRange("1.5.8.9");
		int[] a = {1, 5, 8, 9};
		assertArrayEquals(a, out);
	}

	/**
	 *
	 */
	@Test
	public void TestGetRangeSperatedList4() {
		int[] out = getRange("6.5;4;1,5-10");
		int[] a = {1, 4, 5, 6, 7, 8, 9, 10};
		assertArrayEquals(a, out);
	}

}
