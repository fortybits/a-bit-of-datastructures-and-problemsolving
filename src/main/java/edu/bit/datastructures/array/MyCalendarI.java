package edu.bit.datastructures.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class MyCalendarI {
    private final List<int[]> books = new ArrayList<>();
    TreeSet<int[]> sortedBooks = new TreeSet<>(Comparator.comparingInt((int[] a) -> a[0]));

    public boolean book(int start, int end) {
        for (int[] b : books) { // iterate through each book
            if (Math.max(b[0], start) < Math.min(b[1], end)) {
                return false;
            }
        }
        books.add(new int[]{start, end});
        return true;
    }

    public boolean bookOpt(int start, int end) {
        int[] book = new int[]{start, end};
        int[] floor = sortedBooks.floor(book);
        if (floor != null && start < floor[1]) { // compare start with previous end
            return false;
        }
        int[] ceiling = sortedBooks.ceiling(book);
        if (ceiling != null && ceiling[0] < end) { // compare end with next start
            return false;
        }
        sortedBooks.add(book);
        return true;
    }
}
