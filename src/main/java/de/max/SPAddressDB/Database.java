package de.max.SPAddressDB;

import java.util.Map;

public interface Database<K, V> {

	/**
	 * This method is used to get the Map.
	 * @return Returns the Map.
	 */
	public Map<K, V> get();

	/**
	 * This method is used to get the map with the parameter 'directory'. 
	 * @param directory
	 * @return Returns the map.
	 */
	public Map<K, V> get(String directory);

	/**
	 * This method is used to push.
	 * @return boolean.
	 */
	public boolean push();

/**
 * This method is used to push
 * @param directory
 * @return boolean
 */
	public boolean push(String directory);

	/**
	 * This method is used to update
	 * @param data
	 * @return boolean
	 */
	public boolean update(Map<K ,V> data);
}