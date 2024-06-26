package edu.bit.datastructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

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
//        Node entity = priorityQueue.remove(); // assuming performs a heapify
//        backingStore.remove(entity.index);
//        return entity.data;
        // removing the root from heap (heapify)
        // remove from the other stack based on index
        return null;
    }

    class Node {
        public int val;
        public Node prev, next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    class DoubleLinkedList {
        private final Node head = new Node();
        private final Node tail = new Node();

        public DoubleLinkedList() {
            head.next = tail;
            tail.prev = head;
        }

        public Node append(int val) {
            Node node = new Node(val);
            node.next = tail;
            node.prev = tail.prev;
            tail.prev = node;
            node.prev.next = node;
            return node;
        }

        public Node remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }

        public Node pop() {
            return remove(tail.prev);
        }

        public int peek() {
            return tail.prev.val;
        }
    }

    class MaxStack {
        private DoubleLinkedList stk = new DoubleLinkedList();
        private TreeMap<Integer, List<Node>> tm = new TreeMap<>();

        public MaxStack() {
        }

        public void push(int x) {
            Node node = stk.append(x);
            tm.computeIfAbsent(x, k -> new ArrayList<>()).add(node);
        }

        public int pop() {
            Node node = stk.pop();
            List<Node> nodes = tm.get(node.val);
            int x = nodes.remove(nodes.size() - 1).val;
            if (nodes.isEmpty()) {
                tm.remove(node.val);
            }
            return x;
        }

        public int top() {
            return stk.peek();
        }

        public int peekMax() {
            return tm.lastKey();
        }

        public int popMax() {
            int x = peekMax();
            List<Node> nodes = tm.get(x);
            Node node = nodes.remove(nodes.size() - 1);
            if (nodes.isEmpty()) {
                tm.remove(x);
            }
            stk.remove(node);
            return x;
        }
    }

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */

}