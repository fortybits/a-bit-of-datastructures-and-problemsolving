package edu.bit.problemsolving.competitive.natwest;

public class AddArithmeticProgression {

    public static void main(String[] args) {
        System.out.println(addAP(6, new int[]{2, 1, 1, 4, 5, 7}, 1, new int[][]{{1, 2, 4, 1000}}));
        System.out.println(addAP(4, new int[]{2, 1, 1, 4}, 2, new int[][]{{1, 2, 3, 1000}, {2, 3, 7, 2}}));
    }

    private static long[] addAP(int N, int[] A, int Q, int[][] operation) {
        long[] result = new long[N];
        for (int i = 0; i < N; i++) {
            result[i] = A[i];
        }

        for (int i = 0; i < Q; i++) {
            int l = operation[i][0];
            int r = operation[i][1];
            long a = operation[i][2];
            long d = operation[i][3];

            int val = 0;
            for (int j = l - 1; j <= r - 1; j++) {
                long b = a + (val * d);
                result[j] = result[j] + b;
                val++;
            }
        }

        return result;
    }
}