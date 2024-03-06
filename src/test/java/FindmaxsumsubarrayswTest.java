import com.pattern.O1slidingwindow.easy.O2_MaxSumSubArrayOfSizeK;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FindmaxsumsubarrayswTest {
    // returns the maximum sum of any contiguous subarray of size 'k' in the input array
    @Test
    public void test_returns_maximum_sum_of_contiguous_subarray() {
        // Given
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
    
        // When
        int result = O2_MaxSumSubArrayOfSizeK.findMaxSumSubArraySW(arr, k);
    
        // Then
        assertEquals(9, result);
    }

    // returns the correct output for the input [2, 1, 5, 1, 3, 2] and k=3
    @Test
    public void test_findMaxSumSubArraySW_withValidInputI() {
        // Given
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
    
        // When
        int result = O2_MaxSumSubArrayOfSizeK.findMaxSumSubArraySW(arr, k);
    
        // Then
        assertEquals(9, result);
    }

    // returns the correct output for the input [1, 2, 3, 4, 5] and k=5
    @Test
    public void test_findMaxSumSubArraySW_withValidInputII() {
        // Given
        int[] arr = {1, 2, 3, 4, 5};
        int k = 5;
    
        // When
        int result = O2_MaxSumSubArrayOfSizeK.findMaxSumSubArraySW(arr, k);
    
        // Then
        assertEquals(15, result);
    }

    // throws an IllegalArgumentException when k is larger than the input array length
    @Test
    public void test_findMaxSumSubArraySW_withInvalidK() {
        // Given
        int[] arr = {1, 2, 3, 4, 5};
        int k = 6;
    
        // When and Then
        assertThrows(IllegalArgumentException.class, () -> {
            O2_MaxSumSubArrayOfSizeK.findMaxSumSubArraySW(arr, k);
        });
    }

    // throws an IllegalArgumentException if k is less than or equal to 0
    @Test
    public void test_findMaxSumSubArrayIllegalArgI() {
        // Given
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = -3;

        // When
        assertThrows(IllegalArgumentException.class, () -> {
            O2_MaxSumSubArrayOfSizeK.findMaxSumSubArraySW(arr, k);
        });

        // Then
        // IllegalArgumentException is thrown
    }

    // throws an IllegalArgumentException if k is greater than the length of the input array
    @Test
    public void test_findMaxSumSubArrayIllegalArgII() {
        // Given
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 7;

        // When
        assertThrows(IllegalArgumentException.class, () -> {
            O2_MaxSumSubArrayOfSizeK.findMaxSumSubArraySW(arr, k);
        });

        // Then
        // IllegalArgumentException is thrown
    }

    // Returns the sum of the input array if the length is 1 and k is 1
    @Test
    public void test_returns_sum_if_length_is_1_and_k_is_1() {
        // Given
        int[] arr = {5};
        int k = 1;
    
        // When
        int result = O2_MaxSumSubArrayOfSizeK.findMaxSumSubArraySW(arr, k);
    
        // Then
        assertEquals(5, result);
    }

}