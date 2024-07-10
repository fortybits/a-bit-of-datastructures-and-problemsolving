package edu.bit.datastructures.hash;

/**
 * Design a HashSet without using any built-in hash table libraries.
 * <p>
 * 0 <= key <= 10^6
 * At most 10^4 calls will be made to add, remove, and contains.
 *
 * @param <T>
 */
public class MyHashSet<T> {
    boolean[] arr = new boolean[1000000001];

    public MyHashSet() {

    }

    //  Inserts the value key into the HashSet.
    public void add(int key) {
        arr[key] = true;
    }

    // Returns whether the value key exists in the HashSet or not.
    public boolean contains(int key) {
        return arr[key];
    }

    // Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
    public void remove(int key) {
        arr[key] = false;
    }
}