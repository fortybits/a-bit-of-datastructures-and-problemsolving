package edu.bit.datastructures.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyHashMapTest {

    MyHashMap<Integer> myHashMap = new MyHashMap<>();

    @Test
    void testHashSet() {
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        Assertions.assertEquals(1, myHashMap.get(1));
        Assertions.assertEquals(-1, myHashMap.get(3));
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        Assertions.assertEquals(1, myHashMap.get(2));
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        Assertions.assertEquals(-1, myHashMap.get(2));
    }
}