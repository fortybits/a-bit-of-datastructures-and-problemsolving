package edu.bit.datastructures.linkedlist;

public class AreIdentical {

    public boolean areIdentical(ListNode head1, ListNode head2) {

        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
    }
}
