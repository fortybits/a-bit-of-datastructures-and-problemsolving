package edu.bit.datastructures.dp;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A car travels from a starting position to a destination which is target miles east of the starting position.
 * <p>
 * Along the way, there are gas stations.  Each station[i] represents a gas station that is
 * station[i][0] miles east of the starting position, and has station[i][1] liters of gas.
 * <p>
 * The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.
 * It uses 1 liter of gas per 1 mile that it drives.
 * <p>
 * When the car reaches a gas station, it may stop and refuel, transferring all the
 * gas from the station into the car.
 * <p>
 * What is the least number of refueling stops the car must make in order to reach its destination?
 * If it cannot reach the destination, return -1.
 * <p>
 * Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.
 * If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
 */
public class MinimumRefuelStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) {
            return 0;
        }
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0;
        int n = stations.length;
        int stops = 0;
        int maxDistance = startFuel;
        while (maxDistance < target) {
            while (i < n && stations[i][0] <= maxDistance) {
                queue.offer(stations[i++][1]);
            }
            if (queue.isEmpty()) {
                return -1;
            }
            maxDistance += queue.poll();
            stops++;
        }
        return stops;
    }

    public int minRefuelStop(int target, int startFuel, int[][] s) {
        long[] dp = new long[s.length + 1];
        dp[0] = startFuel;
        for (int i = 0; i < s.length; ++i) {
            for (int t = i; t >= 0 && dp[t] >= s[i][0]; --t) {
                dp[t + 1] = Math.max(dp[t + 1], dp[t] + s[i][1]);
            }
        }
        for (int t = 0; t <= s.length; ++t) {
            if (dp[t] >= target) {
                return t;
            }
        }
        return -1;
    }
}
