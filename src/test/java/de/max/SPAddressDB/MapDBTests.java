package de.max.SPAddressDB;

import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class MapDBTests {


	/**
	 * tests weather the vals that type written are also read
	 */
	@Test
	public void writeRand() {
		String path = "." + File.separator + "tempDB.txt";
		Database<String, String> db = new MapDB<>(path);


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