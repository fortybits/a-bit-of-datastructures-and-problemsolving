package edu.bit.datastructures.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OpenTheLockTest {

    OpenTheLock openTheLock = new OpenTheLock();

    @Test
    void testOpenLock() {
        Assertions.assertEquals(-1,
                openTheLock.openLock(new String[]{"0000"}, "8888"));
        Assertions.assertEquals(-1,
                openTheLock.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
        Assertions.assertEquals(1,
                openTheLock.openLock(new String[]{"8888"}, "0009"));
        Assertions.assertEquals(6,
                openTheLock.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }
}