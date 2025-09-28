package utils;

import java.util.Random;

public class Utils {
    private static final Random rand = new Random();

    public static void swap(int[] arr, int i, int j, Metrics m) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        if(m != null) m.swaps++;
    }

    public static void shuffle(int[] arr) {
        for(int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
