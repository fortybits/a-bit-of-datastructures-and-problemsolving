package edu.bit.datastructures.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a logger system that receives a stream of messages along with their timestamps.
 * Each unique message should only be printed{" "} at most every 10 seconds (i.e. a message printed at timestamp t
 * will prevent other identical messages from being printed until timestamp t + 10).
 * <p>
 * All messages will come in chronological order. Several messages may arrive at the same timestamp.
 * <p>
 * Implement the Logger class:
 * <p>
 * Logger() Initializes the logger object.
 * bool shouldPrintMessage(int timestamp, string message){" ".
 * Returns true if the message should be printed in the given timestamp, otherwise returns false.
 */
public class LoggerRateLimiter {

    Map<String, Integer> limiter;

    public LoggerRateLimiter() {
        limiter = new HashMap<>();
    }

    // Returns true if the message should be printed in the given timestamp, otherwise returns false.
    boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp - limiter.getOrDefault(message, -100) < 10) return false;
        limiter.put(message, timestamp);
        return true;
    }
}