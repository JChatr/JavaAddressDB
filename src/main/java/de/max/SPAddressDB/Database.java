package de.max.SPAddressDB;

import java.util.Map;

/**
 * This class is used as a common interface for all databases.
 * @author mk285
 *
 * @param <K> The key of an entry.
 * @param <V> The value of an entry.
 */
public interface Database<K, V> {

	/**
	 * This method is used to get the Map.
	 *
	 * @return Returns the Map.
	 */
	public Map<K, V> get();

	/**
	 * This method is used to get the map with the parameter 'directory'.
	 *
	 * @param directory The directory of the database.
	 * @return Returns the map.
	 */
	public Map<K, V> get(String directory);

	/**
	 * This method is used to push.
	 *
	 * @return boolean Returns if the push was successful.
	 */
	public boolean push();

	/**
	 * This method is used to push the map with the parameter 'directory'.
	 *
	 * @param directory The directory of the database.
	 * @return boolean Returns if the push was successful.
	 */
	public boolean push(String directory);

	/**
	 * This method is used to update the database.
	 *
	 * @param data The list that is being updated.
	 * @return boolean Returns if the update was successful.
	 */
	public boolean update(Map<K, V> data);
}