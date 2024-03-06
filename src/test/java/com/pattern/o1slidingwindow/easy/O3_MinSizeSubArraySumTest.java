package com.pattern.o1slidingwindow.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class O3_MinSizeSubArraySumTest {

    @Test
    public void testReturnsZeroIfArrayIsEmpty() {
        // Given
        int S = 7;
        int[] arr = {};

        // When
        int result = O3_MinSizeSubArraySum.findMinSubArray(S, arr);

        // Then
        assertEquals(0, result);
    }

    @Test
    public void testResultMatchesExpectedOutputI() {
        assertEquals(2,
                O3_MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
    }
    @Test
    public void testResultMatchesExpectedOutputII() {
        assertEquals(1,
                O3_MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 8}));
    }

    @Test
    public void testResultMatchesExpectedOutputIII() {
        assertEquals(3,
                O3_MinSizeSubArraySum.findMinSubArray(8, new int[]{3, 4, 1, 1, 6}));
    }

    @Test
    public void testResultGivesZero() {
        assertEquals(0, O3_MinSizeSubArraySum.findMinSubArray(20, new int[]{3, 4, 1, 1, 6}));
    }

    @Test
    public void testIllegalArgumentExceptionWhenSIsZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            O3_MinSizeSubArraySum.findMinSubArray(0, new int[]{});
        });
    }
}