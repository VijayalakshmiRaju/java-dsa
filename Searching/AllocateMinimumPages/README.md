# Allocate Minimum Number of Pages

This project contains a Java implementation of the **Book Allocation Problem** (also known as Allocate Minimum Number of Pages).  

The solution is first implemented using a **recursive approach** for clarity. It demonstrates how to explore all possible allocations of books among students to minimize the maximum number of pages allocated.  

---

## Problem Statement
You are given:
- An array `arr[]` of size `n`, where `arr[i]` represents the number of pages in the `i`-th book.  
- An integer `noOfStudents` representing the number of students.  

Books must be allocated **contiguously** to students such that:
1. Each student gets **at least one book**.  
2. The **maximum number of pages allocated to a student is minimized**.  

Return that minimum possible value.

---

## Example
```text
arr = [12, 34, 67, 90]
n = 4
noOfStudents = 2
```
Possible allocations:

Student 1 → [12, 34], Student 2 → [67, 90] → max pages = 157
Student 1 → [12], Student 2 → [34, 67, 90] → max pages = 191
Student 1 → [12, 34, 67], Student 2 → [90] → max pages = 113 (optimal)

Answer = 113

## Approach
### 1. Recursive Partitioning (Brute Force)
- Try all possible ways to partition the books among students.
- For each partition:
  - Compute the maximum pages allocated to any student.
  - Take the minimum across all partitions.
- Guarantees the correct result but is inefficient for large inputs.

---

## Complexities
| Approach                 | Time Complexity       | Space Complexity |
|---------------------------|-----------------------|------------------|
| Recursive (brute force)   | Exponential `O(2^n)` | `O(n)` (recursion stack) |

---

## Test Cases
The program includes multiple test cases including **edge cases**:

1. **Standard Case** → Multiple books, multiple students.  
2. **Single Student** → One student must take all books.  
3. **Students = Books** → Each student gets exactly one book.  
4. **More Students than Books** → Extra students don’t change the result.  
5. **Equal Pages Books** → Balanced allocation possible.  
6. **Single Book** → Only one book to allocate.  

---

## Sample Output
Test 1 → Expected: 113, Got: 113
Test 2 → Expected: 100, Got: 100
Test 3 → Expected: 20, Got: 20 
Test 4 → Expected: 15, Got: 15
Test 5 → Expected: 20, Got: 20
Test 6 → Expected: 42, Got: 42

---

## Notes
- This implementation demonstrates the **recursive brute-force solution**.  
- For larger input sizes, an **optimized binary search + greedy approach** should be preferred for efficiency.  
