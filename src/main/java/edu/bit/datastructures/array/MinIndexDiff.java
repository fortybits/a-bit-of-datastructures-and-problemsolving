package edu.bit.datastructures.array;

import java.util.List;

public class MinIndexDiff {

    public Integer findMinimumIndexDiff(List<Integer> values, List<Integer> indexes) {
        int diff = values.size();
        int result = indexes.get(0);
        for (int i = 0; i < values.size(); i++) {
            int indexDiff = Math.abs(i - (values.indexOf(indexes.get(i))));
            if (diff > indexDiff) {
                diff = indexDiff;
                result = indexes.get(i);
            }
            if (diff == indexDiff) {
                if (result > indexes.get(i)) {
                    result = indexes.get(i);
                }
            }
        }
        return result;
    }
}
