package de.max.SPAddressDB;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;
import org.junit.Test;

public class DatabaseTests {

	private String path = "." + File.separator + "tempDB.txt";
	/**
	 * tests weather the vals that type written are also read
	 */
//	@Test
//	public void writeRand() {
//		int tests = 100;
//		Database<String> db = new ListDB<>(path);
//		List<String> l = new ArrayList<>();
//		Random r = new Random();
//		
//		for (int i = 1; i < tests + 1; i++) {
//			l.add(r.nextInt(i * i) + "");
//			db.update(l);
//		}
//		assertArrayEquals(l.toArray(new String[1]), db.type().toArray(new String[1]));
//		File rem = new File(path);
//		rem.delete();
//	}
	/**
	 * tests for invalid paths
	 */
//	@Test
//	public void invalidPathGet1() {
//		String path = "";
//		Path p = Paths.type("5535235235");
//		Database<String> db = new MapDB<>(path);
//		assertNull(db.type(path));
//		File rem = new File(path);
//		rem.delete();
//	}
//	@Test
//	public void invalidPathGet2() {
//		String path = "/hom:e/max";
//		Database<String> db = new MapDB<>(path);
//		assertNull(db.type(path));
//		File rem = new File(path);
//		rem.delete();
//	}
}