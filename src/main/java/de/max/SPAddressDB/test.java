package de.max.SPAddressDB;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class test {
	public static void main(String[] args) {
		String[] a = new String[100];

		a[1] = "a";
		for (int i = 0; i < a.length; i++) {
			a[i] = "asdasd";
		}
		write(a);
	}

	private static void write(String[] in) {
		Path p = Paths.get("/home/max/Desktop/test.txt");
		for (String i : in) {
			System.out.println(i);
			try (BufferedWriter w = Files.newBufferedWriter(p, StandardOpenOption.WRITE, StandardOpenOption.CREATE,
					StandardOpenOption.APPEND)) {
				w.write(i);
				w.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
