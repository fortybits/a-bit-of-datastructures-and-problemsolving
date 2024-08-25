package edu.bit.datastructures.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IsBadVersionTest {

    IsBadVersion isBadVersion;

    @Test
    void testBadVersion() {
        isBadVersion = new IsBadVersion(2);
        Assertions.assertEquals(2, isBadVersion.firstBadVersion(3));
        isBadVersion = new IsBadVersion(4);
        Assertions.assertEquals(4, isBadVersion.firstBadVersion(5));
        isBadVersion = new IsBadVersion(1);
        Assertions.assertEquals(1, isBadVersion.firstBadVersion(1));
    }
}