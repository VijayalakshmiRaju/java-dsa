# Prime Numbers Up To N

## Problem Statement
Write a Java program to print all **prime numbers less than or equal to a given number N**.  
A **prime number** is a number greater than 1 that has no divisors other than 1 and itself.

---

## Approach

### 1. Prime Check (`isPrime()`)
- A number `n` is prime if it is not divisible by any integer from `2` to `√n`.
- Edge cases:
  - If `n <= 1` → Not prime  
  - If `n == 2 or 3` → Prime

### 2. Range Iteration (`printPrimesUpToN()`)
- Loop through all numbers from `2` to `N`.
- Print each number that passes the `isPrime()` check.

---

## Algorithm Steps
1. Input an integer `N`.
2. For each number `i` in range `2` to `N`:
   - Check if `i` is prime using the `isPrime()` function.
   - If yes, print it.
3. Handle edge cases where `N <= 1` (no primes exist).

---

## Complexity Analysis

| Operation | Time Complexity | Explanation |
|------------|-----------------|-------------|
| Prime check (per number) | O(√N) | Check divisibility up to √N |
| Print primes up to N | O(N√N) | For each number, call `isPrime()` |
| Space Complexity | O(1) | No extra space used |

---

## Test Cases

| Input (N) | Expected Output |
|------------|----------------|
| 1 | No prime numbers found. |
| 2 | 2 |
| 10 | 2 3 5 7 |
| 20 | 2 3 5 7 11 13 17 19 |
| 50 | 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 |
| -10 | No prime numbers found. |
| 0 | No prime numbers found. |

---

## Sample Output

=== Prime Numbers Up To N ===

Prime numbers less than or equal to 1:
No prime numbers found.

Prime numbers less than or equal to 2:
2

Prime numbers less than or equal to 10:
2 3 5 7

Prime numbers less than or equal to 20:
2 3 5 7 11 13 17 19

Prime numbers less than or equal to 50:
2 3 5 7 11 13 17 19 23 29 31 37 41 43 47

Prime numbers less than or equal to -10:
No prime numbers found.

Prime numbers less than or equal to 0:
No prime numbers found.

---
