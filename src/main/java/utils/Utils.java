package utils;

import java.util.Random;

public class Utils {
    public static Random random = new Random();

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int compare(int a, int b, Metrics metrics) {
        metrics.incrementComparisons();
        return Integer.compare(a, b);
    }
}
