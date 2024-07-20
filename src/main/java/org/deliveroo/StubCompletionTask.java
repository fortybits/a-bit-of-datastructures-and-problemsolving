package org.deliveroo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StubCompletionTask {

    public static List<String> getMessageStatus(List<Integer> timestamps, List<String> messages, int k) {
        List<String> results = new ArrayList<>();
        Map<String, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < timestamps.size(); i++) {
            String message = messages.get(i);
            Integer currentTimestamp = timestamps.get(i);

            if (lastSeen.containsKey(message)) {
                Integer lastTimestamp = lastSeen.get(message);
                if (currentTimestamp - lastTimestamp >= k) {
                    results.add("true");
                } else {
                    results.add("false");
                }
            } else {
                results.add("true");
            }
            lastSeen.put(message, currentTimestamp);
        }

        return results;
    }
}