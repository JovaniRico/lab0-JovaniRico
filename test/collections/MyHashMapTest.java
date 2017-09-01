package collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class MyHashMapTest {

    static MyMap map;

    @Test
    public void shouldPutTwoElements(){
        map = new MyHashMap(10);
        assertEquals(0, map.size());

        HashEntry entry = new HashEntry("Jovani", "Rico");
        assertEquals(entry.toString(), map.put("Jovani", "Rico").toString());
        HashEntry entry2 = new HashEntry("Rico", "Martinez");
        assertEquals(entry2.toString(), map.put("Rico", "Martinez").toString());

        assertEquals(2, map.size());
    }

    @Test
    public void shouldReplaceDataSameKey(){
        map = new MyHashMap(10);
        HashEntry entry = new HashEntry("Jovanii", "Rico");
        assertEquals(entry.toString(), map.put("Jovanii", "Rico").toString());
        assertEquals(1, map.size());

        HashEntry entry2 = new HashEntry("Jovanii", "Martinez");
        assertEquals(entry2.toString(), map.put("Jovanii", "Martinez").toString());
        assertEquals(1, map.size());
    }

    @Test
    void shouldThrowNullPointerExceptionMissingEntry() {
        map = new MyHashMap(10);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            map.put(null, "");
        });
        assertEquals("Entry is missing.", exception.getMessage());
    }

    @Test
    public void shouldGetDataFromKey(){
        map = new MyHashMap(10);
        map.put("Jovani", "Rico");
        assertEquals("Rico", map.get("Jovani"));
    }

    @Test
    public void shouldGetNullFromKey(){
        map = new MyHashMap(10);
        assertEquals(null, map.get("1"));
    }

    @Test
    public void shouldThrowNullPointerExceptionNotkey() {
        map = new MyHashMap(10);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            map.get(null);
        });
        assertEquals("Entry is missing.", exception.getMessage());
    }

    @Test
    public void shouldDeleteAndEntry(){
        map = new MyHashMap(10);
        map.put("Jovani", "Rico");
        assertEquals(1, map.size());
        assertEquals("Rico",  map.delete("Jovani"));
        assertEquals(0, map.size());
    }

    @Test
    public void shouldReturnNullOnDelte(){
        map = new MyHashMap(10);
        assertNull(map.delete("Jovanii"));
    }

    @Test
    public void shouldReplaceData(){
        map = new MyHashMap(3);
        String key1 = "k15";
        Object object1 = new String("KEY 1");
        String key2 = "k13";
        Object object2 = new String("KEY 2");
        String key3 = "k4";
        Object object3 = new String("KEY 3");
        map.put(key1, object1);
        map.put(key2, object2);
        map.put(key3, object3);
        assertEquals(3, map.size());
        map.put(key3, object2);
        map.delete(key2);
        assertEquals(2, map.size());
        map.put(key3, object2);
        assertEquals(2, map.size());
    }

    @Test
    public void shouldReturnListOfKeys(){
        map = new MyHashMap(3);
        String key1 = "k15";
        Object object1 = new String("KEY 1");
        String key2 = "k13";
        Object object2 = new String("KEY 2");
        String key3 = "k4";
        Object object3 = new String("KEY 3");
        map.put(key1, object1);
        map.put(key2, object2);
        map.put(key3, object3);
        List<String> keys = new ArrayList<>();
        keys.add("k4");
        keys.add("k15");
        keys.add("k13");
        assertTrue(map.keys().equals(keys));
    }

    @Test
    public void shouldReturnListOfValues(){
        map = new MyHashMap(3);
        String key1 = "k15";
        Object object1 = new String("KEY 1");
        String key2 = "k13";
        Object object2 = new String("KEY 2");
        String key3 = "k4";
        Object object3 = new String("KEY 3");
        map.put(key1, object1);
        map.put(key2, object2);
        map.put(key3, object3);
        List<String> values = new ArrayList<>();
        values.add("KEY 3");
        values.add("KEY 1");
        values.add("KEY 2");
        assertTrue(map.values().equals(values));
    }
}