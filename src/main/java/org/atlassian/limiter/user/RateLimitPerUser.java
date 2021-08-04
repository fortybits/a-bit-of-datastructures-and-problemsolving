package org.atlassian.limiter.user;

import org.atlassian.limiter.RateLimiter;

import java.util.HashMap;
import java.util.Map;

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
public class RateLimitPerUser {

    Map<Integer, RateLimiter> perCustomerRateLimit;

    public RateLimitPerUser() {
        this.perCustomerRateLimit = new HashMap<>();
    }

    public boolean rateLimit(int customerId) {
        RateLimiter rateLimiter = perCustomerRateLimit.get(customerId);
        if (rateLimiter != null) {
            return rateLimiter.rateLimit(customerId);
        } else {
            return true;
        }
    }
}
