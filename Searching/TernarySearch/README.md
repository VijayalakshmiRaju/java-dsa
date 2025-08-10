# Ternary Search

This folder contains the implementation of **Ternary Search** in Java using:

- Iterative Method
- Recursive Method

Ternary Search is a divide-and-conquer algorithm used to find the position of a target element in a **sorted array**. Unlike Binary Search, it splits the array into **three parts** instead of two.

---

## Algorithm Logic

1. Divide the array into 3 equal parts using two midpoints:
   - `mid1 = low + (high - low) / 3`
   - `mid2 = high - (high - low) / 3`

2. Compare the target with both mid elements:
   - If target equals `arr[mid1]` -> return `mid1`
   - If target equals `arr[mid2]` -> return `mid2`

3. Decide which segment to recurse into:
   - If target < `arr[mid1]` -> search in the left segment
   - If target > `arr[mid2]` -> search in the right segment
   - Else -> search in the middle segment

---

## Time and Space Complexity

| Approach     | Time Complexity | Auxiliary Space | Notes                                |
|--------------|------------------|------------------|--------------------------------------|
| Iterative    | O(log₃ n)        | O(1)             | Loop-based, no recursion             |
| Recursive    | O(log₃ n)        | O(log₃ n)        | Due to recursive call stack          |

---

## Files

- `TernarySearch.java`: Contains both iterative and recursive Java implementations
- `README.md`: This file - explanation, logic, and complexity

---