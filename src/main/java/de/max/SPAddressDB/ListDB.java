package de.max.SPAddressDB;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ListDB<T> implements Database<T> {

	private List<T> data;
	// default dir is in a .txt in the parent folder of the .jar
	private String globalDir = "."+ File.separator + "DB.txt";

	public ListDB() {
		get();
	}
	
	public ListDB(String directory) {
		this.globalDir = directory;
		get();
	}

	@Override
	public List<T> get() {
		return get(globalDir);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> get(String directory) {
		// need to make sure path is valid
		if (!validDir(directory)) return null;
		this.data = new ArrayList<>();
		Path path= Paths.get(directory);
		try (InputStream is = Files.newInputStream(path, StandardOpenOption.READ);
				ObjectInputStream ois = new ObjectInputStream(is)) {
			while (true) {
				T obj = (T) ois.readObject();
				data.add(obj);
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
		try (	OutputStream os = Files.newOutputStream(path, StandardOpenOption.CREATE);
				ObjectOutputStream oos = new ObjectOutputStream(os)		) {
			for (Object i : data) {
				oos.writeObject(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(List<T> data) {
		this.data = data;
		return push();
	}
	
	private boolean validDir(String directory) {
		// current dir with out path extension
		File dir = new File(directory.substring(0, directory.lastIndexOf(File.separator) + 1));
		if (!dir.isDirectory()) return false;
		return true;
	}
}
