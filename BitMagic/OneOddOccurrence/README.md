# One Odd Occurrence

## Problem Statement
Given an array of integers, **exactly one element occurs an odd number of times**, while all other elements occur an even number of times.  
The task is to find and return that element.  
If no such element exists, return `-1`.

---

## Approach — Naive Method

We use a **double loop** to count the frequency of each element:

1. For each element in the array, initialize a `count` variable to 0.  
2. Traverse the entire array again and count how many times the element appears.  
3. If the count is **odd**, return that element immediately.  
4. If no element has an odd count, return `-1`.

---

## Example

**Input:**  
`arr = [1, 2, 3, 2, 3, 1, 3]`

**Step-by-step:**
| Element | Frequency | Odd/Even |
|----------|------------|----------|
| 1 | 2 | Even |
| 2 | 2 | Even |
| 3 | 3 | Odd |

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

---

## Complexity Analysis

| Complexity Type | Description | Value |
|------------------|--------------|--------|
| **Time Complexity** | Two nested loops — for each element, we count its frequency | O(n²) |
| **Space Complexity** | No extra space used besides counters | O(1) |

---

## Sample Test Cases

```java
int[] arr1 = {1, 2, 3, 2, 3, 1, 3};      // Output → 3
int[] arr2 = {10, 10, 20, 20, 30, 30, 40}; // Output → 40
int[] arr3 = {2, 2, 4, 4, 6, 6};          // Output → -1
int[] arr4 = {99};                        // Output → 99
```

## Breakdown
1. This is the naive approach to the "One Odd Occurrence" problem.
2. It checks every element against all others, making it easy to understand but not efficient.
3. This approach is great for learning and debugging, but for large datasets, consider using the XOR approach which solves it in O(n) time.
