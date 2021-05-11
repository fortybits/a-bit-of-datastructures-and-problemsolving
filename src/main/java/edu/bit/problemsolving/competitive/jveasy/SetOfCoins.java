package edu.bit.problemsolving.competitive.jveasy;

import java.util.*;
import java.util.stream.Collectors;

public class SetOfCoins {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        System.out.println(magicLand(new int[]{2, 4, 2, 3, 1}, 3));
        System.out.println(magicLand(new int[]{2, 4, 2, 3, 1}, 2));
        System.out.println(magicLand(new int[]{2, 4, 20, 3, 11, 123}, 4));
    }

    static long magicLand(int[] Amount, int M) {
        List<Integer> amounts = Arrays.stream(Amount)
                .boxed()
                .collect(Collectors.toList());
        Set<List<Integer>> combinations = getCombinations(M, amounts);
        return combinations.stream()
                .mapToLong(Collections::max)
                .sum();
    }

    static <T> Set<List<T>> getCombinations(int M, List<T> list) {
        Set<List<T>> combinations = new HashSet<>();
        if (M == 0 && list.size() == 0) {
            combinations.add(new ArrayList<>());
            return combinations;
        }
        // If N or K is less than 0
        if (list.size() <= 0 || M <= 0) {
            return combinations;
        }
        for (int i = 0; i < list.size(); i++) {
            T element = list.get(i);
            for (List<T> previous : getCombinations(M - i, list.subList(i, list.size()))) {
                previous.add(element);
                combinations.add(previous);
            }
        }
        return combinations;
    }
}