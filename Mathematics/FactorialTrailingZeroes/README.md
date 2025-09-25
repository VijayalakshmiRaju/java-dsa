# Factorial Trailing Zeroes

This project explains and implements the logic to find the number of **trailing zeroes** in the factorial of a given number `n!`.

---

## Problem Statement

Given an integer `n`, determine the number of trailing zeroes in `n!`.  

Trailing zeroes are created by factors of **10**, which come from multiplying **2 × 5**.  
Since factorials have more factors of 2 than 5, the count of trailing zeroes depends only on the number of **factors of 5** present in `n!`.

---

## Approach

1. Count how many multiples of `5` are less than or equal to `n`.  
2. Count how many multiples of `25` are less than or equal to `n` (since each contributes an extra factor of 5).  
3. Continue for higher powers like `125`, `625`, etc., until `n / 5^k < 1`.  

The formula is:  

\[
TrailingZeroes(n) = \left\lfloor \frac{n}{5} \right\rfloor + \left\lfloor \frac{n}{25} \right\rfloor + \left\lfloor \frac{n}{125} \right\rfloor + \cdots
\]

---

## Complexity Analysis

| Aspect            | Complexity   |
|-------------------|--------------|
| Time Complexity   | **O(log₅ n)** |
| Space Complexity  | **O(1)**      |

---

## Test Cases Covered

- **Edge Cases:** `0!`, `1!` → No trailing zeroes  
- **Small Inputs:** `5!`, `10!`  
- **Medium Inputs:** `25!`, `50!`, `100!`, `125!`  
- **Large Input:** `1000!`  

---

## Key Insights

- Trailing zeroes depend **only** on the count of factor `5` in `n!`.  
- Powers of `5` contribute extra factors (e.g., 25 contributes two 5s, 125 contributes three 5s).  
- Efficient to compute using repeated division instead of calculating factorial explicitly.  
