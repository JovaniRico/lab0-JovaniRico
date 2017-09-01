package collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MyHashMapTest {

    static MyMap map;


//    @BeforeAll
//    public static void setUp() {
//        map = new MyHashMap(10);
//    }

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
    void shouldThrowNullPointerExceptionNotkey() {
        map = new MyHashMap(10);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            map.get(null);
        });
        assertEquals("Entry is missing.", exception.getMessage());
    }

}