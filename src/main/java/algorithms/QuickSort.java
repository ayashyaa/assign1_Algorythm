package algorithms;

import utils.Metrics;
import utils.Utils;

public class QuickSort {

    public static void sort(int[] array, Metrics metrics) {
        quickSort(array, 0, array.length - 1, metrics, 0);
    }

    private static void quickSort(int[] array, int left, int right, Metrics metrics, int depth) {
        if (left >= right) return;

        metrics.updateMaxDepth(depth);

        // Используем insertion sort для маленьких массивов
        if (right - left <= 10) {
            Utils.insertionSort(array, left, right, metrics);
            return;
        }

        int pivotIndex = partition(array, left, right, metrics);
        quickSort(array, left, pivotIndex - 1, metrics, depth + 1);
        quickSort(array, pivotIndex + 1, right, metrics, depth + 1);
    }

    private static int partition(int[] array, int left, int right, Metrics metrics) {
        int pivot = array[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            metrics.incrementComparisons();
            if (array[j] <= pivot) {
                i++;
                Utils.swap(array, i, j);
            }
        }
        Utils.swap(array, i + 1, right);
        return i + 1;
    }
}
