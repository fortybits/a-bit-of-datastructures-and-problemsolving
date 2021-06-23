package edu.bit.datastructures.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListIITest {

    ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();

    @Test
    void testReverseBetween() {
        Assertions.assertEquals(5,
                reverseLinkedListII.reverseBetween(new ListNode(5), 1, 1).val);
    }
}