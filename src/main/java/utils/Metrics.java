package utils;

public class Metrics {
    public long comparisons = 0;
    public long swaps = 0;
    public int recursiveDepth = 0;
    public int maxDepth = 0;

    public void enterRecursion() {
        recursiveDepth++;
        if(recursiveDepth > maxDepth) maxDepth = recursiveDepth;
    }

    public void exitRecursion() {
        recursiveDepth--;
    }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        recursiveDepth = 0;
        maxDepth = 0;
    }
}
