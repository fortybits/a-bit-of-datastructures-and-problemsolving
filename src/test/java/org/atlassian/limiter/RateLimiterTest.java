package org.atlassian.limiter;

import org.atlassian.limiter.config.RateLimitConfiguration;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

class RateLimiterTest {

    @Test()
    void testRateLimiting() {
        RateLimitConfiguration rateLimitConfiguration = new RateLimitConfiguration(2, 3, TimeUnit.MILLISECONDS);
        RateLimiter rateLimiter = new RateLimiter(rateLimitConfiguration);
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
    }
}