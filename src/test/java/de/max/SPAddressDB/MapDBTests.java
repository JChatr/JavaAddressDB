package de.max.SPAddressDB;

import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import static org.junit.Assert.*;

public class MapDBTests {


	/**
	 * tests weather the vals that type written are also read
	 */
	@Test
	public void writeInteger() {
		String path = "." + File.separator + "tempDB.txt";
		Database<String, Integer> db = new MapDB<>(path);
		Map<String, Integer> map = new LinkedHashMap<>();
		int runs = 100;
		Random rand = new Random();
		for (int i = 0; i < runs; i++) {
			map.put(rand.nextInt() + "", rand.nextInt());
			db.update(map);
		}
		assertArrayEquals(map.values().toArray(new Integer[1]), db.get().values().toArray(new Integer[1]));
		File rem = new File(path);
		rem.delete();
	}
	@Test
	public void writeAddress() {
		String path = "." + File.separator + "tempDB.txt";
		Database<String, Address> db = new MapDB<>(path);
		Map<String, Address> map = new LinkedHashMap<>();
		int runs = 100;
		Random rand = new Random();
		for (int i = 0; i < runs; i++) {
			map.put(rand.nextInt(10000) + "", new Address(i+ "", "John", "Doe", "jd@j.com","0125528"));
			db.update(map);
		}
		assertArrayEquals(map.values().toArray(new Address[1]), db.get().values().toArray(new Address[1]));
		File rem = new File(path);
		rem.delete();
	}
//	/**
//	 * tests for invalid paths
//	 */
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