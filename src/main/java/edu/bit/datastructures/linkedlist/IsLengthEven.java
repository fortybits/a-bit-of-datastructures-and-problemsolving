package edu.bit.datastructures.linkedlist;

public class IsLengthEven {

    public boolean isLengthEven(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return (count % 2) == 0;
    }
}
