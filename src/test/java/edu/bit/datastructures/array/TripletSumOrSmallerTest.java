package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class TripletSumOrSmallerTest {

    TripletSumOrSmaller tripletSumOrSmaller = new TripletSumOrSmaller();

    @Test
    void testFindTriplets() {
        int[] arr = {0, 5, 1, 3, 4, 7, 8, 9};
        int sum = 13;
        Set<List<Integer>> triplets = tripletSumOrSmaller.findTriplets(arr, sum);
        Assertions.assertEquals(Set.of(List.of(0, 1, 4), List.of(1, 3, 4), List.of(0, 3, 4), List.of(1, 3, 7), List.of(0, 1, 9),
                List.of(0, 4, 7), List.of(0, 1, 7), List.of(0, 1, 8), List.of(0, 3, 7), List.of(1, 3, 5), List.of(1, 4, 7),
                List.of(0, 1, 5), List.of(0, 1, 3), List.of(0, 5, 7), List.of(0, 4, 5), List.of(0, 4, 8), List.of(0, 3, 8),
                List.of(1, 4, 5), List.of(3, 4, 5), List.of(0, 3, 9), List.of(1, 3, 8), List.of(0, 3, 5)), triplets);
    }

    @Test
    void testFindTripletsWithEmptyResult() {
        int[] arr = {0, 5, 1, 3, 4, 7, 8, 9};
        int sum = 1;
        Set<List<Integer>> triplets = tripletSumOrSmaller.findTriplets(arr, sum);
        Assertions.assertEquals(Set.of(), triplets);
    }
}