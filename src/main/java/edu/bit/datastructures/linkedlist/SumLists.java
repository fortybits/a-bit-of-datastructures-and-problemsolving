package edu.bit.datastructures.linkedlist;

/**
 * You have two numbers represented as a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum of the linked list.
 * (follow up: if the input is represented as forward order of digits)
 */
public class SumLists {

    private final ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return sumOfNumbers(l1, l2, 0);
    }

    // if the numbers are represented in the reverse order,
    // they could be added with a carry towards the next addition
    private ListNode sumOfNumbers(ListNode first, ListNode second, int carry) {
        if (first == null && second == null && carry == 0) {
            return null;
        }

        ListNode result = new ListNode();
        int value = carry;
        if (first != null) {
            value = first.val + carry;
        }
        if (second != null) {
            value = second.val + value;
        }
        result.val = value % 10;

        // recursion called here would end based on the null value check (both have been consumed)
        if (first != null || second != null) {
            result.next = sumOfNumbers(first == null ? first : first.next,
                    second == null ? second : second.next, value / 10);
        }
        return result;
    }

    // if the input is revered to represent the forward order of digits
    // one way is to reverse the linked lists and then sum them as in previous approach
    private ListNode sumOfNumbersInForwardOrder(ListNode first, ListNode second, int carry) {
        ListNode l1 = reverseLinkedList.reverseLinkedList(first);
        ListNode l2 = reverseLinkedList.reverseLinkedList(second);
        return sumOfNumbers(l1, l2, carry);
    }


    // follow up:-
    // another approach is to create a wrapper class like PartialSum and recurse with helper
    // while ensuring to create a head for carry with first digit sum and ending recursion when both
    // the node's point to null


    private static int length(ListNode l) {
        return l == null ? 0 : 1 + length(l.next);
    }

    private static PartialSum addListsHelper(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return new PartialSum();
        }
        PartialSum sum = addListsHelper(l1.next, l2.next);
        int val = sum.carry + l1.val + l2.val;
        ListNode fullResult = insertBefore(sum.sum, val % 10);
        sum.sum = fullResult;
        sum.carry = val / 10;
        return sum;
    }

    private static ListNode addLists(ListNode l1, ListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);
        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }
        PartialSum sum = addListsHelper(l1, l2);
        return sum.carry == 0 ? sum.sum : insertBefore(sum.sum, sum.carry);
    }

    private static ListNode padList(ListNode l, int padding) {
        ListNode head = l;
        for (int i = 0; i < padding; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    // Just make sure inserted node is the head every time
    private static ListNode insertBefore(ListNode list, int data) {
        ListNode node = new ListNode(data);
        if (list != null) {
            node.next = list;
        }
        return node;
    }

    public static int linkedListToInt(ListNode node) {
        int value = 0;
        while (node != null) {
            value = value * 10 + node.val;
            node = node.next;
        }
        return value;
    }

    static class PartialSum {
        public ListNode sum = null;
        public int carry = 0;
    }
}