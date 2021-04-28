package edu.bit.datastructures.array;

import java.util.List;

/**
 * Given two integer arrays A and B of size N.
 * There are N gas stations along a circular route, where the amount of gas at station i is A[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs B[i] of gas to travel from station i
 * to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Return the minimum starting gas station’s index if you can travel around the circuit once, otherwise return -1.
 * <p>
 * You can only travel in one direction. i to i+1, i+2, … n-1, 0, 1, 2..
 * Completing the circuit means starting at i and ending up at i again.
 */
public class GasStation {

    // with the current approach the complexity of the solution is O(N*N)
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int N = A.size();
        for (int i = 0; i < N; i++) {
            int gas = 0;
            for (int j = 0; j < N; j++) {
                int index = (i + j) % N;
                gas = gas + A.get(index) - B.get(index);
                if (gas < 0) {
                    break;
                }
            }
            if (gas >= 0) {
                return i;
            }
        }
        return -1;
    }

    // todo : improve on time? would help if the array has effective value A.get(i) - B.get(i) help?
    public int canCompleteCircuitOptimised(final List<Integer> A, final List<Integer> B) {
        int n = A.size();
        int st = 0;
        int gas = 0;
        int def = 0;
        for (int i = 0; i < n; i++) { // this is O(N)
            gas = gas + (A.get(i) - B.get(i));
            if (gas < 0) {
                def = def + Math.abs(gas);
                st = i + 1;
                gas = 0;
            }
        }
        return gas - def >= 0 && st != n ? st : -1;
    }
} 