package edu.bit.datastructures.dp;

import java.util.*;

/**
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
 * <p>
 * You're given the startTime, endTime and profit arrays,
 * return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
 * <p>
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 */
public class MaximumProfit {

    private Map<Integer, Integer> dp;

    record Job(int startTime, int endTime, int profit) {
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>(startTime.length);
        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        jobs.sort(Comparator.comparingInt(Job::startTime));

        dp = new HashMap<>();
        return dfs(0, jobs);
    }

    private int dfs(int cur, List<Job> jobs) {
        if (cur == jobs.size()) {
            return 0;
        }

        if (dp.containsKey(cur)) {
            return dp.get(cur);
        }

        int next = findNext(cur, jobs);
        int inclProf = jobs.get(cur).profit() + (next == -1 ? 0 : dfs(next, jobs));
        int exclProf = dfs(cur + 1, jobs);

        dp.put(cur, Math.max(inclProf, exclProf));

        return Math.max(inclProf, exclProf);
    }

    // helps with multiple jobs with same start time as well
    private int findNext(int cur, List<Job> jobs) {
        for (int next = cur + 1; next < jobs.size(); next++) {
            if (jobs.get(next).startTime() >= jobs.get(cur).endTime()) {
                return next;
            }
        }
        return -1;
    }
}
