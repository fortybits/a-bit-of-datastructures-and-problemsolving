package edu.bit.datastructures.array;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of values, find two mismatching numbers which upon swapping
 * can ensure the list if sorted.
 * Note: It is guaranteed to have a pair of value to swap.
 */
public class FindSwappedPair {

    // keeping a pointer of whether the first value is found or not
    // and what index is it found in the increasing order array
    public int[] findSwappedValues(List<Integer> values) {
        int[] swapped = new int[2];
        boolean first = false;
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) < values.get(i - 1)) {
                swapped[0] = values.get(i - 1);
                first = true;
            }
            if (values.get(i) < values.get(i - 1) && first) {
                swapped[1] = values.get(i - 1);
                first = false;
            }
        }
        if (first) {
            swapped[1] = swapped[0] + 1;
        }
        return swapped;
    }

    // the approach here takes some extra runtime O(NlogN) and space O(N) here
    public int[] getSwappedValuesInefficiently(List<Integer> inorderTree) {
        List<Integer> sortedInorderTree = inorderTree.stream()
                .sorted().collect(Collectors.toList());
        int[] swappedValues = new int[2];
        // the following is another O(N) iteration
        for (int i = 0; i < inorderTree.size(); i++) {
            if (!inorderTree.get(i).equals(sortedInorderTree.get(i))) {
                swappedValues[0] = inorderTree.get(i);
                swappedValues[1] = sortedInorderTree.get(i);
                break;
            }
        }
        return swappedValues;
    }
}