package edu.bit.datastructures.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays of strings list1 and list2, find the common strings with the least index sum.
 * <p>
 * A common string is a string that appeared in both list1 and list2.
 * <p>
 * A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.
 * <p>
 * Return all the common strings with the least index sum. Return the answer in any order.
 * <p>
 * 1 <= list1.length, list2.length <= 1000
 * 1 <= list1[i].length, list2[i].length <= 30
 * list1[i] and list2[i] consist of spaces ' ' and English letters.
 * All the strings of list1 are unique.
 * All the strings of list2 are unique.
 * There is at least a common string between list1 and list2.
 */
public class MinimumIndexSum {

    public String[] findMinimumSumIndex(String[] list1, String[] list2) {
        Map<String, Integer> stringToIndexInList1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            stringToIndexInList1.put(list1[i], i);
        }
        int leastIndex = Integer.MAX_VALUE;
        List<String> stringsWithLeastIndex = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (stringToIndexInList1.containsKey(list2[i])) {
                int existingIndex = stringToIndexInList1.get(list2[i]);

                if (leastIndex == existingIndex + i) {
                    stringsWithLeastIndex.add(list2[i]);
                } else {
                    if (leastIndex > existingIndex + i) {
                        // found new value
                        leastIndex = existingIndex + i;
                        stringsWithLeastIndex.clear();
                        stringsWithLeastIndex.add(list2[i]);
                    }
                }
            }
        }

        return stringsWithLeastIndex.stream().toArray(String[]::new);
    }
}
