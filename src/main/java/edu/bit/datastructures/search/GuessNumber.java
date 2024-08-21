package edu.bit.datastructures.search;

import java.util.List;
import java.util.Random;

/**
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 * <p>
 * You call a pre-defined API int guess(int num), which returns three possible results:
 * <p>
 * -1: Your guess is higher than the number I picked (i.e. num > pick).
 * 1: Your guess is lower than the number I picked (i.e. num < pick).
 * 0: your guess is equal to the number I picked (i.e. num == pick).
 * Return the number that I picked.
 * <p>
 * Constraints:
 * 1 <= n <= 231 - 1
 * 1 <= pick <= n
 */
public class GuessNumber {

    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0) return mid;
            if (res == -1) {
//                System.out.println(mid + " is larger than pick");
                high = mid - 1;
            }
            if (res == 1) {
//                System.out.println(mid + " is smaller than pick");
                low = mid + 1;
            }
        }
        return low;

    }

    int guess(int num) {
        return List.of(-1, 0, 1).get(new Random().nextInt(2));
    }

}
