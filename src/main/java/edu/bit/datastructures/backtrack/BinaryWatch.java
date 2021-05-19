package edu.bit.datastructures.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11),
 * and the 6 LEDs on the bottom represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the right.
 * <p>
 * Given an integer turnedOn which represents the number of LEDs that are currently on,
 * return all possible times the watch could represent. You may return the answer in any order.
 * <p>
 * The hour must not contain a leading zero.
 * <p>
 * For example, "01:00" is not valid. It should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero.
 * <p>
 * For example, "10:2" is not valid. It should be "10:02".
 */
public class BinaryWatch {

    String[][] hour = {
            {"0"},
            {"1", "2", "4", "8"},
            {"3", "5", "6", "9", "10"},
            {"7", "11"}};

    String[][] minute = {
            {"00"},
            {"01", "02", "04", "08", "16", "32"},
            {"03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40", "48"},
            {"07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44", "49", "50", "52", "56"},
            {"15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58"},
            {"31", "47", "55", "59"}};


    // choosing the values form the hours and minute combinations 4Ct and 5C(o-t)
    // we can try and update a list of booleans like boolean hour[] = new boolean[4]; boolean minute[] = new minute[5]
    public void updateBinaryWatches(int turnedOn, List<String> time) {
        if (turnedOn == 0) {
            return;
        }
    }

    // to optimise further we can pre-compute/store all the combinations of minutes and hour and lookup into those
    public List<String> readBinaryWatchOpt(int num) {
        List<String> times = new ArrayList<>();
        if (num > 8) {
            return times;
        }
        for (int i = 0; i <= 3 && i <= num; i++) {
            for (String hr : hour[i]) {
                for (String min : minute[num - i]) {
                    times.add(hr + ":" + min);
                }
            }
        }
        return times;
    }

    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;
    }
}