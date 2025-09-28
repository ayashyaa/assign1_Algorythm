package algorithms;

import org.junit.jupiter.api.Test;
import utils.Metrics;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectTest {

    @Test
    public void testSelectRandomArray() {
        int[] arr = new int[100];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) arr[i] = rand.nextInt(1000);

        Metrics metrics = new Metrics();
        int k = 50;
        int result = Select.select(Arrays.copyOf(arr, arr.length), k, metrics);

        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        System.out.println("Random array - Comparisons: " + metrics.getComparisons());
        System.out.println("Random array - Max recursion depth: " + metrics.getMaxDepth());
        assertEquals(sorted[k], result);
    }

    @Test
    public void testSelectSmallArray() {
        int[] arr = {3, 1, 4, 2, 5};
        Metrics metrics = new Metrics();
        int result = Select.select(Arrays.copyOf(arr, arr.length), 2, metrics);
        assertEquals(3, result);
        System.out.println("Small array - Comparisons: " + metrics.getComparisons());
        System.out.println("Small array - Max recursion depth: " + metrics.getMaxDepth());
    }

    @Test
    public void testSelectSingleElement() {
        int[] arr = {42};
        Metrics metrics = new Metrics();
        int result = Select.select(Arrays.copyOf(arr, arr.length), 0, metrics);
        assertEquals(42, result);
        System.out.println("Single element - Comparisons: " + metrics.getComparisons());
        System.out.println("Single element - Max recursion depth: " + metrics.getMaxDepth());
    }
}
