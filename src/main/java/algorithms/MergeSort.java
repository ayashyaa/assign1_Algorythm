package algorithms;

public class MergeSort {

    public long comparisons = 0;  
    public int maxDepth = 0;      

    public void mergeSort(int[] array) {
        if (array.length <= 1) return;
        int[] buffer = new int[array.length];
        mergeSortHelper(array, buffer, 0, array.length - 1, 1);
    }

    private void mergeSortHelper(int[] array, int[] buffer, int left, int right, int depth) {
        if (left >= right) return;
        if (depth > maxDepth) maxDepth = depth;

        int mid = left + (right - left) / 2;
        mergeSortHelper(array, buffer, left, mid, depth + 1);
        mergeSortHelper(array, buffer, mid + 1, right, depth + 1);
        merge(array, buffer, left, mid, right);
    }

    private void merge(int[] array, int[] buffer, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            comparisons++;  
            if (array[i] <= array[j]) buffer[k++] = array[i++];
            else buffer[k++] = array[j++];
        }
        while (i <= mid) buffer[k++] = array[i++];
        while (j <= right) buffer[k++] = array[j++];
        for (int l = left; l <= right; l++) array[l] = buffer[l];
    }
}
