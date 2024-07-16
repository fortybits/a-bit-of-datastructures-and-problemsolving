package edu.bit.datastructures.linkedlist;

/**
 * You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer.
 * This child pointer may or may not point to a separate doubly linked list, also containing these special nodes.
 * These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.
 * <p>
 * Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list.
 * Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.
 * <p>
 * Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.
 * <p>
 * Constraints:
 * <p>
 * The number of Nodes will not exceed 1000.
 * 1 <= Node.val <= 105
 */
public class FlattenMultilevelLists {

    public static class MultiLevelNode {
        public int val;
        public MultiLevelNode prev;
        public MultiLevelNode next;
        public MultiLevelNode child;

        public MultiLevelNode(int val) {
            this.val = val;
        }
    }

    // interestingly as the list flattens the level further folds up and hence a single traversal works just fine
    public MultiLevelNode flatten(MultiLevelNode head) {
        if (head == null) return head;

        MultiLevelNode pointer = head;
        while (pointer != null) {
            /* CASE 1: if no child, proceed */
            if (pointer.child == null) {
                pointer = pointer.next;
                continue;
            }
            /* CASE 2: got child, find the tail of the child and link it to p.next */
            MultiLevelNode temp = pointer.child;
            // Find the tail of the child
            while (temp.next != null)
                temp = temp.next;
            // Connect tail with p.next, if it is not null
            temp.next = pointer.next;
            if (pointer.next != null) pointer.next.prev = temp;
            // Connect p with p.child, and remove p.child
            pointer.next = pointer.child;
            pointer.child.prev = pointer;
            pointer.child = null;
        }
        return head;
    }

}
