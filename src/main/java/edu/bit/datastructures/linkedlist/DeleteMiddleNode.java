package edu.bit.datastructures.linkedlist;

/**
 * Implement an algorithm to delete a node in the middle (i.e. any node but the fist and last node,
 * (not necessarily the exact middle) of a singly linked list, given only access to that node
 */
public class DeleteMiddleNode {

    // given just the node to delete and not the head of the linked list
    // this should be a simple node deletion ensuring the references are changed for the previous node
    // to the next node
    boolean deleteNodeInMiddle(ListNode nodeToDelete) {
        if (nodeToDelete == null || nodeToDelete.next == null) {
            return false;
        }
        // just make sure that the current node now reference to its next node
        ListNode nextNode = nodeToDelete.next;
        nodeToDelete.val = nextNode.val;
        nodeToDelete.next = nextNode.next;
        return true;
    }

    // the above approach makes use of referencing and overwriting the existing data of the node reference given
}