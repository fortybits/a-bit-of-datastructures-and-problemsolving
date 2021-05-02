package edu.bit.datastructures.string;

/**
 * There are three types of edits that can be performed on strings: delete, replace and insert a character
 * Given two strings, write a function to check if they are one edit(or zero edits) away.
 */
public class OneEditAway {

    // the strings should be of equal(replace) or one character different in length
    boolean oneAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        }
        if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        }
        if (first.length() == second.length() + 1) {
            return oneEditInsert(second, first); // same as delete, just a reversal of insert
        }
        return false;
    }

    // for the cursor on the character array, if there are mismatch twice then return false
    // otherwise keep on traversing the characters with indexes for short and long strings
    private boolean oneEditInsert(String first, String second) {
        int firstIndex = 0; // to maintain the pointer for shorter string after mismatch
        int secondIndex = 0; // to maintain the pointer for longer string after mismatch
        while (firstIndex < first.length() && secondIndex < second.length()) {
            if (first.charAt(firstIndex) != second.charAt(secondIndex)) {
                if (firstIndex != secondIndex) {
                    return false;
                }
                secondIndex++; // create first mismatch for both the indexes
            } else {
                firstIndex++;
                secondIndex++;
            }
        }
        return true;
    }

    // since the length of the strings are equal, iterate based on any and compare characters
    // for more than one mismatch return false from the loop or else return true
    private boolean oneEditReplace(String first, String second) {
        boolean oneReplaceAway = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (oneReplaceAway) {
                    return false;
                }
                oneReplaceAway = true;
            }
        }
        return oneReplaceAway; // handles the equal strings as well
    }
}
