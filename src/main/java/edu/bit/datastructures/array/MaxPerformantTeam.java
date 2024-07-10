package edu.bit.datastructures.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * You are given two integers n and k and two integer arrays speed and efficiency both of length n.
 * There are n engineers numbered from 1 to n. speed[i] and efficiency[i] represent
 * the speed and efficiency of the ith engineer respectively.
 * <p>
 * Choose at most k different engineers out of the n engineers to form a team with the maximum performance.
 * <p>
 * The performance of a team is the sum of their engineers'
 * speeds multiplied by the minimum efficiency among their engineers.
 * <p>
 * Return the maximum performance of this team.
 * Since the answer can be a huge number, return it modulo 109 + 7.
 */
public class MaxPerformantTeam {

    static final int MOD = (int) (1e9 + 7);

    // keep two heaps
    // one with max speed (size k)
    // another with min efficiency (size k)
    // for(k+1:n)
    // if(speed > top(maxSpeed) && efficiency > top(minEfficiency))
    // then replace the minimum efficiency element
    // else if(efficiency>top(minEfficiency)) then push
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Engineer> engineers = IntStream.range(0, n)
                .mapToObj(i -> new Engineer(speed[i], efficiency[i]))
                .sorted(Comparator.comparingInt(Engineer::getEfficiency).reversed())
                .collect(Collectors.toList());

        PriorityQueue<Engineer> pq = new PriorityQueue<>(k,
                Comparator.comparingInt(Engineer::getSpeed));

        int totalSpeed = 0;
        long res = 0;
        for (int i = 0; i < k; i++) {
            Engineer currentEngineer = engineers.get(i);
            pq.add(currentEngineer);
            totalSpeed = totalSpeed + currentEngineer.getSpeed();
            res = Math.max(res, ((long) totalSpeed * currentEngineer.getEfficiency()));
        }

        for (int i = k; i < engineers.size(); i++) {
            pq.add(engineers.get(i));
            totalSpeed = (totalSpeed + engineers.get(i).speed);
            totalSpeed = totalSpeed - pq.poll().getSpeed(); // layoff the one with min speed
            res = Math.max(res, ((long) totalSpeed * engineers.get(i).getEfficiency()));  // min efficiency is the efficiency of new engineer
        }

        return (int) (res % MOD);
    }

    // apparently https://github.com/LeetCode-Feedback/LeetCode-Feedback/issues/3752
    // and then realised, the question reads "at most K"
    public int maxPerformanceSpaceOpt(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = IntStream.range(0, n)
                .mapToObj(i -> new int[]{efficiency[i], speed[i]})
                .toArray(int[][]::new);
        Arrays.sort(engineers, (a, b) -> Integer.compare(b[0], a[0]));
        PriorityQueue<Integer> minSpeedHeap = new PriorityQueue<>(k, Comparator.naturalOrder());

        long totalSpeed = 0;
        long result = 0;
        for (int[] engineer : engineers) {
            minSpeedHeap.add(engineer[1]);
            totalSpeed = totalSpeed + engineer[1];
            if (minSpeedHeap.size() > k) {
                totalSpeed = totalSpeed - minSpeedHeap.poll();
            }
            result = Math.max(result, (totalSpeed * engineer[0]));
        }
        return (int) (result % (long) (1e9 + 7));
    }

    static class Engineer {
        int speed;
        int efficiency;

        public Engineer(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }

        public int getEfficiency() {
            return efficiency;
        }

        public int getSpeed() {
            return speed;
        }
    }
}