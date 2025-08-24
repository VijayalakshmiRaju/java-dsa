# Minimum Element in a Sorted Rotated Array

This project demonstrates two approaches to find the **minimum element** in a **sorted rotated array** in Java.

---

## Problem Statement
A sorted array may be rotated at some pivot unknown beforehand.  
The task is to efficiently find the **minimum element** in such an array.

---

## Approaches Implemented

### 1. Linear Search
- Traverse the array element by element.
- Keep track of the smallest element encountered.
- Simple but less efficient for large arrays.

### 2. Binary Search
- Leverages the properties of rotated sorted arrays.
- Uses a divide-and-conquer approach:
  - If the current subarray is already sorted, the first element is the minimum.
  - Otherwise, decide which half to search based on comparisons.
- Much more efficient for large arrays.

---

## Time & Space Complexity

| Approach        | Time Complexity | Space Complexity |
|-----------------|-----------------|------------------|
| Linear Search   | O(n)            | O(1)             |
| Binary Search   | O(log n)        | O(1)             |

---

## How to Run
1. Compile the program using `javac`.
2. Run the program with `java`.
3. The program executes test cases and prints the results of both approaches.

---

## Key Takeaways
- Linear Search is straightforward but slower.
- Binary Search is optimal for rotated sorted arrays, running in logarithmic time.
- The choice of loop condition is important:
  - Use **`while (low < high)`** in the binary search method.
  - This ensures the loop terminates correctly without infinite repetition.
