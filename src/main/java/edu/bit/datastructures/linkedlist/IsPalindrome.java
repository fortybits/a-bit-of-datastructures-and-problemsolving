package edu.bit.datastructures.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 */
public class IsPalindrome {

    private final ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

    // one approach is to reverse the linked list and match if all the elements are same in both the list
    public boolean checkPalindrome(ListNode linkedListNode) {
        ListNode reverse = reverseLinkedList.reverseLinkedListAndClone(linkedListNode);
        return isEqual(linkedListNode, reverse);
    }

    private boolean isEqual(ListNode first, ListNode second) {
        while (first != null && second != null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return first == null && second == null;
    }

    // One needs to traverse only until the middle element and comparing the fold with the existing elements
    // so a Stack could be used to push the first half of elements and then pop the elements to
    // compare them with the other half. This would require being aware of the size or
    // using the runner approach to decide the middle element)
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        Deque<Integer> stack = new ArrayDeque<>(); // Java implementation for synchronised stack
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // odd number of elements (already taken care for even since they could be double folded)
        if (fast != null) {
            slow = slow.next;
        }

        // continue with the slow pointer for the rest of the half while cross checking the stack
        while (slow != null) {
            int top = stack.pop();
            if (top != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}