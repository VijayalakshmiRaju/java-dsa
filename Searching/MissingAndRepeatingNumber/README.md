# Missing and Repeating Element

This Java program finds the **missing** and **repeating** numbers in an array
containing integers from `1` to `N`, where exactly one number is missing
and one number appears twice.

---

## Problem Statement
Given an array `arr[]` of size `N` containing numbers from `1` to `N`:
- One number is missing.
- One number occurs twice.

Find:
1. The **missing number**
2. The **repeating number**

---

## Approaches

### 1. Sorting Approach
1. **Sort** the array.
2. **Scan once** to detect:
   - **Repeating number:** If `arr[i] == arr[i+1]`
   - **Missing number:** If `arr[i+1] - arr[i] > 1`, then missing = `arr[i] + 1`
3. **Edge cases:**
   - If the first number is not `1` → missing = `1`
   - If no gap is found → missing = `N`

---

### 2. Sum & Product Approach (Mathematical)
1. Let `x` = missing number, `y` = repeating number.
2. Compute:
   - `diff = sum(arr) - expectedSum = y - x`
   - `ratio = product(arr) / expectedProduct = y / x`
3. Solve the two equations to find `x` and `y`.
4. Uses `BigInteger` and `BigDecimal` to handle large numbers safely.

---

## Complexity Analysis

| Approach               | Time Complexity | Space Complexity | Notes |
|------------------------|----------------|-----------------|-------|
| Sorting                | O(N log N)     | O(1)            | Simple, safe for large N |
| Sum & Product          | O(N)           | O(N) (BigInteger/BigDecimal) | Elegant, may overflow without BigInteger |

---
