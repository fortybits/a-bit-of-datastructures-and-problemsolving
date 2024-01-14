package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class MissingNumberTest {

    MissingNumber missingNumber = new MissingNumber();

    @Test
    void testFindMissing() {
        Random rand = new Random();
        int n = rand.nextInt(300) + 1;
        int missing = rand.nextInt(n + 1);
        List<MissingNumber.BitInteger> array = initialize(n, missing);
        System.out.println("The array contains all numbers but one from 0 to " + n + ", except for " + missing);
        int result = missingNumber.findMissing(array);
        // todo: verify the implementation
        System.out.println(result);
//        Assertions.assertEquals(missing, result);
    }

    /* Create a random array of numbers from 0 to n, but skip 'missing' */
    private List<MissingNumber.BitInteger> initialize(int n, int missing) {
        MissingNumber.BitInteger.INTEGER_SIZE = Integer.toBinaryString(n).length();
        List<MissingNumber.BitInteger> array = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            array.add(new MissingNumber.BitInteger(i == missing ? 0 : i));
        }

        // Shuffle the array once.
        for (int i = 0; i < n; i++) {
            int rand = i + (int) (Math.random() * (n - i));
            array.get(i).swapValues(array.get(rand));
        }

        return array;
    }
}