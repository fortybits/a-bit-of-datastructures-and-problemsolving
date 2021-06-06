package edu.bit.datastructures.array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given an unsorted array of integers nums,
 * return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(N) time.
 */
public class LongestConsecutiveNumbers {


    public int longestConsecutive(int[] nums) {
        // 0. cannot sort the numbers since that would be `NlogN`
        // so thinking in lines of processing only once and store in a sorted data structure
        // which evicts if not following a condition
        if (nums.length == 0) {
            return 0;
        }
        int res = 1;

        // 1. group by a batch size same as the size of the input array and
        // then find the group with the maximum size
        // but this would require sorting the entry by values `NlogN`!
        // 2. how about storing data in a priority queue (with n iterations)
        // look up with `logN` (but would we not be iterating over `N` elements to lookup again)
        // 3. use a set for lookup instead of hashmap and find out values in range
        // we could also have optimised the first approach to find the max consecutive sequence as well
        Set<Integer> unique = Arrays.stream(nums).boxed().collect(Collectors.toSet()); // O(n) space
        for (Integer val : unique) { // O(n) complexity
            if (!unique.contains(val - 1)) {
                int nextVal = val + 1;
                while (unique.contains(nextVal)) { //O(1)
                    nextVal = nextVal + 1;
                }
                res = Math.max(res, nextVal - val);
            }
        }
        return res;
    }
}