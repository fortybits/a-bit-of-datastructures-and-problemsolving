package edu.bit.datastructures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RemoveAdjacentDuplicatesTest {

    RemoveAdjacentDuplicates removeAdjacentDuplicates = new RemoveAdjacentDuplicates();

    @Test
    void testRemoveDuplicates() {
        Assertions.assertEquals("ca",
                removeAdjacentDuplicates.removeDuplicates("abbaca"));
        Assertions.assertEquals("ay",
                removeAdjacentDuplicates.removeDuplicates("azxxzy"));
        Assertions.assertEquals("azxzy",
                removeAdjacentDuplicates.removeDuplicates("azxxxzy"));
        Assertions.assertEquals("mnonp",
                removeAdjacentDuplicates.removeDuplicates("mnooooonp"));
    }

    @Test
    void testRemoveDuplicatesUsingStack() {
        Assertions.assertEquals("ca",
                removeAdjacentDuplicates.removeDuplicatesUsingStack("abbaca"));
        Assertions.assertEquals("ay",
                removeAdjacentDuplicates.removeDuplicatesUsingStack("azxxzy"));
        Assertions.assertEquals("azxzy",
                removeAdjacentDuplicates.removeDuplicatesUsingStack("azxxxzy"));
        Assertions.assertEquals("mnonp",
                removeAdjacentDuplicates.removeDuplicatesUsingStack("mnooooonp"));
    }
}