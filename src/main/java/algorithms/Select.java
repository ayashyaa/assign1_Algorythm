package algorithms;

import utils.Metrics;
import utils.Utils;

import java.util.Random;

public class Select {

    private static final Random random = new Random();

    // Основной метод для поиска k-го элемента
    public static int select(int[] a, int left, int right, int k, Metrics metrics) {
        metrics.updateMaxDepth(1); // Начальная глубина

        while (true) {
            if (right - left + 1 <= 5) {
                Utils.insertionSort(a, left, right, metrics);
                return a[left + k];
            }

            // Разбиваем на группы по 5 и находим медианы
            int numMedians = 0;
            for (int i = left; i <= right; i += 5) {
                int subRight = Math.min(i + 4, right);
                Utils.insertionSort(a, i, subRight, metrics);
                int medianIndex = i + (subRight - i) / 2;
                Utils.swap(a, left + numMedians, medianIndex);
                numMedians++;
            }

            // Рекурсивно выбираем медиану медиан
            int pivot = select(a, left, left + numMedians - 1, numMedians / 2, metrics);

            // Находим индекс pivot
            int pivotIndex = partition(a, left, right, pivot, metrics);
            int length = pivotIndex - left;

            if (k == length) return a[pivotIndex];
            else if (k < length) right = pivotIndex - 1;
            else {
                k = k - length - 1;
                left = pivotIndex + 1;
            }
        }
    }

    // Классическая partition
    private static int partition(int[] a, int left, int right, int pivot, Metrics metrics) {
        int pivotIndex = left;
        for (int i = left; i <= right; i++) {
            if (Utils.compare(a[i], pivot, metrics) == 0) {
                pivotIndex = i;
                break;
            }
        }
        Utils.swap(a, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (Utils.compare(a[i], pivot, metrics) < 0) {
                Utils.swap(a, storeIndex, i);
                storeIndex++;
            }
        }
        Utils.swap(a, storeIndex, right);
        return storeIndex;
    }
}
