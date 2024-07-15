package edu.bit.datastructures.linkedlist;

/**
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list.
 * Assume all nodes in the linked list are 0-indexed.
 * <p>
 * Implement the MyLinkedList class:
 * <p>
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the index 'th node in the linked list. If the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the index'th node in the linked list.
 * If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 */
public class MyLinkedList {

    ListNode head;
    int length;

    public MyLinkedList(ListNode listNode) {
        this.head = listNode;
        this.length = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= this.length) {
            return -1;
        } else {
            int counter = 0;
            ListNode curr = head;
            while (counter != (index)) {
                curr = curr.next;
                counter++;
            }
            return curr.val;
        }
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }

    public void addAtTail(int val) {
        if (this.length == 0) {
            addAtHead(val);
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = null;
        this.length++;
    }

    public void addAtIndex(int index, int val) {
        ListNode newNode = new ListNode(val);
        ListNode temp = head;
        int counter = 0;
        if ((index) == this.length) {
            addAtTail(val);
            return;
        }
        if (index > this.length) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        while (counter != (index - 1)) {
            temp = temp.next;
            counter++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        this.length++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.length) {
            return;
        }
        ListNode curr = head;
        if (index == 0) {
            head = curr.next;
        } else {
            ListNode current = head;
            ListNode pre = null;
            int counter = 0;
            while (counter != index) {
                pre = current;
                current = current.next;
                counter++;
            }
            pre.next = current.next;
            this.length--;
        }
    }


    public static int sizeOfList(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static void printList(ListNode listHead) {
        if (listHead == null) {
            return;
        }
        System.out.print("LinkedList : ");
        while (listHead.next != null) {
            System.out.print(listHead.val + " -> ");
            listHead = listHead.next;
        }
        System.out.println(listHead.val);
    }
}