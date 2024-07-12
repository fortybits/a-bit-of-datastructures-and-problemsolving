package edu.bit.datastructures.hash;

import java.util.HashSet;
import java.util.Set;

public class IntersectionUnionOfArrays {

    public Set<Integer> intersection(int[] nums1, int[] nums2) {
        Set<Integer> existingElements = new HashSet<>();
        Set<Integer> intersectionElements = new HashSet<>();
        for (int i1 : nums1) {
            existingElements.add(i1);
        }
        for (int i1 : nums2) {
            if (existingElements.contains(i1)) {
                intersectionElements.add(i1);
            }
        }
        return intersectionElements;
    }

    public Set<Integer> union(int[] nums1, int[] nums2) {
        Set<Integer> unionElements = new HashSet<>();
        for (int i1 : nums1) {
            unionElements.add(i1);
        }
        for (int i1 : nums2) {
            unionElements.add(i1);
        }
        return unionElements;
//        return unionElements.stream().mapToInt(i -> i).toArray();
    }
}