package edu.bit.datastructures.array;


/**
 * Given an integer array nums, handle multiple queries of the following types:
 * <p>
 * Update the value of an element in nums.
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * Implement the NumArray class:
 * <p>
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * void update(int index, int val) Updates the value of nums[index] to be val.
 * int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and
 * right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 */
public class RangeSumQuery {

    class NumArray {

        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public void update(int index, int val) {
            if (nums.length > index) {
                nums[index] = val;
            }
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum = sum + nums[i];
            }
            return sum;
        }
// --------

        class NumRR {
            int[] nums;
            int[] BIT;
            int n;

            public NumRR(int[] nums) {
                this.nums = nums;

                n = nums.length;
                BIT = new int[n + 1];
                for (int i = 0; i < n; i++)
                    init(i, nums[i]);
            }

            public void init(int i, int val) {
                i++;
                while (i <= n) {
                    BIT[i] += val;
                    i += (i & -i);
                }
            }

            void update(int i, int val) {
                int diff = val - nums[i];
                nums[i] = val;
                init(i, diff);
            }

            public int getSum(int i) {
                int sum = 0;
                i++;
                while (i > 0) {
                    sum += BIT[i];
                    i -= (i & -i);
                }
                return sum;
            }

            public int sumRange(int i, int j) {
                return getSum(j) - getSum(i - 1);
            }
        }
    }
}