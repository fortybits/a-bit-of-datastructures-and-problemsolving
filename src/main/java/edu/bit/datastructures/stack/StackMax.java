package edu.bit.datastructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * A stack like data structure that also allows access to its elements by their value.
 * For example, given a stack of {1, 3, 2, 5, 3, 4, 5, 2}
 * peek() -> 2, peekMax() -> 5
 * pop() -> 2; peek() -> 5, peekMax() -> 5
 * pop() -> 5; peek() -> 4, peekMax() -> 5
 * push(6); peek() -> 6, peekMax() -> 6
 * popMax() -> 6; peek -> 4, peekMax() -> 5
 * popMax() -> 5; peek -> 4, peekMax() -> 4
 */
public class StackMax<T extends Comparable<T>> {

    List<T> backingStore = new ArrayList<>();

    class Node {
        T data;
        int index;
    }

    PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

    // The standard three Stack methods:

    /**
     * Add an element to the stack.
     */
    public void push(T toPush) {
        // push to stack -> pop/peek (index)
        // add to heap (heapify) -> peekMax /popMax
    }

    /**
     * Return the top value on the stack.
     */
    public T peek() {
        return null;
    }

    /**
     * Remove and return the top value from the stack.
     */
    public T pop() {
        return null;
    }


    // Two special methods, so this isn't just 'implement a stack':

    /**
     * Return the largest value in the stack. (Remember that T must implement Comparable.)
     */
    public T peekMax() {
        return null;
    }

    /**
     * Remove and return the largest value from the stack.
     */
    public T popMax() {
        Node entity = priorityQueue.remove(); // assuming performs a heapify
        backingStore.remove(entity.index);
        return entity.data;
        // removing the root from heap (heapify)
        // remove from the other stack based on index
    }

}