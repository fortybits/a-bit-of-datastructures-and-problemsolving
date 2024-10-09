package edu.bit.datastructures;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Implement an interleaving iterator that takes in an iterator of iterators,
 * and emits elements from the nested iterators in interleaved order.
 * That is, if we had the iterators i and j iterating over the elements [ia, ib, ic] and [ja, jb] respectively,
 * the order in which your interleaving iterator should emit the elements would be [ia, ja, ib, jb, ic].
 * <p>
 * Your interleaving iterator should implement the Iterator interface,
 * take in the iterator of iterators in its constructor, and provide the next and hasNext methods.
 * <p>
 * int[] arr1 = new int[]{1, 2, 3}{};
 * int[] arr2 = [4, 5];
 * int[] arr3 = [6, 7, 8, 9];
 * Iterator<Integer> a = arr1.iterator();
 * Iterator<Integer> b = arr2.iterator();
 * Iterator<Integer> c = arr3.iterator();
 * Iterator<Integer>[] iterlist = [a, b, c];
 * <p>
 * IF itfl = new IF(iterlist);
 * while(IF.hasNext()){
 * print IF.next();
 * }
 * // 1 4 6 2 5 7 3 8 9
 */
public class InterleavingIterator<T> {
    private final Iterator<T>[] iteratorList;
    private int pointer;

    // N iterators
    public InterleavingIterator(Iterator<T>[] iteratorList) {
        this.iteratorList = iteratorList;
        this.pointer = 0;
        this.iterqueue = new ArrayDeque<>();
        for (Iterator<T> tIterator : iteratorList) {
            if (tIterator.hasNext()) this.iterqueue.add(tIterator);
        }
    }

    public T next() {
        for (int i = pointer; i < iteratorList.length; i++) {
            Iterator<T> tIterator = iteratorList[i];
            if (tIterator.hasNext()) {
                pointer = (pointer + 1) % iteratorList.length;
                return tIterator.next();
            }
        }
        throw new NoSuchElementException("No elements left!");
    }

    // while it is trivial to iterate through the list and hasNext that makes it O(N)
    // we can reduce on time, if we can store a dataset of only remaining iterators
    public boolean hasNext() {
        for (Iterator<T> tIterator : iteratorList) {
            if (tIterator.hasNext()) return true;
        }
        return false;
    }


    // emphasizing : if we can store a dataset of only remaining iterators
    // another approach would be to make use of a queue to process elements and
    // remove the iterators which are no more having elements
    // note : a lot of work can be done during the constructor phase to ensure that these operations are still O(1)
    private Queue<Iterator<T>> iterqueue;

    public T nextOpt() throws NoSuchElementException {
        if (!hasNext()) throw new NoSuchElementException();
        Iterator<T> it = this.iterqueue.poll();
        T val = it.next();
        if (it.hasNext()) this.iterqueue.add(it);
        return val;
    }

    public boolean hasNextOpt() {
        return !this.iterqueue.isEmpty();
    }
}