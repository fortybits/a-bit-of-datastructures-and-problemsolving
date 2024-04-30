package edu.bit.datastructures.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumCapital {

    public static void main(String[] args) {
        MaximumCapital maximumCapital = new MaximumCapital();
        int result = maximumCapital.findMaximizedCapital(3, 2,
                new int[]{4, 1, 9, 2, 7}, new int[]{1, 2, 3, 4, 5});
        System.out.println(result);

        result = maximumCapital.findMaximizedCapital(2, 7,
                new int[]{4, 8, 12, 14}, new int[]{6, 7, 8, 10});
        System.out.println(result);
    }

    class Project {
        int cost;
        int profit;

        int getCost() {
            return cost;
        }

        int getProfit() {
            return profit;
        }

        public Project(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    /**
     * Approach : 1
     * (nlogn) pre-compute : sort the list of projects based on the cost
     * List<Project> projects; // sortedByCost
     * <p>
     * create heaps based on the cost:minHeap and for profit:maxHeap
     * int overallCapital;
     * k times (k*n)
     * findMaxProfitPossibleGivenACapital(int capital):
     * iterateOverTheList (until cost is greater than capital)
     * find MaximumProfit;
     * <p>
     * return capital = capital + maximumProfit;
     * return overallCapital;
     * <p>
     * <p>
     * k times (k*n*logn)
     * findMaxProfitPossibleGivenACapital(int capital):
     * remove from minHeap and insert the profit on maxHeap
     * find MaximumProfit(root);
     * <p>
     * return capital = capital + maximumProfit;
     * return overallCapital;
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int length = capital.length;
        List<Project> projects = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            projects.add(new Project(capital[i], profits[i]));
        }

        Collections.sort(projects, Comparator.comparingInt(Project::getCost));

        int overallCapital = w;

        for (int m = k; m > 0; m--) {
            int maximumProfit = findMaxProfitPossibleGivenACapital(overallCapital, projects);
            overallCapital = overallCapital + maximumProfit;

        }
        return overallCapital;
    }

    private int findMaxProfitPossibleGivenACapital(int capital, List<Project> projects) {
        int maxProfit = 0;
        if (projects.isEmpty()) return maxProfit;
        int profitIndex = 0;
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getCost() > capital) {
                break;
            } else {
                if (projects.get(i).getProfit() > maxProfit) {
                    maxProfit = projects.get(i).getProfit();
                    profitIndex = i;
                }
            }
        }
        projects.remove(profitIndex);
        return maxProfit;
    }
}