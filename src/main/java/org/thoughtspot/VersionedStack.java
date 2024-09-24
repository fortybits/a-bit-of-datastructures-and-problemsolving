package org.thoughtspot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * We need to create a Versioned stack in which we have the following operations:
 * <p>
 * push(e) -> This should have a time complexity of O(1)
 * pop() -> This should have a time complexity of O(1)
 * print(version) -> This should have a time complexity of O(n) where n is the number of elements in that version
 * <p>
 * Every push and pop operation creates a new version for example:
 * <p>
 * push(5) -> version 1
 * push(6) -> version 2
 * pop() -> version 3
 */
public class VersionedStack {
    List<List<Integer>> versionLookup;

    VersionedStack() {
        versionLookup = new ArrayList<>();
    }

    public void push(int i) {
        if (versionLookup.isEmpty()) {
            versionLookup.add(List.of(i));
        } else {
            List<Integer> currentElements = versionLookup.getLast();
            List<Integer> overallElements = Stream.concat(currentElements.stream(), Stream.of(i)).toList();
            versionLookup.add(overallElements);
        }
    }

    public int pop() {
        if (versionLookup.isEmpty()) {
            throw new RuntimeException("Empty Stack!");
        } else {
            List<Integer> currentElements = versionLookup.getLast();
            List<Integer> overallElements = currentElements.subList(0, currentElements.size() - 1);
            versionLookup.add(overallElements);
            return currentElements.getLast();
        }
    }

    public void printN(int N) {
        if (N == 0) System.out.println("Version " + N + " : " + "NULL");
        else System.out.println("Version " + N + " : " + versionLookup.get(N - 1));
    }

    public static void main(String[] args) {
        VersionedStack versionedStack = new VersionedStack();
        versionedStack.push(1);
        versionedStack.push(2);
        versionedStack.push(3);
        versionedStack.pop();
        versionedStack.pop();

        versionedStack.printN(0);
        versionedStack.printN(3);

        versionedStack.printN(2);

        versionedStack.push(5);
        versionedStack.printN(4);
        versionedStack.printN(6);


        VersionedStackOpt<Integer> stack = new VersionedStackOpt<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
        stack.print(0);
        stack.print(3);
        stack.print(2);
        stack.push(5);
        stack.print(4);
        stack.print(6);
    }

    static class VersionedStackOpt<T> {

        // Inner class to represent a node in the stack
        private static class Node<T> {
            T value;
            Node<T> next;

            Node(T value, Node<T> next) {
                this.value = value;
                this.next = next;
            }
        }

        // List to store the versions of the stack
        private List<Node<T>> versions;

        // Constructor to initialize the stack with an empty version
        public VersionedStackOpt() {
            versions = new ArrayList<>();
            versions.add(null); // version 0 (empty stack)
        }

        // Push operation with O(1) complexity
        public void push(T value) {
            Node<T> currentTop = versions.get(versions.size() - 1); // get the current top of the stack
            Node<T> newNode = new Node<>(value, currentTop); // create a new node that points to the current top
            versions.add(newNode); // add the new version of the stack
        }

        // Pop operation with O(1) complexity
        public T pop() {
            Node<T> currentTop = versions.get(versions.size() - 1); // get the current top of the stack
            if (currentTop == null) {
                throw new IllegalStateException("Stack is empty.");
            }
            versions.add(currentTop.next); // create a new version with the next node as the top
            return currentTop.value;
        }

        // Print operation with O(n) complexity where n is the number of elements in that version
        public void print(int version) {
            System.out.print("Version " + version + " : ");

            if (version < 0 || version >= versions.size()) {
                throw new IllegalArgumentException("Invalid version number.");
            }

            if (version == 0) {
                System.out.print("NULL");
            }

            Node<T> current = versions.get(version);
            List<T> elements = new ArrayList<>();

            // Traverse the stack for the given version and collect elements
            while (current != null) {
                elements.add(current.value);
                current = current.next;
            }


            // Print elements in reverse order to simulate stack order
            for (int i = elements.size() - 1; i >= 0; i--) {
                System.out.print(elements.get(i) + " ");
            }
            System.out.println();
        }
    }
}