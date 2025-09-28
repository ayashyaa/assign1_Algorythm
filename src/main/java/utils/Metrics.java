package utils;

public class Metrics {
    private int comparisons = 0;
    private int maxDepth = 0;

    public void incrementComparisons() {
        comparisons++;
    }

    public int getComparisons() {
        return comparisons;
    }

    // Обновление максимальной глубины рекурсии
    public void updateMaxDepth(int depth) {
        if (depth > maxDepth) {
            maxDepth = depth;
        }
    }

    // Метод для получения максимальной глубины
    public int getMaxDepth() {
        return maxDepth;
    }
}
