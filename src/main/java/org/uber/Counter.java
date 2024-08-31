package org.uber;

import java.util.*;

/**
 * Write a counter library, where each element expires after sometime.
 * Example -
 * counter = new Counter(5) // all elements expires after 5 unit of time - seconds
 * <p>
 * // count(t1, a)
 * // count(t1, a)
 * // count(t2, a)
 * // count(t2, c)
 * // count(t3, d)
 * <p>
 * // getCount(t4, a) //2
 * // getCount(t4, c) //1
 * // getCount(t6, a) //1
 * // getCount(t6, c) //1
 * // getCount(t6, d) //1
 */
public class Counter {


    int expiryTime; // N

    // first approach was to store N buckets of time
    Map<Integer, List<String>> timeToElements; // O(1) O(N*M) // O(N*M)
    // but here the space complexity would be way more with increasing time as

    // something better was to ensure that if the elements repeat too often than instead of persisting the list,
    // we store frequencies of the occurrence of each
    final Map<String, Map<Integer, Integer>> countOfElement; // O(1), O(N), O(N*M)


    // further optimised approach could be to use a priority queue persisting elements with expiry
    record Element(String elementName, long expiryTime) {
    }

    private final Map<String, Integer> counter;
    private final PriorityQueue<Element> expiryQueue;

    public Counter(int expiryTime) {
        this.expiryTime = expiryTime;
        this.countOfElement = new HashMap<>();
        this.counter = new HashMap<>();
        this.expiryQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a.expiryTime));
    }


    public void count(int time, String elementName) {
        if (countOfElement.containsKey(elementName)) {
            Map<Integer, Integer> buckets = countOfElement.get(elementName);
            if (buckets.containsKey(time)) {
                buckets.put(time, buckets.get(time) + 1); // concurrency!
            } else {
                buckets.put(time, 1);
            }
        } else {
            Map<Integer, Integer> buckets = new HashMap<>();
            buckets.put(time, 1);
            countOfElement.put(elementName, buckets);
        }
    }


    public int getCount(int time, String elementName) {
        Map<Integer, Integer> buckets = countOfElement.getOrDefault(elementName, new HashMap<>());
        int count = 0;
        for (int i = time - expiryTime + 1; i <= time; i++) { // O(N)
            count += buckets.getOrDefault(i, 0);
        }
        return count;
    }

    public int getCountAll(int time) {
        int countAll = 0;
        for (String key : countOfElement.keySet()) { // O(K*getCount())
            countAll += getCount(time, key);
        }
        return countAll;
    }

    public void count(long time, String element) {
        removeExpiredElements(time); // Cleanup expired elements
        counter.put(element, counter.getOrDefault(element, 0) + 1);
        expiryQueue.add(new Element(element, time + expiryTime));
    }

    public int getCount(long time, String element) {
        removeExpiredElements(time); // Cleanup expired elements
        return counter.getOrDefault(element, 0);
    }

    public int getCountAll(long time) {
        removeExpiredElements(time); // Cleanup expired elements
        return counter.values().stream().mapToInt(Integer::intValue).sum();
    }

    // O(E*logN) -> logN is amortised and the complexity is often linear O(E)
    private void removeExpiredElements(long currentTime) {
        while (!expiryQueue.isEmpty() && expiryQueue.peek().expiryTime <= currentTime) {
            Element expiredElement = expiryQueue.poll();
            String element = expiredElement.elementName();
            counter.put(element, counter.get(element) - 1);

            if (counter.get(element) <= 0) {
                counter.remove(element);
            }
        }
    }
}