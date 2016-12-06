package de.max.SPAddressDB;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class DatabaseTests {

	/**
	 * tests weather the vals that get written are also read
	 */
	@Test
	public void writeRand() {
		int tests = 100;
		String path = "." + File.separator + "tempDB.txt";
//		String path = "/home/max/Desktop/nDB.txt";
		Database<String> db = new ListDB<>(path);
		List<String> l = new ArrayList<>();
		Random r = new Random();
		
		for (int i = 1; i < tests + 1; i++) {
			l.add(r.nextInt(i * i) + "");
			db.update(l);
		}
		Assert.assertArrayEquals(l.toArray(new String[1]), db.get().toArray(new String[1]));
		File rem = new File(path);
		rem.delete();
	}
	/**
	 * tests for invalid paths
	 */
	@Test
	public void invalidPathGet1() {
		String path = "";
		Path p = Paths.get("5535235235");
		Database<String> db = new ListDB<>();
		Assert.assertNull(db.get(path));
	}
	@Test
	public void invalidPathGet2() {
		String path = "/hom:e/max";
		Database<String> db = new ListDB<>();
		Assert.assertNull(db.get(path));
	}
}