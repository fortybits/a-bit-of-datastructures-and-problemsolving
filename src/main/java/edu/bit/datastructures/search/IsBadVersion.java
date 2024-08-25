package edu.bit.datastructures.search;

public class IsBadVersion {
    private final int badVersion;

    public IsBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    boolean isBadVersion(int n) {
        return n == badVersion;
    }
}
