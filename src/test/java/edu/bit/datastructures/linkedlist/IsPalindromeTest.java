package edu.bit.datastructures.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IsPalindromeTest {

    IsPalindrome isPalindrome = new IsPalindrome();

    @Test
    void testIsPalindromeForEvenSize() {
        ListNode listNode = new ListNode(9);
        listNode.next = new ListNode(8);
        listNode.next.next = new ListNode(7);
        listNode.next.next.next = new ListNode(7);
        listNode.next.next.next.next = new ListNode(8);
        listNode.next.next.next.next.next = new ListNode(9);
        Assertions.assertTrue(isPalindrome.isPalindrome(listNode));
    }

    @Test
    void testIsPalindromeForOddSize() {
        ListNode listNode = new ListNode(9);
        listNode.next = new ListNode(8);
        listNode.next.next = new ListNode(7);
        listNode.next.next.next = new ListNode(8);
        listNode.next.next.next.next = new ListNode(9);
        Assertions.assertTrue(isPalindrome.isPalindrome(listNode));
    }

    @Test
    void testIsPalindromeForInvalidInput() {
        ListNode listNode = new ListNode(9);
        listNode.next = new ListNode(8);
        listNode.next.next = new ListNode(6);
        listNode.next.next.next = new ListNode(9);
        Assertions.assertFalse(isPalindrome.isPalindrome(listNode));
    }


    @Test
    void testIsPalindromeForInvalidIputAgain() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);
        Assertions.assertTrue(isPalindrome.isPalindrome(listNode));
    }
}