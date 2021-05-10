package edu.bit.datastructures.array;

/**
 * Given a non-empty array nums containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 */
public class CanPartition {

    SubSetSum subSetSum = new SubSetSum();

    // initial step is to find out that partition is even possible for not for the given numbers

    public boolean canPartition(int[] nums) {
        PartitionResult partitionResult = partitionResult(nums);
        if (!partitionResult.feasible()) {
            return false;
        }
        int sum = partitionResult.sum();
        return subSetSum.isSubsetSum(nums, sum);
    }

    static record PartitionResult(boolean feasible, int sum) {
    }

    private PartitionResult partitionResult(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return new PartitionResult(false, sum);
        }
        sum /= 2;
        return new PartitionResult(true, sum);
    }

    public boolean canPartitionOptimiseSpace(int[] nums) {
        PartitionResult partitionResult = partitionResult(nums);
        if (!partitionResult.feasible()) {
            return false;
        }
        int sum = partitionResult.sum();
        return subSetSum.isSubsetSumSpaceOptimised(nums, sum);
    }
}