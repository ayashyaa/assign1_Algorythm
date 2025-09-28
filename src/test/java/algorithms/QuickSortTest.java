package algorithms;

import org.junit.jupiter.api.Test;
import utils.Metrics;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testQuickSortRandomArray() {
        int[] array = new Random().ints(1000, 0, 10000).toArray();
        int[] copy = array.clone();

        Metrics metrics = new Metrics();
        QuickSort.sort(array, metrics);

        Arrays.sort(copy);
        assertArrayEquals(copy, array);

        System.out.println("Random array - Comparisons: " + metrics.getComparisons());
        System.out.println("Random array - Max recursion depth: " + metrics.getMaxDepth());
    }

    @Test
    public void testQuickSortSmallArray() {
        int[] array = {5, 2, 9, 1, 5, 6};
        int[] copy = array.clone();

        Metrics metrics = new Metrics();
        QuickSort.sort(array, metrics);

        Arrays.sort(copy);
        assertArrayEquals(copy, array);

        System.out.println("Small array - Comparisons: " + metrics.getComparisons());
        System.out.println("Small array - Max recursion depth: " + metrics.getMaxDepth());
    }

    @Test
    public void testQuickSortEmptyArray() {
        int[] array = {};
        Metrics metrics = new Metrics();
        QuickSort.sort(array, metrics);

        System.out.println("Empty array - Comparisons: " + metrics.getComparisons());
        System.out.println("Empty array - Max recursion depth: " + metrics.getMaxDepth());
    }

    @Test
    public void testQuickSortSingleElement() {
        int[] array = {42};
        Metrics metrics = new Metrics();
        QuickSort.sort(array, metrics);

        System.out.println("Single element - Comparisons: " + metrics.getComparisons());
        System.out.println("Single element - Max recursion depth: " + metrics.getMaxDepth());
    }
}
