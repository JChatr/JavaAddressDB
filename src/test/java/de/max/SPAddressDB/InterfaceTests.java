package de.max.SPAddressDB;

import static org.junit.Assert.*;

import java.util.InputMismatchException;

import org.junit.Test;

public class InterfaceTests extends UserInteract {

	// testing of the getRange method
	@Test
	public void getRange1() {
		int[] out = getRange("1-6");
		int[] a = {1, 2, 3, 4, 5, 6};
		assertArrayEquals(a, out);
	}
	@Test
	public void getRange2() {
		int[] out = getRange("1;6");
		int[] a = {1, 6};
		assertArrayEquals(a, out);
	}
	@Test
	public void getRange3() {
		int[] out = getRange("6;1");
		int[] a = {1,6};
		assertArrayEquals(a, out);
	}
	@Test
	public void getRange4() {
		int[] out = getRange("1,5,8,9");
		int[] a = {1,5,8,9};
		assertArrayEquals(a, out);
	}
	@Test(expected=InputMismatchException.class)
	public void getRange5() {
		int[] out = getRange("dcklsfksdf-asdasd");
	}
	@Test
	public void getRange6() {
		int[] out = getRange("1;5;8;9");
		int[] a = {1,5,8,9};
		assertArrayEquals(a, out);
	}
	@Test
	public void getRange7() {
		int[] out = getRange("1.5.8.9");
		int[] a = {1,5,8,9};
		assertArrayEquals(a, out);
	}
	@Test
	public void getRange8() {
		int[] out = getRange("6.5;4;1,5-10");
		int[] a = {1,4,5,6,7,8,9,10};
		assertArrayEquals(a, out);
	}
	
}
