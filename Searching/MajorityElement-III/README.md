# Elements Occurring More Than n/k Times

This project contains two implementations in Java to find the **count of elements** in an array that appear **more than n/k times**, where `n` is the length of the array.

- **HashMap Method** (Simple frequency count)
- **Boyer–Moore Generalized Voting Algorithm** (Optimized for space)

---

## Problem Statement

Given:
- An array `arr[]` of size `n`
- An integer `k`

Find the **number of distinct elements** in `arr` that appear more than `n/k` times.

---

## Examples

**Input:**  
`arr = [3, 1, 2, 2, 1, 2, 3, 3], k = 4`  
**Output:**  
`2`  
Explanation: `2` and `3` appear more than `n/k = 2` times.

---

**Input:**  
`arr = [2, 3, 3, 2], k = 3`  
**Output:**  
`2`  
Explanation: Both `2` and `3` appear more than `n/k = 1` times.

---

**Input:**  
`arr = [1, 4, 7, 7], k = 2`  
**Output:**  
`0`  
Explanation: No element appears more than `n/k = 2` times.

---

## Algorithm Logic

### 1. HashMap Method
1. Traverse the array and store frequencies of elements in a HashMap.  
2. Compute threshold `n/k`.  
3. Count how many elements have frequency greater than `n/k`.  
4. Return the count.

---

### 2. Boyer–Moore Generalized Voting Algorithm
1. At most `(k - 1)` elements can occur more than `n/k` times.  
2. Maintain a candidate map of size at most `k-1`.  
3. For each element in the array:  
   - If it’s already a candidate → increment count.  
   - Else if candidate pool has space → add it with count 1.  
   - Else → decrement count of all candidates, and remove those with zero.  
4. After processing, verify candidates by counting their actual frequency.  
5. Return how many exceed `n/k`.

---

## Complexity Analysis

| Approach       | Time Complexity | Space Complexity | Notes |
|----------------|----------------|-----------------|-------|
| **HashMap**    | O(n)           | O(n)            | Simple, direct frequency counting. |
| **Boyer–Moore**| O(n)           | O(k)            | Space-optimized, useful when k is small. |

---

## Files

- `MajorityElementGeneralized.java` → Contains both methods and driver code.
