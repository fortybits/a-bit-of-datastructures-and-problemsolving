package org.atlassian.limiter;

import org.atlassian.limiter.config.RateLimitConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * This is the place to start off the track of a bit of anything.
 * <p>
 * Rate limiter implementation enforces per customer rate limit.
 * each customer can make X requests for Y seconds
 * <p>
 * // Perform rate limiting logic for provided customer ID. Return true if the
 * // request is allowed, and false if it is not.
 * boolean rateLimit(int customerId)
 */
public class RateLimiter {

    private final int maxRequests; // X
    private final int timeDuration; // Y
    private final TimeUnit timeUnit; // SECONDS
    private final Map<Integer, Map<Long, Integer>> customerRequestsPerDurationCount;

    public RateLimiter(RateLimitConfiguration rateLimitConfiguration) { // X requests per Y unit
        this.maxRequests = rateLimitConfiguration.maxRequests();
        this.timeDuration = rateLimitConfiguration.timeDuration();
        this.timeUnit = rateLimitConfiguration.timeUnit();
        this.customerRequestsPerDurationCount = new HashMap<>();
    }

    public boolean rateLimit(int customerId) {
        long timeGroup = groupTheRequest();
        Map<Long, Integer> timeBasedRequest = customerRequestsPerDurationCount
                .getOrDefault(customerId, new HashMap<>());
        int currentRequests = timeBasedRequest.getOrDefault(timeGroup, Integer.MIN_VALUE);

        if (currentRequests < maxRequests) {
            timeBasedRequest.put(timeGroup, currentRequests + 1);
            customerRequestsPerDurationCount.put(customerId, timeBasedRequest);
            return true;
        } else {
            return false;
        }
    }

    private long groupTheRequest() { // testing this is a trial with luck on lower throughput sequential requests
        long currentTimeMillis = System.currentTimeMillis();
        return (currentTimeMillis - convertTimeDurationInMillis());
    }

    private long convertTimeDurationInMillis() { // base start time?
        // use time unit here
        return timeDuration;
    }
}