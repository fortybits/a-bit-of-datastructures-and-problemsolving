package org.atlassian.limiter.config;

import java.util.concurrent.TimeUnit;

public record RateLimitConfiguration(int maxRequests, int timeDuration, TimeUnit timeUnit) {
}