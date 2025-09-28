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

    public void updateMaxDepth(int depth) {
        if (depth > maxDepth) maxDepth = depth;
    }

    public int getMaxDepth() {
        return maxDepth;
    }
}
