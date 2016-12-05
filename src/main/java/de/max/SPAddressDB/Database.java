package de.max.SPAddressDB;

import java.util.List;

public interface Database<T> {

	public List<T> get();

	public List<T> get(String directory);

	public boolean push();

	public boolean push(String directory);

	public boolean update(List<T> data);
}
