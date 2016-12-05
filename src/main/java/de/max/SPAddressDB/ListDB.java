package de.max.SPAddressDB;

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
	private String defDir = "./DB.txt";

	public ListDB() {
		get();
	}

	@Override
	public List<T> get() {
		return get(defDir);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> get(String directory) {
		Path path = Paths.get(directory);
		this.data = new ArrayList<>();
		try (InputStream is = Files.newInputStream(path, StandardOpenOption.READ);
				ObjectInputStream ois = new ObjectInputStream(is)) {
			this.data = new ArrayList<>();
			while (true) {
				T obj = (T) ois.readObject();
				data.add(obj);
			}
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}
		return this.data;
	}

	@Override
	public boolean push() {
		return push(defDir);
	}

	/**
	 * serialise each address object to the specified directory
	 */
	@Override
	public boolean push(String directory) {

		Path path = Paths.get(directory);
		try (OutputStream os = Files.newOutputStream(path, StandardOpenOption.CREATE);
				ObjectOutputStream oos = new ObjectOutputStream(os)) {
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
}
