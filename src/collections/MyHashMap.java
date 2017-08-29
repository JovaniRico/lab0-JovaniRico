package collections;

import java.util.List;

/** An implementation of MyMap interface.
 *  A hash table that uses linear probing to resolve collisions.
 *  Fill in the code in this class and test it thoroughly.
 */
public class MyHashMap implements MyMap {

     private HashEntry[] table; // the actual hashtable - an array of Hash Entries
     private int maxSize; // the maximum number of entries in the table
     private int currentSize; // how many entries the table contains

    /** A constructor for MyHashMap class
     *  @param maxSize - the maximum number of elements in the hash table.
     */
    public MyHashMap(int maxSize) {
        // FILL IN CODE
        // Initialize instance variables maxSize and table


    }

    /** Insert a (key, data) into the map, overwriting the previous value associated with the given key.
     * @param key If the key is null, throw IllegalArgumentException.
     * @param data
     * @return the previous value associated with this key or null if the key did not map to any value.
     */
    @Override
    public Object put(String key, Object data) {
        // FILL IN CODE

        return null; // change this

    }

    /** Return the value associated with the given key or null if the key does not map to any value
     *  @param key If null, throw IllegalArgumentException.
     *  @return the value associated with the key.
     */
    @Override
    public Object get(String key) {
        // FILL IN CODE

        return null; // change this

    }

    /** Delete the (key, data) entry from the map or do nothing if this key is not in the map.
     *  @param key
     *  @return The value associated with this key before deletion
     */
    @Override
    public Object delete(String key) {
        // FILL IN CODE

        return null; // change this
    }

    /** Return the number of entries in the map
     * @return the number of (key, value) entries in the map.
     */
    @Override
    public int size() {

        return currentSize;
    }

    /** Return map keys
     * @return a list of all keys in the map
     */
    public List<String> keys() {
        // FILL IN CODE

        return null; // change this
    }

    /** Return map values
     * @return a list of all values in the map
     */
    @Override
    public List<Object> values() {
       // FILL IN CODE

        return null; // change this
    }

    /** Returns the index in the hash table that this key hashes to.
     * @param key
     * @return the index in the table
     * */
    private int hash(String key) {
        // FILL IN CODE
        // Call the hashCode() method in class String and return this value modulus the table size

        return 0; // change this
    }
}
