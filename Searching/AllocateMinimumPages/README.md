# Allocate Minimum Number of Pages

This project contains a Java implementation of the **Book Allocation Problem** (also known as Allocate Minimum Number of Pages).  

The solution is first implemented using a **recursive approach** for clarity, and then optimized using **Binary Search + Greedy** for efficiency.  

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

---

## Approach

### 1. Recursive Partitioning (Brute Force)
- Try all possible ways to partition the books among students.  
- For each partition:
  - Compute the maximum pages allocated to any student.  
  - Take the minimum across all partitions.  
- Guarantees correctness but is inefficient for large inputs.  

### 2. Optimized Approach (Binary Search + Greedy)
- Define the answer range:
  - Minimum = maximum pages of a single book.  
  - Maximum = sum of all pages.  
- Apply binary search on this range.  
- For each mid value, check feasibility using a **greedy allocation**.  
- Narrow down to the minimum feasible maximum.  

---

## Complexities
| Approach                         | Time Complexity       | Space Complexity |
|----------------------------------|-----------------------|------------------|
| Recursive (brute force)          | Exponential `O(2^n)` | `O(n)` (recursion stack) |
| Binary Search + Greedy (optimal) | `O(n log(sum(arr)))` | `O(1)` |

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
- The **recursive approach** is useful for understanding the problem’s fundamentals.  
- The **binary search + greedy approach** is the practical and scalable solution.  
