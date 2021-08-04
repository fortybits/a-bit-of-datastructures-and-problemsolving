package edu.bit.datastructures.array;

import edu.bit.annotations.organisation.Google;

import java.util.ArrayList;
import java.util.List;

/**
 * Road Trip: Given a list of the distances between cities, write a
 * function that will return the set of towns that you will stop at each
 * day.  Assuming we ideally want to travel 100 miles per day, how can
 * you find the best plan?
 * <p>
 * Example,
 * <p>
 * A ------- B ---- C ------ D ----- E ----- F
 * input = [   70    ,  40  ,   60   ,   50  ,   50  ]
 * <p>
 * cost = (dist - 100)^2
 */
@Google
public class RoadTripBestPlan {


//    A -> B , B -> D, D -> F cost = 30^2
//    A -> C, C --> E, E-> F cost = 10^2 + 10^2 + 50^2
//
//
//    threshold 90
//    A ------- B ---- C ------ D ----- E ----- F
//    input = [   110    ,  40  ,   60   ,   50  ,   50  ]
//    output = A,B,D,
//
//
//    cost [i] (90-110)
//    cost [i+1] (90-150) B
//
//  if(cost[i] < cost[i+1]) { add i as a stop)
//
//        cost [C] (90-40)
//        cost [D] (90-100)
//        cost [E] (90-150) // add D as a stop

    // [110    ,  40  ,   60   ,   50  ,   50] ==  90
    List<Integer> findBestPlan(int[] dist, int threshold) {
        int n = dist.length;

        int[] prefixSum = new int[n];
        int prefixVal = 0;
        for (int i = 0; i < n; i++) {
            prefixVal += dist[i];
            prefixSum[i] = prefixVal;
        }
        // 110, 150, 210, 260, 310
        // 110, 150, 210, 260, 310

        List<Integer> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) { // should behave as a checkpoint  // 0 , 1, 2
            int prevCost = Math.abs(dist[i] - threshold); // 20 , 50
            int currentCost = 0;
            for (int j = i + 1; j < n; j++) { // 1, 2, 3
                currentCost = Math.abs(prefixSum[j] - (i == 0 ? 0 : prefixSum[i - 1]) - threshold); // 60  , 10, 60
                if (currentCost > prevCost) {
                    result.add(j - 1); // 1, 2
                    i = j - 1;
                }
            }
        }
        return result;

    }
}