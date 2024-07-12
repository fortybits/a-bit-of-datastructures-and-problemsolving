package edu.bit.datastructures.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 */
public class IntersectionWithDuplicates {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> existingElements = new HashMap<>();
        List<Integer> intersectionElements = new ArrayList<>();
        for (int i1 : nums1) {
            if (existingElements.containsKey(i1)) {
                existingElements.put(i1, existingElements.get(i1) + 1);
            } else {
                existingElements.put(i1, 1);
            }
        }
        for (int i1 : nums2) {
            if (existingElements.containsKey(i1) && existingElements.get(i1) > 0) {
                intersectionElements.add(i1);
                existingElements.put(i1, existingElements.get(i1) - 1);
            }
        }
        return intersectionElements.stream().mapToInt(i -> i).toArray();
    }
}
