package edu.bit.datastructures.bitops;

/**
 * Given a real number between 0 and 1 (e.g. 0.72) that is passed in as a double, print the binary representation.
 * If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR"
 */
public class BinaryToString {

    public static String printBinary(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while (num > 0) {
            /* Setting a limit on length: 32 characters */
            if (binary.length() > 32) {
                return "ERROR";
            }
            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }

    public static String printBinary2(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        double fraction = 0.5;
        binary.append(".");
        while (num > 0) {
            /* Setting a limit on length: 32 characters */
            if (binary.length() >= 32) {
                return "ERROR";
            }
            if (num >= fraction) {
                binary.append(1);
                num -= fraction;
            } else {
                binary.append(0);
            }
            fraction /= 2;
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        String bs = printBinary(.125);
        System.out.println(bs);

        for (int i = 0; i < 1000; i++) {
            double num = i / 1000.0;
            String binary = printBinary(num);
            String binary2 = printBinary2(num);
            if (!binary.equals("ERROR") || !binary2.equals("ERROR")) {
                System.out.println(num + " : " + binary + " " + binary2);
            }
        }
    }
}