package edu.bit.datastructures.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
 * Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
 * <p>
 * Letters are case sensitive, so "a" is considered a different type of stone from "A"
 * <p>
 * 1 <= jewels.length, stones.length <= 50
 * jewels and stones consist of only English letters.
 * All the characters of jewels are unique.
 */
public class JewelsAndStones {


    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewel = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            jewel.add(c);
        }
        int count = 0;
        for (char c : stones.toCharArray()) {
            if (jewel.contains(c)) count++;
        }
        return count;
    }
}
