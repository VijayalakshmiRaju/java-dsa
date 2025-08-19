# Smallest Positive Missing Number

Given an integer array `arr[]`, this program finds the **smallest positive number missing** from the array.  
The array may contain **negative numbers, zeros, and duplicates**. Positive numbers start from `1`.

---

# Problem Statement

Given:
- An integer array `arr[]` of size `n`
- Array elements can include negative numbers, zeros, and duplicates

Find:
- The smallest positive number missing from the array.

---

## Algorithm Logic

We implement two approaches:

### **Approach 1: HashSet (Naive)**
1. Store all positive numbers in a HashSet.
2. Iterate from `1` to `n+1` to find the first missing number.

---

### **Approach 2: Cyclic Sort / Index Mapping (Optimized)**
1. Iterate through the array, placing each number `x` at index `x-1` if it lies within `[1, n]`.
2. After rearrangement, the first index `i` where `arr[i] != i+1` gives the missing number.
3. If all numbers `1...n` are present, the answer is `n+1`.

---

## Time and Space Complexity

| Approach        | Time Complexity | Space Complexity |
|-----------------|-----------------|------------------|
| HashSet Method  | O(n)            | O(n)             |
| Cyclic Sort     | O(n)            | O(1)             |

---

## Files

- `SmallestPositiveMissingNumber.java`: Contains Java implementations using HashSet and Cyclic Sort.
- `README.md`: This file - explanation, logic, and complexity.

---
