# Greatest Common Divisor (GCD)

## Problem Statement  
Write a Java program to find the **Greatest Common Divisor (GCD)** of two integers using:
1. **Recursive subtraction-based Euclidean algorithm**  
2. **Optimized modulo-based Euclidean algorithm**

The **GCD** (also called HCF — Highest Common Factor) of two numbers is the largest integer that divides both numbers without leaving any remainder.

---

## Approach  

### 1. Subtraction-Based Recursive Approach  
- Convert both numbers to absolute values to handle negatives.  
- Base cases:
  - If both numbers are `0` → GCD is undefined (return `0` safely)
  - If one number is `0` → GCD is the other number
  - If both numbers are equal → GCD is that number
- Otherwise:
  - Subtract the smaller number from the larger one
  - Recurse until both numbers become equal

**Example:**  
→ findGCD(30, 24)
→ findGCD(6, 24)
→ findGCD(6, 18)
→ findGCD(6, 12)
→ findGCD(6, 6)
→ 6

---

### 2. Optimized Modulo-Based Euclidean Algorithm  
- Convert both numbers to absolute values
- Use the property:
GCD(a, b) = GCD(b, a % b)

- Continue until `b` becomes `0`
- Much faster than subtraction-based method

**Example:**  
findGCDOptimized(54, 24)
→ findGCDOptimized(24, 6)
→ findGCDOptimized(6, 0)
→ 6

---

## Time and Space Complexity  

| Approach | Time Complexity | Space Complexity | Notes |
|----------|----------------|-----------------|-------|
| Subtraction-based | O(max(num1, num2)) | O(max(num1, num2)) | Repeated subtraction can be slow for large differences |
| Modulo-based | O(log(min(num1, num2))) | O(log(min(num1, num2))) | Efficient and preferred in production |

---

## Functions  

- `findGCD(int num1, int num2)`  
  → Recursive subtraction-based Euclidean algorithm  

- `findGCDOptimized(int num1, int num2)`  
  → Optimized modulo-based Euclidean algorithm  

- `main()`  
  → Contains comprehensive test cases covering all edge cases

---

## Test Cases  

| # | Input (a, b) | Expected GCD | Description |
|---|---------------|--------------|-------------|
| 1 | (10, 15)     | 5            | Common factor 5 |
| 2 | (35, 10)     | 5            | Simple case |
| 3 | (100, 80)    | 20           | Multiple common factors |
| 4 | (7, 13)      | 1            | Prime numbers |
| 5 | (0, 25)      | 25           | One number is 0 |
| 6 | (25, 0)      | 25           | One number is 0 |
| 7 | (0, 0)       | Undefined    | Both numbers zero |
| 8 | (54, 24)     | 6            | Classic GCD example |
| 9 | (48, 180)    | 12           | Common factors 12 |
| 10 | (81, 27)    | 27           | One is multiple of other |
| 11 | (1, 9999)   | 1            | 1 with any number |
| 12 | (-20, 60)   | 20           | Negative handling |
| 13 | (270, 192)  | 6            | Common case |
| 14 | (-81, -27)  | 27           | Both negative |
| 15 | (17, 0)     | 17           | Edge case |
| 16 | (-25, 0)    | 25           | Negative + zero |
| 17 | (120, -48)  | 24           | Mixed signs |

---

## Sample Output  

=== GCD (Greatest Common Divisor) Test Results ===

Test Case 1: GCD(10, 15)
→ Recursive (Subtraction): 5
→ Optimized (Modulo): 5

Test Case 2: GCD(35, 10)
→ Recursive (Subtraction): 5
→ Optimized (Modulo): 5

Test Case 3: GCD(100, 80)
→ Recursive (Subtraction): 20
→ Optimized (Modulo): 20

Test Case 4: GCD(7, 13)
→ Recursive (Subtraction): 1
→ Optimized (Modulo): 1

Test Case 5: GCD(0, 25)
→ Recursive (Subtraction): 25
→ Optimized (Modulo): 25

Test Case 7: GCD(0, 0)
→ Undefined (both are zero)

=== End of Test Cases ===
---
