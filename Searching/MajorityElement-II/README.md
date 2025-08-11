# Majority Element II (Java)

## Problem Statement
Given an integer array `nums`, find all elements that appear more than ⌊n/3⌋ times.  
You must solve the problem in **O(n)** time and **O(1)** space.

---

## Approach
We use a **modified Boyer-Moore Voting Algorithm**:
1. **Candidate Selection (Phase 1)**  
   Since there can be at most **two elements** appearing more than `n/3` times,  
   we keep track of two candidates and their counts.
2. **Candidate Verification (Phase 2)**  
   Count the occurrences of these two candidates and check if they occur more than `n/3` times.

---

## Complexity Analysis

| Step                | Time Complexity | Space Complexity |
|---------------------|-----------------|------------------|
| Find Candidates     | O(n)            | O(1)             |
| Verify Candidates   | O(n)            | O(1)             |
| **Total**           | **O(n)**        | **O(1)**         |

---
