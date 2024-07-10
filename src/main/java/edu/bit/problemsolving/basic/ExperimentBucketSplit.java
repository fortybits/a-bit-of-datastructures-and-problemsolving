package edu.bit.problemsolving.basic;

import java.util.*;
import java.util.stream.IntStream;

public class ExperimentBucketSplit {

    static final int EXPERIMENT_SIZE = 100;
    static Random random = new Random();
    static List<Bucket> experimentBuckets = new ArrayList<>(EXPERIMENT_SIZE);

    public static void main(String[] args) throws IllegalAccessException {
        String operation = args[0];
        Operation valueOf = Operation.valueOf(operation.toUpperCase(Locale.ROOT));
        if (valueOf == Operation.CREATE) {
            createExperimentBuckets(args);
        } else if (valueOf == Operation.GET) {
            Bucket randomBucket = getRandomBucket();
            System.out.println(randomBucket);
        }
    }

    // accepting the format a:57 b:23 c:20
    private static void createExperimentBuckets(String[] args) throws IllegalAccessException {
        for (int i = 1; i < args.length; i++) {
            String[] keyValue = args[i].split(":");
            String bucketName = keyValue[0];
            int ratio = Integer.parseInt(keyValue[1]);
            List<Bucket> subSplit = IntStream.iterate(1, count -> count <= ratio, count -> count + 1)
                    .mapToObj(val -> new Bucket(bucketName))
                    .toList();
            experimentBuckets.addAll(subSplit);
        }
        if (experimentBuckets.size() != 100) {
            throw new IllegalAccessException("Incorrect ratio defined for the split! Args: " + Arrays.toString(args));
        }
    }

    private static Bucket getRandomBucket() throws IllegalAccessException {
        if (experimentBuckets.size() != 100) {
            throw new IllegalAccessException("Bucket not created successfully! Bucket Size:" + experimentBuckets.size());
        }
        return experimentBuckets.get(random.nextInt(EXPERIMENT_SIZE));
    }

    enum Operation {
        CREATE, GET
    }

    record Bucket(String name) {
    }
}