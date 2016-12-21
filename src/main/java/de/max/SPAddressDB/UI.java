
package de.max.SPAddressDB;

import java.util.Arrays;

public class UI {

	private final static int COLS = 5;
	private final static int WIDTH = 15;
	private final static String COL = getCol(WIDTH);
	private final static String SEP = "|";

	/**
	 * This method is used to create the header 
	 */
	public static void head() {
		String[] in = {"ID", "Frist Name", "Last Name", "Email", "Phone"};
		row(in);
		row(COL);
	}

	public static void row(String... in) {
		if (in.length < COLS) {
			String[] t = new String[COLS];
			Arrays.fill(t, in[0]);
			in = t;
		}
		System.out.print(SEP);
		for (int i = 0; i < COLS; i++) {
			if (in[i].length() > COL.length())
				System.out.format("%" + WIDTH + "s%s", in[i].substring(0, COL.length()), SEP);
			else {
				System.out.format("%" + WIDTH + "s%s", in[i], SEP);
			}
		}
		System.out.println();
	}

	private static String getCol(int a) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a; i++) {
			sb.append("-");
		}
		return sb.toString();
	}
}
