package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class EarlierNonRepeatingCharacterTest {

    EarlierNonRepeatingCharacter earlierNonRepeatingCharacter = new EarlierNonRepeatingCharacter();

    @Test
    void findEarliestNonRepeatingCharacter() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character chr : List.of('a', 'b', 'a', 'c', 'd', 'a', 'c', 'b', 'a')) {
            earlierNonRepeatingCharacter.processLastAdded(chr);
            Character earliestNonRepeatingCharacter = earlierNonRepeatingCharacter
                    .findEarliestNonRepeatingCharacter();
            stringBuilder.append(earliestNonRepeatingCharacter);
        }
        Assertions.assertEquals("aabbbbbdd", stringBuilder.toString());
    }
}