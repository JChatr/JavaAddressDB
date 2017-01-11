
package de.max.SPAddressDB;

public class UI {

	private final static int COLS = 5;
	private final static int WIDTH = 15;
	private final static String COL = getCol(WIDTH);
	private final static String SEP = "|";

	static void head() {
		String[] in = {"ID", "First Name", "Last Name", "Email", "Phone"};
		row(in);
		row(COL);
	}

	 static void row(String... in) {
		if (in.length < COLS) {
			String[] filled = new String[COLS];
			for (int i = 0; i < filled.length; i++) {
				filled[i] =  in[i % in.length];
			}
			in = filled;
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

	 static String getCol(int a) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a; i++) {
			sb.append("-");
		}
		return sb.toString();
	}
}
