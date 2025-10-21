# GCD (Greatest Common Divisor)

## Problem Statement
Write a program to find the Greatest Common Divisor (GCD) of two given integers using recursion.

The GCD (also known as HCF – Highest Common Factor) of two numbers is the largest positive integer that divides both numbers without leaving a remainder.

---

## Approach

This implementation uses the recursive subtraction-based Euclidean algorithm.

### Steps
1. If one of the numbers is 0, return the other number as the GCD.  
2. If both numbers are equal, return any one of them as the GCD.  
3. Otherwise:
   - Subtract the smaller number from the larger number.
   - Recursively call the function until one of the base cases is reached.

### Example
findGCD(10, 15)
= findGCD(10, 15 - 10)
= findGCD(10, 5)
= findGCD(10 - 5, 5)
= findGCD(5, 5)
= 5


---

## Formula Explanation

For two numbers `a` and `b`:

GCD(a, b) = GCD(a - b, b) if a > b
GCD(a, b) = GCD(a, b - a) if b > a


Eventually, this reduces to:
GCD(a, 0) = a

---

## Test Cases

| Test Case | Input (num1, num2) | Expected Output | Explanation |
|------------|--------------------|------------------|--------------|
| 1 | (10, 15) | 5 | Common factors: 1, 5 |
| 2 | (35, 10) | 5 | Common factors: 1, 5 |
| 3 | (100, 80) | 20 | Common factors: 1, 2, 4, 5, 10, 20 |
| 4 | (7, 13) | 1 | Both are primes |
| 5 | (0, 25) | 25 | One number is 0 |
| 6 | (25, 0) | 25 | One number is 0 |
| 7 | (0, 0) | Undefined | Both are zero |
| 8 | (54, 24) | 6 | Common factors: 1, 2, 3, 6 |
| 9 | (48, 180) | 12 | Common factors: 1, 2, 3, 6, 12 |
| 10 | (81, 27) | 27 | 27 divides 81 |
| 11 | (1, 9999) | 1 | 1 divides every number |

---

## Time and Space Complexity

| Complexity Type | Description |
|------------------|-------------|
| Time Complexity | O(max(num1, num2)) — due to repeated subtraction |
| Space Complexity | O(max(num1, num2)) — recursive call stack usage |

---

## Example Output

=== GCD (Greatest Common Divisor) Test Results ===

Test Case 1: GCD(10, 15) = 5
Test Case 2: GCD(35, 10) = 5
Test Case 3: GCD(100, 80) = 20
Test Case 4: GCD(7, 13) = 1
Test Case 5: GCD(0, 25) = 25
Test Case 6: GCD(25, 0) = 25
Test Case 7: GCD(0, 0) → Undefined (both are zero)
Test Case 8: GCD(54, 24) = 6
Test Case 9: GCD(48, 180) = 12
Test Case 10: GCD(81, 27) = 27
Test Case 11: GCD(1, 9999) = 1

=== End of Test Cases ===
