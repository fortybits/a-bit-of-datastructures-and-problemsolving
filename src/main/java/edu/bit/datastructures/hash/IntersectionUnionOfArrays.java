package edu.bit.datastructures.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionUnionOfArrays {

    public List<Integer> intersection(int[] nums1, int[] nums2) {
        Set<Integer> existingElements = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.toSet());
        return Arrays.stream(nums2)
                .filter(existingElements::contains)
                .boxed()
                .toList(); // preserving the order
    }

    public static String findIntersection(String[] strArr) {
        Set<Integer> existingElements = Arrays.stream(strArr[0].split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toSet());

        return Arrays.stream(strArr[1].split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .filter(existingElements::contains)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
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