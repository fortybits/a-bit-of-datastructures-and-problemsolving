package edu.bit.datastructures.recursion;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
 * <p>
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 */
public class PowerCalculation {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n > 0) {
            return x * myPow(x, n - 1);
        } else {
            return myPow(x, n + 1) / x;
        }
    }

    // log(n)
    public double pow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
    }
}
