package org.atlassian.limiter;

import org.atlassian.limiter.config.RateLimitConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class RateLimiterTest {

    @Test()
    void testRateLimiting() {
        RateLimitConfiguration rateLimitConfiguration = new RateLimitConfiguration(2, 3, TimeUnit.MILLISECONDS);
        RateLimiter rateLimiter = new RateLimiter(rateLimitConfiguration);
        Assertions.assertTrue(rateLimiter.rateLimit(1));
        Assertions.assertTrue(rateLimiter.rateLimit(1));
        Assertions.assertFalse(rateLimiter.rateLimit(1));
    }
}