# Factorial (Recursive Approach)

## Problem Statement
Write a program to compute the factorial of a given number using recursion.

A factorial of a non-negative integer `n` is the product of all positive integers less than or equal to `n`.

Mathematically:

n! = n × (n - 1) × (n - 2) × ... × 1


Special Case:  
`0! = 1`

---

## Approach

| Step | Description |
|------|--------------|
| 1 | If the number is 0, return 1 (Base Case). |
| 2 | Otherwise, multiply the number by factorial of (number - 1). |
| 3 | Continue the recursion until the number becomes 0. |
| 4 | Handle negative numbers separately as factorial is undefined for them. |

---

## Formula

factorial(n) =
1 if n = 0
n * factorial(n-1) if n > 0


---

## Complexity Analysis

| Type | Complexity | Explanation |
|------|-------------|-------------|
| Time Complexity | O(n) | Each recursive call computes factorial of one smaller number until 0. |
| Space Complexity | O(n) | Recursive calls are stored in the function call stack. |

---

## Test Cases and Expected Output

| Input | Expected Output |
|--------|----------------|
| 0 | 1 |
| 1 | 1 |
| 2 | 2 |
| 5 | 120 |
| 7 | 5040 |
| 10 | 3628800 |
| -3 | Undefined (Negative number) |

---

## Sample Output

---- Factorial Test Cases ----
Factorial of 0 = 1
Factorial of 1 = 1
Factorial of 2 = 2
Factorial of 5 = 120
Factorial of 7 = 5040
Factorial of 10 = 3628800
Factorial of -3: Undefined (Negative number)

---
