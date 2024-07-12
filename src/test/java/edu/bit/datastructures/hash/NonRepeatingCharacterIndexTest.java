package edu.bit.datastructures.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NonRepeatingCharacterIndexTest {

    NonRepeatingCharacterIndex nonRepeatingCharacterIndex = new NonRepeatingCharacterIndex();

    @Test
    void testNonRepeatingCharacterIndex() {
        Assertions.assertEquals(0, nonRepeatingCharacterIndex.firstUniqueCharIndex("leetcode"));
        Assertions.assertEquals(2, nonRepeatingCharacterIndex.firstUniqueCharIndex("loveleetcode"));
        Assertions.assertEquals(-1, nonRepeatingCharacterIndex.firstUniqueCharIndex("aabb"));
    }


    @Test
    void testNonRepeatingCharacter() {
        Assertions.assertEquals('l', nonRepeatingCharacterIndex.getFirstNonRepeatingCharacter("leetcode".chars().mapToObj(c -> (char) c).toList()));
        Assertions.assertEquals('v', nonRepeatingCharacterIndex.getFirstNonRepeatingCharacter("loveleetcode".chars().mapToObj(c -> (char) c).toList()));
        Assertions.assertNull(nonRepeatingCharacterIndex.getFirstNonRepeatingCharacter("aabb".chars().mapToObj(c -> (char) c).toList()));

    }

}