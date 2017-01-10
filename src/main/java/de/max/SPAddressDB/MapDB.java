package de.max.SPAddressDB;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapDB<K, V> implements Database<K, V> {

	private Map<K, V> data;
	// default dir is in a .txt in the parent folder of the .jar
	private String globalDir = "." + File.separator + "DB.txt";

	public MapDB() {
		get();
	}

	public MapDB(String directory) {
		this.globalDir = directory;
		get(directory);
	}

	@Override
	public Map<K, V> get() {
		return get(globalDir);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<K, V> get(String directory) {
//		 need to make sure path is valid
		if (!validDir(directory)) return null;
		this.data = new LinkedHashMap<>();
		Path path = Paths.get(directory);
		try (InputStream is = Files.newInputStream(path, StandardOpenOption.READ);
		     ObjectInputStream ois = new ObjectInputStream(is)) {
			while (true) {
				V obj = (V) ois.readObject();
				data.put((K) obj.toString(), obj);
			}
		} catch (ClassNotFoundException e) {
		} catch (IOException e) {
		}
		return this.data;
	}

	@Override
	public boolean push() {
		return push(globalDir);
	}

	/**
	 * serialize each address object to the specified directory
	 */
	@Override
	public boolean push(String directory) {
		// need to make sure path is valid
//		if (!validDir(directory)) return false;
		Path path = Paths.get(directory);
		try (OutputStream os = Files.newOutputStream(path, StandardOpenOption.CREATE);
		     ObjectOutputStream oos = new ObjectOutputStream(os)) {
			for (Map.Entry<K, V> i : data.entrySet()) {
				oos.writeObject(i.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Map<K, V> data) {
		this.data = data;
		return push();
	}

	private boolean validDir(String directory) {
		// current dir with out path extension
		File dir = new File(directory.substring(0, directory.lastIndexOf(File.separator) + 1));
		// <3 IntelliJ
		return !(!dir.isDirectory() || !dir.canRead() || !dir.canWrite());
	}
}
