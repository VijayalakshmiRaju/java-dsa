# Majority Element Finder (Java)

## Problem Statement
Given an integer array `nums`, find the **majority element** - the element that appears **more than `n/2` times**.  
If no such element exists, return `-1`.

---

## Approach
We use the **Boyer-Moore Voting Algorithm**:
1. **Find Candidate**: Traverse the array and maintain a `count` with a possible `candidate`.
2. **Verify Candidate**: Count the actual occurrences of the candidate to check if it is the majority.

---

## Complexity Analysis

| Step              | Time Complexity | Space Complexity |
|-------------------|-----------------|------------------|
| Find Candidate    | O(n)            | O(1)             |
| Verify Candidate  | O(n)            | O(1)             |
| **Total**         | **O(n)**        | **O(1)**         |

---
