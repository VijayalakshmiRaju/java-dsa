# One Odd Occurrence

## Problem Statement
Given an array of integers, **exactly one element occurs an odd number of times**, while all other elements occur an even number of times.  
The task is to find and return that element.  
If no such element exists, return `-1`.

---

## Approaches

### 1. Naive Method (Using Frequency Count)
We use a **double loop** to count the frequency of each element.

**Steps:**
1. For each element in the array, initialize a `count` variable to `0`.
2. Traverse the entire array again to count how many times the element appears.
3. If the count is **odd**, return that element immediately.
4. If no element has an odd count, return `-1`.

**Time Complexity:** O(n²)  
**Space Complexity:** O(1)

---

### 2. Optimized Method (Using XOR Operation)
We use the **bitwise XOR operator (^)** to efficiently find the element that occurs an odd number of times.

**Key Properties of XOR:**
1. `a ^ a = 0` → XOR of two identical numbers is 0.  
2. `a ^ 0 = a` → XOR of a number with 0 is the number itself.  
3. XOR is **commutative and associative**, meaning order doesn’t matter.

**Logic:**
- XOR all elements of the array together.
- Pairs of identical numbers cancel out to 0.
- The remaining number is the one that occurs an odd number of times.

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

## Example

**Input:**  
`arr = [1, 2, 3, 2, 3, 1, 3]`

**Step-by-step (Naive):**
| Element | Frequency | Odd/Even |
|----------|------------|----------|
| 1 | 2 | Even |
| 2 | 2 | Even |
| 3 | 3 | Odd |

**Step-by-step (XOR):**  
`1 ^ 2 ^ 3 ^ 2 ^ 3 ^ 1 ^ 3 = 3`

**Output:**  
`3`

---

## Edge Cases

| Case | Example | Expected Output | Explanation |
|------|----------|----------------|--------------|
| Single element | `[99]` | `99` | Single number occurs once (odd) |
| No odd element | `[2, 2, 4, 4]` | `-1` | All elements appear even times |
| Multiple duplicates | `[10, 10, 20, 30, 30, 20, 40]` | `40` | Only 40 appears once |
| Large identical array | `[5, 5, 5, 5, 5]` | `5` | Odd frequency count (5 times) |
| Negative numbers | `[-1, -1, -2, -2, -3]` | `-3` | Works with negatives too |
| Includes zero | `[0, 1, 0, 1, 0]` | `0` | Works even with 0 values |
| Empty array | `[]` | `-1` | No elements present |

---

## Complexity Comparison

| Approach | Time Complexity | Space Complexity | Explanation |
|-----------|-----------------|------------------|--------------|
| **Naive** | O(n²) | O(1) | Counts each element’s frequency using nested loops |
| **Optimized (XOR)** | O(n) | O(1) | Cancels out even occurrences using XOR |

---

## Sample Test Cases

```java
int[] arr1 = {1, 2, 3, 2, 3, 1, 3};       // Output → 3
int[] arr2 = {10, 10, 20, 20, 30, 30, 40}; // Output → 40
int[] arr3 = {2, 2, 4, 4, 6, 6};           // Output → -1 (Naive), 0 (XOR)
int[] arr4 = {99};                         // Output → 99
int[] arr5 = {-1, -1, -2, -2, -3};         // Output → -3
int[] arr6 = {0, 1, 0, 1, 0};              // Output → 0

## Breakdown
1. This is the naive approach to the "One Odd Occurrence" problem.
2. It checks every element against all others, making it easy to understand but not efficient.
3. This approach is great for learning and debugging, but for large datasets, consider using the XOR approach which solves it in O(n) time.
