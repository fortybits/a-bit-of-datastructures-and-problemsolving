package edu.bit.datastructures.linkedlist;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list
 */
public class KthFromLastNode {

    // can ask if the list size is known, recursive vs iterative solution
    // this is just a util to get the Kth element in the list
    public ListNode getKthNode(ListNode head, int k) {
        ListNode current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

    // one way is to find the size of the list and then traverse again to find the 'size -k' element,
    // this would be O(2n -k) but precisely O(n)

    // alternate approach is to keep a runner at k difference from head, when this pointer reaches the end,
    // slow pointer would be at the desired node
    ListNode kthFromLastNodeRunner(ListNode head, int k) {
        ListNode fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null; // out of bounds
            }
            fast = fast.next;
        }
        while (fast != null) {
            head = head.next;
            fast = fast.next;
        }
        return head;
    }

    // recursive approach (just to print the element, not return it)
    // one can return element from within the recursion as well, but the complexity of code increases
    int kthFromLastNodeRecursive(ListNode head, int k) {
        if (head == null) {
            return 0;
        }
        int index = kthFromLastNodeRecursive(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + " to the last node is " + head.val);
        }
        return index;
    }


    // Given the head of a linked list, remove the nth node from the end of the list and return its head.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return start.next;
    }
}