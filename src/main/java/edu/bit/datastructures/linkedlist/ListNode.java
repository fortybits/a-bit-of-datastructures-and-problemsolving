package edu.bit.datastructures.linkedlist;

public class ListNode {
    public ListNode next;
    int val;

    public ListNode() {
    }

    // Constructor to create a new node
    ListNode(int d) {
        val = d;
        next = null;
    }
}