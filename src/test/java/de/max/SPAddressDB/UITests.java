package de.max.SPAddressDB;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by max on 10.01.17.
 */
public class UITests {
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
	public void testHeadPrintOut() {
		UI u = new UI();
		u.head();
		assertEquals("|             ID|     First Name|      Last Name|          Email|          Phone|\n"
						+ "|---------------|---------------|---------------|---------------|---------------|\n",
				consoleOutput.toString());
	}

	@Test
	public void testRowPrintOneArgSpaceFilling() {
		UI u = new UI();
		u.row("+++", "---");
		assertEquals("|            +++|            ---|            +++|            ---|            +++|\n",
				consoleOutput.toString());
	}

	@Test
	public void testRowPrintOneArgOverflow() {
		UI u = new UI();
		u.row("123456789123456789");
		assertEquals("|123456789123456|123456789123456|123456789123456|123456789123456|123456789123456|\n",
				consoleOutput.toString());
	}

	@Test
	public void testRowPrintMoreArgsFilling() {
		UI u = new UI();
		u.row("1", "2", "3", "4", "5", "6", "7", "8");
		assertEquals("|              1|              2|              3|              4|              5|\n",
				consoleOutput.toString());
	}

	@Test
	public void testRowPrintMoreArgsRepeating() {
		UI u = new UI();
		u.row("1", "2");
		assertEquals("|              1|              2|              1|              2|              1|\n",
				consoleOutput.toString());
	}


}
