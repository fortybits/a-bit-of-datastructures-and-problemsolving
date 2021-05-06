package edu.bit.datastructures.tree;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentWords {
    // what would be the range of N and K, is there a possible relation that could be drawn?
    public List<String> topKFrequent(String[] words, int k) {
        // group them into a frequency map [runtime: O(N)] [space: O(N)]
        Map<String, Long> frequencyMap = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        // alternate thoughts:
        // sort the entries based on the frequency and then by word [worst case: this would be O(NlogN)]
        // limit the result to K
        // improvements, while sorting if I am interested only in first K numbers?

        // create a max heap and ensure only K elements in it,
        // the insertion in this shall be logK for n elements resulting in O(N*logK)

        // Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue)
        //    .thenComparing(Comparator.<Map.Entry<String, Long>>comparing(e -> e.getKey()).reversed());
        PriorityQueue<Map.Entry<String, Long>> minHeap = new PriorityQueue<>((o1, o2) ->
                o1.getValue().equals(o2.getValue()) ?
                        o2.getKey().compareTo(o1.getKey()) :
                        o1.getValue().compareTo(o2.getValue()));


        for (Map.Entry<String, Long> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> strings = new ArrayList<>(minHeap.size());
        while (!minHeap.isEmpty()) {
            strings.add(minHeap.poll().getKey());
        }
        Collections.reverse(strings);
        return strings;
    }
}