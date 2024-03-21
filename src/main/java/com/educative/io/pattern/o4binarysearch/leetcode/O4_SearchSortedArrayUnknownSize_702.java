package com.educative.io.pattern.o4binarysearch.leetcode;

public class O4_SearchSortedArrayUnknownSize_702 {
    // This is ArrayReader's API interface.
    // You should not implement it, or speculate about its implementation
    interface ArrayReader {
        public default int get(int index) {
            return index;
        }
    }

    public int search(ArrayReader reader, int target) {
        // we are giving responsibility to high and that is why it is pointing to possiblly
        // right elelemt
        int low = -1, high = 1;
        while (reader.get(high) < target) {
            high = high * 2;
        }

        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (ok(reader, mid, target)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return reader.get(high) == target ? high : -1;

    }

    public boolean ok(ArrayReader reader, int mid, int target) {
        return reader.get(mid) >= target;
    }
}
