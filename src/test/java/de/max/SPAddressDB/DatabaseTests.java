package de.max.SPAddressDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class DatabaseTests {

	/**
	 * tests the specified val in the set range;
	 * 
	 * @param min
	 * @param max
	 */
	@Test
	public void writeRand(int tests) {
		Database<String> db = new ListDB<>();
		List<String> l = new ArrayList<>();
		Random r = new Random();
		
		for (int i = 1; i < tests + 1; i++) {
			l.add(r.nextInt(i * i) + "");
			db.update(l);
		}
		
		Assert.assertArrayEquals(l.toArray(new String[1]), db.get().toArray(new String[1]));
	}
}