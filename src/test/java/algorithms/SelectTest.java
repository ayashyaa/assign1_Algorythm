package algorithms;

import org.junit.jupiter.api.Test;
import utils.Metrics;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SelectTest {

    @Test
    void testSelectRandomArray() {
        int[] array = {5, 2, 9, 1, 5, 0};
        int k = 2; // 3-й минимальный элемент
        Metrics metrics = new Metrics();

        int result = Select.select(array, k, metrics);

        int[] sortedCopy = array.clone();
        java.util.Arrays.sort(sortedCopy);

        assertEquals(sortedCopy[k], result);

        System.out.println("Random array - Comparisons: " + metrics.getComparisons());
        System.out.println("Random array - Max recursion depth: " + metrics.getMaxDepth());
    }

    @Test
    void testSelectSingleElement() {
        int[] array = {42};
        int k = 0;
        Metrics metrics = new Metrics();

        int result = Select.select(array, k, metrics);

        assertEquals(42, result);

        System.out.println("Single element - Comparisons: " + metrics.getComparisons());
        System.out.println("Single element - Max recursion depth: " + metrics.getMaxDepth());
    }

    @Test
    void testSelectSmallArray() {
        int[] array = {5, 2, 0, 1, 9, 4};
        int k = 0;
        Metrics metrics = new Metrics();

        int result = Select.select(array, k, metrics);

        int[] sortedCopy = array.clone();
        java.util.Arrays.sort(sortedCopy);

        assertEquals(sortedCopy[k], result);

        System.out.println("Small array - Comparisons: " + metrics.getComparisons());
        System.out.println("Small array - Max recursion depth: " + metrics.getMaxDepth());
    }

    @Test
    void testSelectEmptyArray() {
        int[] array = {};
        int k = 0;
        Metrics metrics = new Metrics();

        try {
            Select.select(array, k, metrics);
        } catch (IllegalArgumentException e) {
            System.out.println("Array is empty");
        }
    }
}
