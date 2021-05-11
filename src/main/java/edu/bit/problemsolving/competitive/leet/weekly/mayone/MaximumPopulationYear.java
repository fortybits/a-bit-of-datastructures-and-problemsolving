package edu.bit.problemsolving.competitive.leet.weekly.mayone;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a 2D integer array logs where each logs[i] = [birthi, deathi]
 * indicates the birth and death years of the ith person.
 * <p>
 * The population of some year x is the number of people alive during that year.
 * The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1].
 * Note that the person is not counted in the year that they die.
 * <p>
 * Return the earliest year with the maximum population.
 */
public class MaximumPopulationYear {

    public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> collect = new HashMap<>();
        for (int[] a : logs) {
            for (int i = a[0]; i < a[1]; i++) {
                collect.merge(i, 1, Integer::sum);
            }
        }

        int maxFreq = Integer.MIN_VALUE;
        int minYear = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> yearToPopulation : collect.entrySet()) {
            int currentYear = yearToPopulation.getKey();
            int currentPopulation = yearToPopulation.getValue();
            if (maxFreq < currentPopulation) {
                minYear = currentYear;
                maxFreq = currentPopulation;
            }
            if (maxFreq == currentPopulation && minYear > currentYear) {
                minYear = currentYear;
                maxFreq = currentPopulation;
            }
        }
        return minYear;
    }
}
