package collections;

/** A class that represents an entry in the hash table: a (key, data) pair */
public class HashEntry {
    private String key;
    private Object data;
    private boolean isDeleted; // whether this entry was deleted

    /** Constructor for HashEntry
     * @param key
     * @param data
     */
    public HashEntry(String key, Object data) {
        // FILL IN CODE
        this.data = data;
        this.key = key;
        this.isDeleted = false;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return String.format("Key: "+key + " data: " + data);
    }
}
