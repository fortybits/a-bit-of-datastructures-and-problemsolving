package edu.bit.datastructures.string;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on
 * a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 */
public class ZigZagConversion {

    // Input: s = "PAYPALISHIRING", numRows = 3
    // Output: "PAHNAPLSIIGYIR"
    //P   A   H   N
    //A P L S I I G
    //Y   I   R
    public String convertToZigZag(String s, int numRows) {
        if (s.length() <= numRows) {
            return s;
        }
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] eachRowBuffer = new StringBuffer[numRows];
        for (int i = 0; i < eachRowBuffer.length; i++) {
            eachRowBuffer[i] = new StringBuffer();
        }

        int i = 0;
        while (i < len) {
            // vertically down
            for (int idx = 0; idx < numRows && i < len; idx++) {
                eachRowBuffer[idx].append(c[i++]);
            }
            // obliquely up
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) {
                eachRowBuffer[idx].append(c[i++]);
            }
        }
        for (int idx = 1; idx < eachRowBuffer.length; idx++) {
            eachRowBuffer[0].append(eachRowBuffer[idx]);
        }
        return eachRowBuffer[0].toString();
    }
}