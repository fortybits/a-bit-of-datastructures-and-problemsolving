package org.salesforce;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://leetcode.com/problems/exclusive-time-of-functions/description/
public class FunctionsWithPreemption {
    /*
     * Complete the 'getTotalExecutionTime' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY logs
     */
    public static List<Integer> getTotalExecutionTime(int n, List<String> logs) {
        Map<Integer, Slot> functionsToExecute = new TreeMap<>(Comparator.reverseOrder());

        int startTime = Integer.MAX_VALUE;
        int endTime = Integer.MIN_VALUE;
        for (int i = 0; i < logs.size(); i++) {
            String[] log = logs.get(i).split(":");
            int functionNumber = Integer.valueOf(log[0]);
            String param = log[1];
            int timestamp = Integer.parseInt(log[2]);
            if (startTime < timestamp) startTime = timestamp;
            if (endTime > timestamp) endTime = timestamp;
            if (param.equals("start")) {
                Slot slot = new Slot();
                slot.startTime = timestamp;
                functionsToExecute.put(functionNumber, slot);
            } else {
                Slot existingSlot = functionsToExecute.get(functionNumber);
                existingSlot.endTime = timestamp;
                functionsToExecute.put(functionNumber, existingSlot);
            }
        }

        int[] slotsOfOccurrence = new int[endTime - startTime + 1];
        Arrays.fill(slotsOfOccurrence, Integer.MIN_VALUE);

        for (Map.Entry<Integer, Slot> entry : functionsToExecute.entrySet()) {
            Integer key = entry.getKey();
            Slot slot = entry.getValue();
            for (int j = slot.startTime; j <= slot.endTime; j++) {
                if (slotsOfOccurrence[j] != Integer.MIN_VALUE) {
                    slotsOfOccurrence[j] = key;
                }
            }
        }

        Map<Integer, Integer> durationCount = new TreeMap<>(Comparator.naturalOrder());
        for (int j : slotsOfOccurrence) {
            if (durationCount.containsKey(j)) {
                int currentCount = durationCount.get(j);
                durationCount.put(j, currentCount + 1);
            } else {
                durationCount.put(j, 1);
            }
        }

        return new ArrayList<>(durationCount.values());
    }

    static class Slot {
        int startTime;
        int endTime;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int logsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> logs = IntStream.range(0, logsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(Collectors.toList());

        List<Integer> result = getTotalExecutionTime(n, logs);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Log> stack = new ArrayDeque<>();
        int[] result = new int[n];
        for (String content : logs) {
            Log log = new Log(content);
            if (log.isStart) {
                stack.push(log);
            } else {
                Log top = stack.pop();
                result[top.id] += (log.time - top.time + 1);
                if (!stack.isEmpty()) {
                    result[stack.peek().id] -= (log.time - top.time + 1);
                }
            }
        }

        return result;
    }

    public static class Log {
        public int id;
        public boolean isStart;
        public int time;

        public Log(String content) {
            String[] strs = content.split(":");
            id = Integer.valueOf(strs[0]);
            isStart = strs[1].equals("start");
            time = Integer.valueOf(strs[2]);
        }
    }
}