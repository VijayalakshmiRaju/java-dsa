# Count of Duplicate Elements

Given an **integer array** `arr[]`, this program counts how many elements appear **more than once** in the array.

---

# Problem Statement

Given:  
- An integer array `arr[]` of size `n`.

Find:  
- The **count of distinct elements** that occur **more than once** in the array.

---

## Algorithm Logic

We implement two approaches:

### **Approach 1: Naive (Brute Force)**
1. Iterate over each element.
2. For each element, count how many times it appears in the array.
3. If the count > 1, mark it as a duplicate.
4. Use a set to avoid counting the same duplicate multiple times.
5. Return the total number of distinct duplicates.

---

### **Approach 2: HashMap / Frequency Map (Optimized)**
1. Traverse the array and store frequencies of each element in a HashMap.
2. Iterate over the frequency map:
   - If `frequency > 1`, increment duplicate counter.
3. Return the duplicate counter.

---

## Time and Space Complexity

| Approach        | Time Complexity | Space Complexity |
|-----------------|-----------------|------------------|
| Naive (Brute)   | O(n²)           | O(1)             |
| HashMap Method  | O(n)            | O(n)             |

---

## Files

- `CountDuplicateElementInSortedArray.java`: Contains Java implementations using Naive and HashMap approaches.  
- `README.md`: This file - explanation, logic, and complexity.  
