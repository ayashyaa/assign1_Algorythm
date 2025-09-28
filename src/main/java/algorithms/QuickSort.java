package algorithms;

import utils.Metrics;
import utils.Utils;

public class QuickSort {

    // Сортировка массива с использованием QuickSort
    public static void sort(int[] array, Metrics metrics) {
        quickSort(array, 0, array.length - 1, 0, metrics);
    }

    private static void quickSort(int[] array, int left, int right, int depth, Metrics metrics) {
        if (left >= right) return;

        metrics.updateMaxDepth(depth);

        // Выбираем случайный pivot
        int pivotIndex = left + Utils.random.nextInt(right - left + 1);
        int pivot = array[pivotIndex];
        Utils.swap(array, pivotIndex, right); // перемещаем pivot в конец

        int i = left;
        int j = right - 1;

        while (i <= j) {
            while (i <= j && Utils.compare(array[i], pivot, metrics) < 0) i++;
            while (i <= j && Utils.compare(array[j], pivot, metrics) > 0) j--;
            if (i <= j) {
                Utils.swap(array, i, j);
                i++;
                j--;
            }
        }

        Utils.swap(array, i, right); // ставим pivot на место

        // Рекурсия: сначала на меньшую часть
        if (i - left < right - i) {
            quickSort(array, left, i - 1, depth + 1, metrics);
            quickSort(array, i + 1, right, depth + 1, metrics);
        } else {
            quickSort(array, i + 1, right, depth + 1, metrics);
            quickSort(array, left, i - 1, depth + 1, metrics);
        }
    }
}
