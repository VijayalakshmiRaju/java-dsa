# Prime Numbers Up To N

## Problem Statement
Write a Java program to print all **prime numbers less than or equal to a given number N**.  
A **prime number** is a number greater than 1 that has no divisors other than 1 and itself.

---

## Approaches Implemented

### 1. Naive Approach (`isPrime()` + `printPrimesUpToN()`)
- For every number from 2 to N:
  - Check if it is divisible by any number between 2 and √N.
  - If not divisible, print it as a prime number.
- Works well for small values of N.

### 2. Optimized Approach — **Sieve of Eratosthenes** (`printPrimesUsingSieve()`)
- Create a boolean array `prime[]` where each index represents whether the number is prime.
- Initially mark all numbers ≥ 2 as `true`.
- Starting from 2, mark all multiples of each prime as `false`.
- Print all indices still marked as `true` (i.e., prime numbers).
- Much faster for large values of N.

---

## Algorithm Steps

### Naive Approach
1. Loop `i` from 2 to N.
2. For each `i`, check divisibility from 2 to √i.
3. If divisible → not prime.
4. Else, print `i`.

### Sieve of Eratosthenes
1. Create a boolean array `prime[n + 1]`, initialize all elements as `true`.
2. Start from `val = 2` up to √N.
3. For each `val`, if it's marked `true`, mark all its multiples as `false`.
4. After the loop, all indices marked `true` represent prime numbers.

---

## Complexity Analysis

| Approach | Time Complexity | Space Complexity | Suitable For |
|-----------|----------------|------------------|---------------|
| Naive | O(N√N) | O(1) | Small values of N |
| Sieve of Eratosthenes | O(N log log N) | O(N) | Large values of N |

---

## Test Cases

| Test Case | Input (N) | Expected Output |
|------------|------------|----------------|
| 1 | 1 | No prime numbers found. |
| 2 | 2 | 2 |
| 5 | 5 | 2 3 5 |
| 10 | 10 | 2 3 5 7 |
| 20 | 20 | 2 3 5 7 11 13 17 19 |
| 50 | 50 | 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 |
| 100 | 100 | 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 |
| -10 | -10 | No prime numbers found. |
| 0 | 0 | No prime numbers found. |

---

## Sample Output

=== PRIME NUMBERS UP TO N ===

----- TEST CASE: n = -10 -----
Prime numbers <= -10 (Naive Approach):
No prime numbers found.

Prime numbers <= -10 (Sieve of Eratosthenes):
No prime numbers found.

----- TEST CASE: n = 10 -----
Prime numbers <= 10 (Naive Approach):
2 3 5 7

Prime numbers <= 10 (Sieve of Eratosthenes):
2 3 5 7

----- TEST CASE: n = 100 -----
Prime numbers <= 100 (Naive Approach):
2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97

Prime numbers <= 100 (Sieve of Eratosthenes):
2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97

---
