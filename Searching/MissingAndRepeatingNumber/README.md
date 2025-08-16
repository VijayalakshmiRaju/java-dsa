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

### 3. Hashing Approach (Array)
1. Create a **hash array** of size `N+1`.
2. Traverse the input array and increment count in hash array.
3. Traverse hash array:
   - Count = 0 -> missing number
   - Count = 2 -> repeating number

---

### 4. HashMap Approach
1. Create a `HashMap<Integer, Integer>` to store frequency of numbers.
2. Traverse the array and increment the count in the map.
3. Traverse numbers from `1` to `N`:
   - Count = 0 -> missing number
   - Count = 2 -> repeating number
4. Works even if the array is not strictly `1..N` or has arbitrary numbers.

---

## Complexity Analysis

| Approach               | Time Complexity | Space Complexity | Notes |
|------------------------|----------------|-----------------|-------|
| Sorting                | O(N log N)     | O(1)            | Simple, in-place |
| Sum & Product          | O(N)           | O(N) (BigInteger/BigDecimal) | Elegant, handles large N with BigInteger |
| Hashing (Array)        | O(N)           | O(N)            | Easy linear-time solution, fixed range 1..N |
| HashMap                | O(N)           | O(N)            | Generalized, works for arbitrary numbers |


---
