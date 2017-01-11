package de.max.SPAddressDB;

import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Junit tests for the MapDB Tests
 */
public class MapDBTests {

	/**
	 * tests weather objects that are written to the Database and then returned
	 * are the same as the written ones
	 */
	@Test
	public void testWriteInteger() {
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

	/**
	 * tests if the Database will error on an invalid path
	 */
	@Test
	public void testInvalidPathGet1() {
		String path = "";
		Path p = Paths.get("5535235235/");
		Database<String, String> db = new MapDB<>(path);
		assertNull(db.get(path));
		File rem = new File(path);
		rem.delete();
	}


	/**
	 *  test if the Database will error on a path with a typo
	 */
	@Test
	public void testInvalidPathGet2() {
		String path = "/hom:e/max/";
		Database<String, String> db = new MapDB<>(path);
		assertNull(db.get(path));
		File rem = new File(path);
		rem.delete();
	}

	@Test
	public void testValidPathGet() {
		String path = "/home/max/";
		Database<String, String> db = new MapDB<>(path);
		assertNotNull(db.get(path));
		File rem = new File(path);
		rem.delete();
	}

	/**
	 * tests if the Database will write to a valid path
	 */
	@Test
	public void testValidPathGet2() {
		String path = "/home/max/Desktop";
		Database<String, String> db = new MapDB<>(path);
		assertNotNull(db.get(path));
		File rem = new File(path);
		rem.delete();
	}

	/**
	 * tests if the Database will error when the application as insufficient permissions
	 * to write to a directory
	 *
	 */
	@Test
	public void testGetPermissions() {
		String path = "/opt/Krita/";
		Database<String, String> db = new MapDB<>(path);
		assertNull(db.get());
		File rem = new File(path);
		rem.delete();
	}


	/**
	 * tests if the Database will error if the application has insufficient permissions to
	 * write to a Directory
	 */
	@Test
	public void testGetPermissions2() {
		String path = "/";
		Database<String, String> db = new MapDB<>(path);
		assertNull(db.get());
		File rem = new File(path);
		rem.delete();
	}
}