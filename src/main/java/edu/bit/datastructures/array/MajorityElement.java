package edu.bit.datastructures.array;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than floor(n/2) times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {

    public int majorityElement(final int[] input) throws IllegalAccessException {
        return Arrays.stream(input).boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > (input.length / 2))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(IllegalAccessException::new); // if assumption holds true, preform a get
    }
}