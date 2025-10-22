# Divisors of a Number (Naive Approach)

## Problem Statement
Given an integer `number`, print all its divisors.  
A **divisor** of a number is any integer that divides it completely (without leaving a remainder).

### Example
Input: 10
Output: 1 2 5 10

---

## Examples

| Input | Output | Explanation |
|--------|---------|-------------|
| `10` | `1 2 5 10` | 10 is divisible by 1, 2, 5, and 10 |
| `13` | `1 13` | 13 is a prime number (divisible only by 1 and itself) |
| `16` | `1 2 4 8 16` | 16 is a perfect square |
| `1` | `1` | 1 is only divisible by itself |
| `-12` | No divisors exist for -12 | Negative numbers are not considered |
| `0` | No divisors exist for 0 | Division by zero is undefined |

---

## Approach 1: Naive Method

### Logic
1. Iterate from `1` to `number`.
2. For each integer `i`, check if `number % i == 0`.
3. If true, print `i` (it is a divisor).

### Pseudocode
for i = 1 to number:
if number % i == 0:
print i


### Edge Cases
- `number <= 0`: Print a message indicating invalid input.
- `number = 1`: Only one divisor exists (1).

---

## Time and Space Complexity

| Complexity | Description |
|-------------|--------------|
| Time Complexity | O(n) — Checks all numbers from 1 to n |
| Space Complexity | O(1) — Uses constant space |

---

## Sample Output
=== Test Case 1: Positive Number (Normal Case) ===
Divisors of 10: 1 2 5 10

=== Test Case 2: Prime Number ===
Divisors of 13: 1 13

=== Test Case 3: Perfect Square ===
Divisors of 16: 1 2 4 8 16

=== Test Case 4: Smallest Positive Number (Edge Case) ===
Divisors of 1: 1

=== Test Case 5: Negative Number (Invalid Input) ===
No divisors exist for -12

=== Test Case 6: Zero (Edge Case) ===
No divisors exist for 0

---
