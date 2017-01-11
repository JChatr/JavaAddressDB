package de.max.SPAddressDB;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class implements the database interface. Reads and writes from and to the disk.
 *
 * @param <K> The key of an entry.
 * @param <V> The value of an entry.
 * @author mk285
 */
public class MapDB<K, V> implements Database<K, V> {

	private Map<K, V> data;
	// default dir is in a .txt in the parent folder of the .jar
	//private String globalDir = ".." + File.separator + "ressources" + File.separator + "DB.txt";
	private String globalDir = "." + File.separator + "DB.txt";
	/**
	 * This method is used to get the Map.
	 */
	public MapDB() {
		get();
	}

	/**
	 * This method is used to set the directory and get the map.
	 *
	 * @param directory Sets the directory to 'directory'.
	 */
	public MapDB(String directory) {
		this.globalDir = directory;
		get(directory);
	}

	/**
	 * This method is used to read the database from the default directory.
	 *
	 * @return Returns the map with the directory 'globalDir'.
	 */
	@Override
	public Map<K, V> get() {
		return get(globalDir);
	}

	/**
	 * This method is used to read the database from the specific directory.
	 *
	 * @param directory
	 */
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

	/**
	 * This method is used to push the database.
	 *
	 * @return Returns true if the push is successful.
	 */
	@Override
	public boolean push() {
		return push(globalDir);
	}

	/**
	 * This method is used to push the database to a specific directory.
	 *
	 * @return Returns true if the push is successful.
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

	/**
	 * This method is used to update the database.
	 */
	@Override
	public boolean update(Map<K, V> data) {
		this.data = data;
		return push();
	}

	/**
	 * This method is used to checks if direcoty exists and if you are able to read and write in it.
	 *
	 * @param directory Directory that is going to be checked.
	 * @return Returns true if the dir exists an you are able to read/write.
	 */
	private boolean validDir(String directory) {
		// current dir with out path extension
		File dir = new File(directory.substring(0, directory.lastIndexOf(File.separator) + 1));
		// <3 IntelliJ
		return !(!dir.isDirectory() || !dir.canRead() || !dir.canWrite());
	}
}
