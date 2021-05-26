package edu.bit.datastructures.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestSubstringWithoutRepeatingCharacterTest {

    LongestSubstringWithoutRepeatingCharacter longestSubstringWithoutRepeatingCharacter = new LongestSubstringWithoutRepeatingCharacter();

    @Test
    void testLengthOfLongestSubstring() {
        Assertions.assertEquals(3,
                longestSubstringWithoutRepeatingCharacter.lengthOfLongestSubstring("abcabcabcbb"));

        Assertions.assertEquals(4,
                longestSubstringWithoutRepeatingCharacter.lengthOfLongestSubstring("abcadacabcbb"));

        Assertions.assertEquals(3,
                longestSubstringWithoutRepeatingCharacter.lengthOfLongestSubstringUsingSetForQueue("abcabcabcbb"));

        Assertions.assertEquals(4,
                longestSubstringWithoutRepeatingCharacter.lengthOfLongestSubstringUsingSetForQueue("abcadacabcbb"));
    }
}