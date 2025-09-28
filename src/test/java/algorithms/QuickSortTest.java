package algorithms;

import org.junit.jupiter.api.Test;
import utils.Metrics;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortTest {

    @Test
    void testQuickSortRandomArray() {
        int[] array = {5, 2, 9, 1, 5, 0};
        int[] copy = array.clone();

        Metrics metrics = new Metrics();
        QuickSort.sort(array, metrics); // 🔹 исправлено: используем QuickSort

        java.util.Arrays.sort(copy); // эталонная сортировка
        assertArrayEquals(copy, array);

        System.out.println("Random array - Comparisons: " + metrics.getComparisons());
        System.out.println("Random array - Max recursion depth: " + metrics.getMaxDepth());
    }

    @Test
    void testQuickSortSmallArray() {
        int[] array = {5, 2, 9, 1, 5, 0};
        int[] copy = array.clone();

        Metrics metrics = new Metrics();
        QuickSort.sort(array, metrics);

        java.util.Arrays.sort(copy);
        assertArrayEquals(copy, array);

        System.out.println("Small array - Comparisons: " + metrics.getComparisons());
        System.out.println("Small array - Max recursion depth: " + metrics.getMaxDepth());
    }

    @Test
    void testQuickSortEmptyArray() {
        int[] array = {};
        int[] copy = array.clone();

        Metrics metrics = new Metrics();
        QuickSort.sort(array, metrics);

        assertArrayEquals(copy, array);

        System.out.println("Empty array - Comparisons: " + metrics.getComparisons());
        System.out.println("Empty array - Max recursion depth: " + metrics.getMaxDepth());
    }

    @Test
    void testQuickSortSingleElement() {
        int[] array = {42};
        int[] copy = array.clone();

        Metrics metrics = new Metrics();
        QuickSort.sort(array, metrics);

        assertArrayEquals(copy, array);

        System.out.println("Single element - Comparisons: " + metrics.getComparisons());
        System.out.println("Single element - Max recursion depth: " + metrics.getMaxDepth());
    }
}
