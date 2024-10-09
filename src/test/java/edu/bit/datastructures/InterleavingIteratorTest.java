package edu.bit.datastructures;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class InterleavingIteratorTest {

    InterleavingIterator<Integer> interleavingIterator;

    @Test
    void testInterleavingIterator() {
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{4, 5};
        int[] arr3 = new int[]{6, 7, 8, 9};
        Iterator<Integer> a = Arrays.stream(arr1).iterator();
        Iterator<Integer> b = Arrays.stream(arr2).iterator();
        Iterator<Integer> c = Arrays.stream(arr3).iterator();
        interleavingIterator = new InterleavingIterator<>(List.of(a, b, c).toArray(Iterator[]::new));

        while (interleavingIterator.hasNext()) {
            System.out.print(interleavingIterator.next() + " ");
        }
    }
}