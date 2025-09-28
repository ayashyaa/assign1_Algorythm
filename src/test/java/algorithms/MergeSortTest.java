package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.Random;

public class MergeSortTest {

    private final Random rand = new Random();

    @Test
    public void testMergeSortRandomArray() {
        int[] arr = rand.ints(1000, 0, 10000).toArray();
        int[] expected = arr.clone();
        java.util.Arrays.sort(expected);

        MergeSort sorter = new MergeSort();
        sorter.mergeSort(arr);


        assertArrayEquals(expected, arr);
        System.out.println("Random array - Comparisons: " + sorter.comparisons);
        System.out.println("Random array - Max recursion depth: " + sorter.maxDepth);
    }

    @Test
    public void testMergeSortSmallArray() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] expected = {1, 2, 5, 5, 6, 9};

        MergeSort sorter = new MergeSort();
        sorter.mergeSort(arr);

        assertArrayEquals(expected, arr);
        System.out.println("Small array - Comparisons: " + sorter.comparisons);
        System.out.println("Small array - Max recursion depth: " + sorter.maxDepth);
    }

    @Test
    public void testMergeSortEmptyArray() {
        int[] arr = {};
        int[] expected = {};

        MergeSort sorter = new MergeSort();
        sorter.mergeSort(arr);

        assertArrayEquals(expected, arr);
        System.out.println("Empty array - Comparisons: " + sorter.comparisons);
        System.out.println("Empty array - Max recursion depth: " + sorter.maxDepth);
    }

    @Test
    public void testMergeSortSingleElement() {
        int[] arr = {42};
        int[] expected = {42};

        MergeSort sorter = new MergeSort();
        sorter.mergeSort(arr);

        assertArrayEquals(expected, arr);
        System.out.println("Single element - Comparisons: " + sorter.comparisons);
        System.out.println("Single element - Max recursion depth: " + sorter.maxDepth);
    }
}
