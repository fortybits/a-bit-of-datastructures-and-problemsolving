package edu.bit.problemsolving.competitive.amazon;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class OptimisingBoxWeights {

    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        if (arr.isEmpty()) {
            return new ArrayList<>();
        }

        long totalWeight = arr.stream().mapToLong(Integer::longValue).sum();
        arr.sort(Comparator.reverseOrder()); // O(nlogn)

        List<Integer> minimalHeavySubset = new ArrayList<>(arr.size());
        long currentSubsetWeight = 0;

        for (int currentValue : arr) {
            if (currentSubsetWeight <= (totalWeight - currentSubsetWeight)) {
                currentSubsetWeight = currentSubsetWeight + currentValue;
                minimalHeavySubset.add(currentValue);
            } else {
                break;
            }
        }

        minimalHeavySubset.sort(Comparator.naturalOrder());
        // System.out.println("Total elements in subset: " + minimalHeavySubset.size());
        return minimalHeavySubset;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = OptimisingBoxWeights.minimalHeaviestSetA(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}