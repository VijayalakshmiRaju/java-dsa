# Divisors of a Number (Naive, Optimized, and List-Based Approaches)

## Problem Statement
Given an integer `number`, print all its **divisors**.  
A **divisor** of a number is any integer that divides it completely (without leaving a remainder).

### Example
Input: 10
Output: 1 2 5 10

---

## Examples

| Input | Output | Explanation |
|--------|---------|-------------|
| `10` | `1 2 5 10` | 10 is divisible by 1, 2, 5, and 10 |
| `13` | `1 13` | 13 is a prime number (only divisible by 1 and itself) |
| `16` | `1 2 4 8 16` | 16 is a perfect square |
| `1` | `1` | 1 is only divisible by itself |
| `-12` | No divisors exist for -12 | Negative numbers are invalid |
| `0` | No divisors exist for 0 | Division by zero is undefined |

---

## Approach 1: Naive Method

### Logic
1. Loop through numbers from `1` to `n`.
2. For each `i`, check if `(n % i == 0)`.
3. Print `i` if it divides `n` evenly.

### Pseudocode
for i = 1 to number:
if number % i == 0:
print i


### Edge Cases
- `number <= 0`: Print a message indicating invalid input.
- `number = 1`: Only one divisor exists (1).

### Time & Space Complexity
| Metric | Complexity | Explanation |
|---------|-------------|-------------|
| Time | O(n) | Checks all numbers from 1 to n |
| Space | O(1) | Uses constant memory |

---

## Approach 2: Optimized Method (Using Square Root Logic)

### Logic
1. Divisors occur in pairs `(i, number/i)`.
2. Loop only from `1` to `√number`.
3. If `i` divides `number`, print both `i` and `number/i`.
4. For perfect squares, print the divisor only once.

### Example
For `number = 16`:
- i = 1 → Pair (1, 16)  
- i = 2 → Pair (2, 8)  
- i = 4 → Single divisor (4, since 4×4 = 16)

### Pseudocode
for i = 1 to sqrt(number):
if number % i == 0:
if number / i == i:
print i
else:
print i and number/i


### Edge Cases
- `number <= 0`: Print a message indicating invalid input.
- Works efficiently even for large numbers (like 10,000,000).

### Complexity

| Complexity | Description |
|-------------|-------------|
| **Time** | O(√n) — Only iterates up to the square root |
| **Space** | O(1) — Constant extra space |

---

## Approach 3: Using a List (Sorted Output)

### Logic
- Iterate till `√n` and store divisor pairs.
- Print smaller divisors immediately.
- Store larger divisors in a list and print them in reverse order for sorted output.

### Pseudocode
initialize result = empty list
for i = 1 to sqrt(n):
if n % i == 0:
if n / i == i:
print i
else:
print i
add (n / i) to result
print result in reverse

### Time & Space Complexity
| Metric | Complexity | Explanation |
|---------|-------------|-------------|
| Time | O(√n) | Iterates till square root |
| Space | O(√n) | Stores up to √n divisors in the list |

---

## Edge Cases

| Case | Input | Expected Output |
|-------|--------|----------------|
| Zero | 0 | No divisors exist for 0 |
| Negative Number | -12 | No divisors exist for -12 |
| One | 1 | Divisors of 1: 1 |
| Prime Number | 13 | Divisors of 13: 1 13 |
| Perfect Square | 16 | Divisors of 16: 1 2 4 8 16 |

---

## Sample Test Cases and Expected Outputs
=== Test Case 1: Positive Number (Normal Case) ===
Divisors of 10 (Naive): 1 2 5 10 
Divisors of 10 (Optimized): 1 10 2 5 
Divisors of 10 (Sorted Optimized): 1 2 5 10 

=== Test Case 2: Prime Number ===
Divisors of 13 (Naive): 1 13 
Divisors of 13 (Optimized): 1 13 
Divisors of 13 (Sorted Optimized): 1 13 

=== Test Case 3: Perfect Square ===
Divisors of 16 (Naive): 1 2 4 8 16 
Divisors of 16 (Optimized): 1 16 2 8 4 
Divisors of 16 (Sorted Optimized): 1 2 4 8 16 

=== Test Case 4: Smallest Positive Number (Edge Case) ===
Divisors of 1 (Naive): 1 
Divisors of 1 (Optimized): 1 
Divisors of 1 (Sorted Optimized): 1 

=== Test Case 5: Large Number (Performance Check) ===
Divisors of 100 (Optimized): 1 100 2 50 4 25 5 20 10 
Divisors of 100 (Sorted Optimized): 1 2 4 5 10 20 25 50 100 

=== Test Case 6: Negative Number (Invalid Input) ===
No divisors exist for -12
No divisors exist for -12
No divisors exist for -12

=== Test Case 7: Zero (Edge Case) ===
No divisors exist for 0
No divisors exist for 0
No divisors exist for 0

---

## Summary

| Approach | Description | Time Complexity | Space Complexity |
|-----------|--------------|------------------|------------------|
| Naive | Checks all numbers from 1 to n | O(n) | O(1) |
| Optimized | Uses divisor pairs and sqrt limit | O(√n) | O(1) |
| List-Based | Stores divisors for sorted order | O(√n) | O(√n) |

---
