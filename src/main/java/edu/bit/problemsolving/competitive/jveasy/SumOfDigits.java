package edu.bit.problemsolving.competitive.jveasy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumOfDigits {

    private static final int BASE = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Q = scanner.nextInt();

        List<Long> sumOfDigitValues = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            long sum = sumOfDigit(scanner.nextLong());
            sumOfDigitValues.add(sum);
        }
        // construction above is O(N*M)

        List<Long> sortedValues = sumOfDigitValues.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        // O(NlogN) for preparation

        for (int i = 0; i < Q; i++) {
            int type = scanner.nextInt();
            int K = scanner.nextInt();
            if (type == 1) {
                // O(K)
                long sum = IntStream.range(0, K)
                        .mapToLong(sortedValues::get)
                        .sum();
                System.out.println(sum);
            }
            if (type == 2) {
                long sum = IntStream.iterate(sortedValues.size() - 1, j -> j - 1)
                        .limit(K)
                        .mapToLong(sortedValues::get)
                        .sum();
                System.out.println(sum);

//                long sum = ascendingOrder.stream()
//                        .limit(K)
//                        .mapToLong(l -> l)
//                        .sum();
                System.out.println(sum);
            }
        }
    }

    public static void firstKElements(int arr[], int size, int k) {
        // Creating Min Heap for given array with only k elements. Create min heap with priority queue
        PriorityQueue<Integer> minHeap = Arrays.stream(arr, 0, k)
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));
        // O(KlogN)

        // Loop For each element in array after the kth element
        for (int i = k; i < size; i++) {
            // If current element is smaller than minimum ((top element of the minHeap) element, do nothing
            // Otherwise change minimum element (top element of the minHeap) to current element
            if (minHeap.peek() < arr[i]) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        // Now min heap contains k maximum elements, Iterate and print
        Iterator<Integer> iterator = minHeap.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

    // for M digit number, this would take O(M), since we iterate those many times
    static long sumOfDigit(long num) {
        if (num / BASE == 0) {
            return num;
        } else {
            long sum = 0;
            while (num > 0) {
                sum = sum + num % BASE;
                num = num / BASE;
            }
            return sumOfDigit(sum);
        }
    }
}