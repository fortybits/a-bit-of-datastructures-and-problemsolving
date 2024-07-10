package edu.bit.datastructures.hash;

import java.util.Arrays;

/**
 * Design a HashMap without using any built-in hash table libraries.
 * <p>
 * 0 <= key, value <= 10^6
 * At most 10^4 calls will be made to put, get, and remove.
 *
 * @param <T>
 */
public class MyHashMap<T> {

    int[] arr = new int[1000001];

    //MyHashMap() initializes the object with an empty map.
    public MyHashMap() {
        Arrays.fill(arr, -1);
    }

    //  inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
    public void put(int key, int value) {
        arr[key] = value;
    }

    // returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
    public int get(int key) {
        return arr[key];
    }

    // removes the key and its corresponding value if the map contains the mapping for the key.
    public void remove(int key) {
        arr[key] = -1;
    }
}