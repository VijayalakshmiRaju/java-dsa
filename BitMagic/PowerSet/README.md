# Power Set Using Bitwise Operators

## Problem Statement
Given an array of **distinct integers**, generate all possible **subsets (power set)** of that array.  
The solution should use **bitwise operations** to generate subsets efficiently.

---

## Approach

1. Let the size of the array be `n`.  
2. The total number of subsets is `2^n`.  
3. Each subset can be represented by a **binary number** of `n` bits:  
   - `1` at position `i` → include the corresponding element in the subset.  
   - `0` at position `i` → exclude the corresponding element.  
4. Loop through all numbers from `0` to `(2^n - 1)` and construct subsets based on the **set bits**.

---

## Complexity Analysis

| Operation                               | Time Complexity | Space Complexity | Explanation |
|-----------------------------------------|----------------|-----------------|-------------|
| Loop through all subset representations  | O(2^n)         | O(1)            | Loop from 0 to 2^n - 1 |
| Loop to check each bit per subset       | O(n)           | O(n)            | Checking all n bits per subset |
| **Total**                               | O(n * 2^n)     | O(n)            | n iterations per 2^n subsets |
| Storing all subsets (if required)      | O(n * 2^n)     | O(n * 2^n)      | Each subset can have up to n elements |

---

## Edge Cases

1. **Empty array** → should return only the empty subset.  
2. **Single element array** → returns the empty subset and the element itself.  
3. **Array with negative numbers** → handled normally like positive numbers.  
4. **Larger arrays** → generates `2^n` subsets correctly.  

---

## Summary
- Uses **bitwise operations** to generate subsets efficiently.  
- Scalable approach for any array size up to reasonable `n` (~20).  
- Avoids recursion and nested loops for subset generation.  
