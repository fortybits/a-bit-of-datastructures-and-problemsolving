package edu.bit.datastructures.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * F(n) = F(n - 1) + F(n - 2)
 */
public class Fibonacci {

    // memoization
    Map<Integer, Integer> mem = new HashMap<>();


    private int fib(int N) {
        if (mem.containsKey(N)) {
            return mem.get(N);
        }
        int result;
        if (N < 2) {
            result = N;
        } else {
            result = fib(N - 1) + fib(N - 2);
        }
        // keep the result in cache.
        mem.put(N, result);
        return result;
    }
}
