import com.pattern.o1slidingwindow.easy.O1_AverageOfSubarrayOfSizeK;
import org.junit.Test;

import static org.junit.Assert.*;

public class findAverageSlidingWindowTest {
    // The method returns an array of length input.length - K + 1.
    @Test
    public void test_findAverageSlidingWindow_length_one() {
        // Given
        int[] input = {1, 2, 3, 6, -1, 4, 1, 8, 2};
        int K = 5;

        // When
        double[] result = O1_AverageOfSubarrayOfSizeK.findAverageSlidingWindow(input, K);

        // Then
        assertEquals(input.length - K + 1, result.length);
    }

    @Test
    public void test_findAverageSlidingWindow_length_two() {
        // Given
        int[] input = new int[]{1, 2, 3, 6, -1};
        int K = 3;

        // When
        double[] result = O1_AverageOfSubarrayOfSizeK.findAverageSlidingWindow(input, K);

        // Then
        assertEquals(3, result.length);
    }

    // The method tests the accuracy of the result
    @Test
    public void test_averageOfSubarrayOfSizeK() {
        // Given
        int[] input = new int[]{1, 2, 3, 6, -1, 4, 1, 8, 2};
        int K = 5;

        // When
        double[] result = O1_AverageOfSubarrayOfSizeK.findAverageSlidingWindow(input, K);

        // Then
        double[] expected = new double[]{2.2, 2.8, 2.6, 3.6, 2.8};
        assertArrayEquals(expected, result, 0.0000);
    }


    // The method works correctly for input arrays of length 1.
    @Test
    public void test_inputArrayLengthOne() {
        // Given
        int[] input = new int[]{5};

        // When
        double[] result = O1_AverageOfSubarrayOfSizeK.findAverageSlidingWindow(input, 1);

        // Then
        assertEquals(1, result.length);
        assertEquals(5, result[0], 0.0001);
    }

    // The method works correctly for input arrays with negative numbers.
    @Test
    public void test_negative_numbers() {
        // Given
        int[] input = new int[]{1, 2, -3, 6, -1, 4, -1, 8, 2};
        int K = 3;

        // When
        double[] result = O1_AverageOfSubarrayOfSizeK.findAverageSlidingWindow(input, K);

        // Then
        double[] expected = new double[]{0.0, 1.6666666666666667, 0.6666666666666666, 3.0, 0.6666666666666666, 3.6666666666666665, 3.0};
        assertArrayEquals(expected, result, 0.000001);
    }

    // The method throws an IllegalArgumentException if K is greater than input.length.
    @Test
    public void test_throws_exception_when_K_greater_than_input_length() {
        // Given
        int[] input = {1, 2, 3, 6, -1, 4, 1, 8, 2};
        int K = 10;

        // When and Then
        assertThrows(IllegalArgumentException.class, () -> {
            O1_AverageOfSubarrayOfSizeK.findAverageSlidingWindow(input, K);
        });
    }


    // The method throws an IllegalArgumentException if K is less than or equal to 0.
    @Test
    public void test_illegal_argument_exception() {
        // Given
        int[] input = new int[]{1, 2, 3, 6, -1, 4, 1, 8, 2};
        int K = -5;

        // When
        assertThrows(IllegalArgumentException.class, () -> {
            O1_AverageOfSubarrayOfSizeK.findAverageSlidingWindow(input, K);
        });

        // Then
        // IllegalArgumentException is thrown
    }
}