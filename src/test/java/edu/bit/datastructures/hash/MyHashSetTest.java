package edu.bit.datastructures.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyHashSetTest {


    MyHashSet<Integer> myHashSet = new MyHashSet<>();

    @Test
    void testHashSet() {
        myHashSet.add(1);
        Assertions.assertTrue(myHashSet.contains(1));
        myHashSet.remove(1);
        Assertions.assertFalse(myHashSet.contains(1));
    }

}