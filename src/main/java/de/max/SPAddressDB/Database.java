package de.max.SPAddressDB;

import java.util.Map;

public interface Database<K, V> {

	public Map<K, V> get();

	public Map<K, V> get(String directory);

	public boolean push();

	public boolean push(String directory);

	public boolean update(Map<K ,V> data);
}