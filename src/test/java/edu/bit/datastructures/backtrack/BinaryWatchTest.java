package edu.bit.datastructures.backtrack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BinaryWatchTest {

    BinaryWatch binaryWatch = new BinaryWatch();

    @Test
    void readBinaryWatch() {
        Assertions.assertEquals(List.of("0:01", "0:02", "0:04", "0:08", "0:16", "0:32", "1:00", "2:00", "4:00", "8:00"),
                binaryWatch.readBinaryWatch(1));
        Assertions.assertEquals(List.of(),
                binaryWatch.readBinaryWatch(9));

        Assertions.assertEquals(List.of("0:01", "0:02", "0:04", "0:08", "0:16", "0:32", "1:00", "2:00", "4:00", "8:00"),
                binaryWatch.readBinaryWatchOpt(1));
        Assertions.assertEquals(List.of(),
                binaryWatch.readBinaryWatchOpt(9));
    }
}