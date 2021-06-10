package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyCalendarITest {

    @Test
    void testBookOpt() {
        MyCalendarI myCalendarI = new MyCalendarI();
        Assertions.assertTrue(myCalendarI.bookOpt(10, 20));
        Assertions.assertFalse(myCalendarI.bookOpt(15, 25));
        Assertions.assertTrue(myCalendarI.bookOpt(20, 30));
    }

    @Test
    void testBookLinear() {
        MyCalendarI myCalendarI = new MyCalendarI();
        Assertions.assertTrue(myCalendarI.book(10, 20));
        Assertions.assertFalse(myCalendarI.book(15, 25));
        Assertions.assertTrue(myCalendarI.book(20, 30));
    }
}