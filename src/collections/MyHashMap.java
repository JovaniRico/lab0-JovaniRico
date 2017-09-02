package collections;

import java.util.ArrayList;
import java.util.List;

/** An implementation of MyMap interface.
 *  A hash table that uses linear probing to resolve collisions.
 *  Fill in the code in this class and test it thoroughly.
 */
public class MyHashMap implements MyMap {

     private HashEntry[] table; // the actual hashtable - an array of Hash Entries
     private final int  maxSize; // the maximum number of entries in the table
     private int currentSize; // how many entries the table contains

    /** A constructor for MyHashMap class
     *  @param maxSize - the maximum number of elements in the hash table.
     */
    public MyHashMap(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.table = new HashEntry[maxSize];
    }

    /** Insert a (key, data) into the map, overwriting the previous value associated with the given key.
     * @param key If the key is null, throw IllegalArgumentException.
     * @param data
     * @return the previous value associated with this key or null if the key did not map to any value.
     */
    @Override
    public Object put(String key, Object data) throws IllegalArgumentException{
        if(key == null) throw new IllegalArgumentException("Entry is missing.");
        HashEntry entry = getEntry(key);
        if(entry == null && size() == maxSize){
            return null;
        } else if (entry == null) {
            int hasCode = hash(key);

            for (int i = 0; i < maxSize; i++, hasCode++) {
                if (table[hasCode] == null || table[hasCode].isDeleted()) {
                    table[hasCode] = new HashEntry(key, data);
                    this.currentSize++;
                    break;
                }
                if (hasCode + 1 == maxSize) {
                    hasCode = -1;
                }
            }
            return this.table[hasCode];
        } else {
            Object previous = entry.getData();
            entry.setData(data);
            return previous;
        }
    }

    /** Return the value associated with the given key or null if the key does not map to any value
     *  @param key If null, throw IllegalArgumentException.
     *  @return the value associated with the key.
     */
    @Override
    public Object get(String key) throws IllegalArgumentException{
        HashEntry entry = getEntry(key);
        if (entry != null) {
            return entry.getData();
        }
        return null;
    }

    /** Delete the (key, data) entry from the map or do nothing if this key is not in the map.
     *  @param key
     *  @return The value associated with this key before deletion
     */
    @Override
    public Object delete(String key) throws IllegalArgumentException{
        HashEntry currentEntry = getEntry(key);
        if(currentEntry == null) return null;
        Object previousData = currentEntry.getData();
        currentEntry.setKey(null);
        currentEntry.setData(null);
        currentEntry.setDeleted(true);
        this.currentSize--;
        return previousData;
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
        List<String> keysList = new ArrayList<>();
        for (int i = 0; i < maxSize; i++) {
            if(table[i] != null && table[i].getKey() != null){
                keysList.add(table[i].getKey());
            }
        }
        return keysList;
    }

    /** Return map values
     * @return a list of all values in the map
     */
    @Override
    public List<Object> values() {
        List<Object> valuesList = new ArrayList<>();
        for (int i = 0; i < maxSize; i++) {
            if(table[i] != null && table[i].getKey() != null){
                valuesList.add(table[i].getData());
            }
        }
        return valuesList;
    }

    /** Returns the index in the hash table that this key hashes to.
     * @param key
     * @return the index in the table
     * */
    private int hash(String key) {
        Integer hash= key.hashCode();
        return hash.MAX_VALUE % maxSize;
    }

    /** Return the Entry associated with the given key or null if the key does not map to any value
     *  @param key If null, throw IllegalArgumentException.
     *  @return the HashEntry associated with the key.
     */
    private HashEntry getEntry(String key) throws IllegalArgumentException{
        if(key == null) throw new IllegalArgumentException("Entry is missing.");
        int hasCode = hash(key);
        if(size() > 0) {
            for (int i = 0; i < maxSize; i++, hasCode++) {
                if(table[hasCode] == null){break;}
                if(table[hasCode].isDeleted()){
                    if (hasCode + 1 == maxSize) {
                        hasCode = -1;
                    }
                    continue;
                }
                if (table[hasCode].getKey().equals(key)) {
                    return table[hasCode];
                }
                if (hasCode + 1 == maxSize) {
                    hasCode = -1;
                }
            }
        }
        return null;
    }
}
