# Product of Array Except Self

This folder contains the implementation of finding the **Product of Array Except Self** in Java:  
- Prefix Product + Suffix Product method (optimized approach)

## Problem Statement
Given an integer array `nums`, return an array `answer` such that:

```answer[i] = product of all elements in nums except nums[i]```


### Constraints:
- You must **not use the division operator**.
- The solution must run in **O(n)** time.
- The product of any prefix or suffix is guaranteed to fit in a **32-bit integer**.

---

## Approach

We use the concept of **prefix and suffix products** to efficiently compute results:

1. **Prefix Pass:**  
   Build an array where `prefix[i]` contains the product of all elements before index `i`.  
   Example: for `[1, 2, 3, 4]`, prefix products become `[1, 1, 2, 6]`.

2. **Suffix Pass:**  
   Traverse from right to left while maintaining a running `suffixProduct`.  
   Multiply `prefix[i]` with `suffixProduct` to get the final result for index `i`.

3. **Space Optimization:**  
   Instead of using a separate prefix and suffix array, we store prefix results in the output array itself and update them in-place during the suffix pass.  
   This achieves **O(1) extra space** usage.

---

## Complexity Analysis

| Aspect           | Complexity |
|-----------------|-----------|
| **Time**        | **O(n)** (One prefix pass + One suffix pass) |
| **Space**       | **O(1)** extra space (excluding the output array) |

---

This approach efficiently handles edge cases such as arrays with zeros and negative numbers, without requiring any conditional checks or division logic.
