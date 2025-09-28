# Divide-and-Conquer Algorithms Assignment 1

## Overview
This project implements classic divide-and-conquer algorithms with safe recursion patterns and metrics tracking. The implemented algorithms are:

- **MergeSort** – stable sort with linear merge, reusable buffer, and small-n cutoff using Insertion Sort.
- **QuickSort** – robust version with randomized pivot and recursion on the smaller partition.
- **Deterministic Select (Median-of-Medians)** – O(n) selection algorithm, group by 5, pivot as median of medians, in-place partition, recurses only on the required side.
- **Closest Pair of Points** – not implemented in this submission.

The project tracks **comparisons** and **maximum recursion depth** using the `Metrics` class.

---

## Architecture Notes
- `Metrics` class: tracks the number of comparisons and the maximum recursion depth for each algorithm.
- Small arrays are handled by **Insertion Sort** to optimize performance.
- Recursive algorithms update `Metrics` during execution.
- The design ensures safe recursion and bounded stack usage, especially in QuickSort (depth ≲ 2*floor(log2 n) + O(1)).

---

## Algorithms

### MergeSort
- **Method:** Divide the array into halves, recursively sort, and merge using a reusable buffer.
- **Recurrence:** T(n) = 2T(n/2) + Θ(n)
- **Asymptotic Complexity:** Θ(n log n) (Master Case 2)

### QuickSort
- **Method:** Randomized pivot, recurse on the smaller partition, iterate on the larger partition.
- **Recurrence:** T(n) ≈ T(n/2) + Θ(n) for average case
- **Asymptotic Complexity:** Θ(n log n) average, O(n²) worst case (rare with random pivot)

### Deterministic Select (Median-of-Medians)
- **Method:** Partition array using median-of-medians as pivot, recurse only into the partition containing the k-th element.
- **Recurrence:** T(n) = T(n/5) + T(7n/10) + Θ(n)
- **Asymptotic Complexity:** Θ(n)

---

## Testing
- Correctness verified against `Arrays.sort()` for sorting and selection.
- Recursion depth and comparison counts measured via `Metrics`.
- Example test output:

