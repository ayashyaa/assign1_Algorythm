package algorithms;

import utils.Metrics;

public class Select {

    public static int select(int[] array, int k, Metrics metrics) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        if (k < 0 || k >= array.length) {
            throw new IllegalArgumentException("k is out of bounds");
        }
        return quickSelect(array, 0, array.length - 1, k, metrics, 1); // передаем текущую глубину рекурсии
    }

    private static int quickSelect(int[] array, int left, int right, int k, Metrics metrics, int depth) {
        metrics.updateMaxDepth(depth); // передаем текущую глубину рекурсии

        if (left == right) return array[left];

        int pivotIndex = partition(array, left, right, metrics);

        if (k == pivotIndex) return array[k];
        else if (k < pivotIndex) return quickSelect(array, left, pivotIndex - 1, k, metrics, depth + 1);
        else return quickSelect(array, pivotIndex + 1, right, k, metrics, depth + 1);
    }

    private static int partition(int[] array, int left, int right, Metrics metrics) {
        int pivot = array[right];
        int i = left;
        for (int j = left; j < right; j++) {
            metrics.incrementComparisons();
            if (array[j] <= pivot) {
                utils.Utils.swap(array, i, j);
                i++;
            }
        }
        utils.Utils.swap(array, i, right);
        return i;
    }
}
