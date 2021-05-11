package edu.bit.problemsolving.competitive.leet.weekly.april;

/**
 * Given an integer n (in base 10) and a base k,
 * return the sum of the digits of n after converting n from base 10 to base k.
 * After converting, each digit should be interpreted as a base 10 number,
 * and the sum should be returned in base 10.
 */
public class SumOfDigitsWithConversion {

    public static void main(String[] args) {
        SumOfDigitsWithConversion sum = new SumOfDigitsWithConversion();
        System.out.println(sum.sumBase(34, 6)); // 9
        System.out.println(sum.sumBase(10, 10)); // 1
    }

    public int sumBase(int n, int k) {
        if (n / k == 0) {
            return n;
        } else {
            int sum = 0;
            while (n > 0) {
                sum = sum + (n % k);
                n = n / k;
            }
            return sum;
        }
    }
}