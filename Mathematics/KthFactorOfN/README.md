# Kth Factor of N

## Problem Statement

Given two positive integers `n` and `k`, a factor of `n` is an integer `i` such that `n % i == 0`.  

The task is to find the **k-th factor** of `n` in ascending order. If `n` has fewer than `k` factors, return `-1`.

### Examples

1. **Input:** `n = 12, k = 3`  
   **Output:** `3`  
   **Explanation:** Factors of 12 are `[1, 2, 3, 4, 6, 12]`. The 3rd factor is 3.

2. **Input:** `n = 7, k = 2`  
   **Output:** `7`  
   **Explanation:** Factors of 7 are `[1, 7]`. The 2nd factor is 7.

3. **Input:** `n = 4, k = 4`  
   **Output:** `-1`  
   **Explanation:** Factors of 4 are `[1, 2, 4]`. There are only 3 factors, so return -1.

## Constraints

- `1 <= k <= n <= 1000`

## Approach

### Brute Force

1. Iterate from 1 to `n`.  
2. For each number, check if it divides `n`.  
3. Decrement `k` for every factor found.  
4. If `k` becomes 0, return the current number as the k-th factor.  
5. If the loop ends without finding k factors, return `-1`.

### Optimized Approach

1. Loop from 1 to √n to find **small factors**.  
2. For each small factor `i`, the paired factor is `n / i`.  
   - If `i != n / i` (to avoid duplicates for perfect squares), store `n / i` in a list of **large factors**.  
3. If k-th factor is not found among small factors, find it among large factors using the descending order of the large factor list.  
4. If k is still not satisfied, return `-1`.

---

## Time and Space Complexity

| Approach          | Time Complexity | Space Complexity | Notes                                                                 |
|------------------|----------------|-----------------|-----------------------------------------------------------------------|
| Brute Force       | O(n)           | O(1)            | Iterates through all numbers from 1 to n                               |
| Optimized (√n)    | O(√n)          | O(√n)           | Uses factor pairs; only loops up to √n and stores paired larger factors |

---

## Expected Output

==== Brute-force Approach ====
Input: n = 12, k = 3 -> Output: 3
Input: n = 7, k = 2 -> Output: 7
Input: n = 4, k = 4 -> Output: -1
Input: n = 1, k = 1 -> Output: 1
Input: n = 1, k = 2 -> Output: -1
Input: n = 1000, k = 1 -> Output: 1
Input: n = 1000, k = 16 -> Output: 1000
Input: n = 36, k = 9 -> Output: 36
Input: n = 997, k = 1 -> Output: 1
Input: n = 997, k = 2 -> Output: 997

==== Optimized Approach ====
Input: n = 12, k = 3 -> Output: 3
Input: n = 7, k = 2 -> Output: 7
Input: n = 4, k = 4 -> Output: -1
Input: n = 1, k = 1 -> Output: 1
Input: n = 1, k = 2 -> Output: -1
Input: n = 1000, k = 1 -> Output: 1
Input: n = 1000, k = 16 -> Output: 1000
Input: n = 36, k = 9 -> Output: 36
Input: n = 997, k = 1 -> Output: 1
Input: n = 997, k = 2 -> Output: 997

---

This README now includes:  

- Problem description  
- Constraints  
- Approach explanations  
- Time and space complexity in **table format**  
- Expected outputs for both approaches  

---
