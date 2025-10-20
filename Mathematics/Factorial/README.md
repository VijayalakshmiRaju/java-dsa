# Factorial (Recursive and Iterative Approaches)

## Problem Statement
Write a program to compute the factorial of a given number using both **recursion** and **iteration**.

A factorial of a non-negative integer `n` is the product of all positive integers less than or equal to `n`.

Mathematically:

n! = n × (n - 1) × (n - 2) × ... × 1


Special Case:  
`0! = 1`

Factorial is **undefined for negative numbers**.

---

## Approaches

### Recursive Approach
| Step | Description |
|------|--------------|
| 1 | If the number is 0, return 1 (Base Case). |
| 2 | Otherwise, multiply the number by factorial of (number - 1). |
| 3 | Recursively call the function until the base case is reached. |

### Iterative Approach
| Step | Description |
|------|--------------|
| 1 | Initialize `result = 1`. |
| 2 | Multiply `result` by every number from 2 to `n`. |
| 3 | Return the final result after the loop completes. |

---

## Formula

factorial(n) =
1 if n = 0
n * factorial(n-1) if n > 0

---

## Complexity Analysis

| Approach | Time Complexity | Space Complexity | Notes |
|-----------|----------------|------------------|-------|
| Recursive | O(n) | O(n) | Function calls add to call stack. |
| Iterative | O(n) | O(1) | Efficient, no recursion overhead. |

---

## Test Cases and Expected Output

| Input | Recursive Result | Iterative Result | Notes |
|--------|------------------|------------------|-------|
| 0 | 1 | 1 | Base Case |
| 1 | 1 | 1 | Simple Case |
| 2 | 2 | 2 | Small Number |
| 3 | 6 | 6 | General Case |
| 5 | 120 | 120 | Common Example |
| 7 | 5040 | 5040 | Moderate Number |
| 10 | 3628800 | 3628800 | Larger Number |
| 12 | 479001600 | 479001600 | Edge of Integer Limit |
| -1 | Undefined | Undefined | Negative Input |
| -5 | Undefined | Undefined | Negative Input |

---

## Sample Output

---- Factorial Test Cases ----

Number: 0
Recursive Result: 1
Iterative Result: 1
Number: 1
Recursive Result: 1
Iterative Result: 1
Number: 2
Recursive Result: 2
Iterative Result: 2
Number: 3
Recursive Result: 6
Iterative Result: 6
Number: 5
Recursive Result: 120
Iterative Result: 120
Number: 7
Recursive Result: 5040
Iterative Result: 5040
Number: 10
Recursive Result: 3628800
Iterative Result: 3628800
Number: 12
Recursive Result: 479001600
Iterative Result: 479001600

Factorial of -1: Undefined (Negative number)

Factorial of -5: Undefined (Negative number)

---- End of Test Cases ----
