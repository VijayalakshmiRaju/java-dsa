# Non-Overlapping Max Events Problem

This folder contains the implementation of selecting the **maximum number of non-overlapping events**:  
- Uses **Greedy Algorithm** (Activity Selection approach).  
- Events are **sorted by end time** using a **custom Merge Sort** (no built-in methods).  

The algorithm ensures you can attend the **maximum possible events** without time overlaps.  

---

## Problem Statement

You are given a list of events represented as `start` and `end` times.  
Your task is to select the **maximum number of events** such that **no two events overlap**.  

Two events `[s1, e1]` and `[s2, e2]` are considered **non-overlapping** if:  

   `s2 >= e1`

---

## Algorithm

### Greedy Approach (with Merge Sort)
1. **Sort events by their end time** using **custom Merge Sort**.  
   - Sorting ensures we always pick the earliest finishing event first.  
   - This leaves maximum room for future events.  

2. **Initialize counters**:
   - `count = 0` → number of non-overlapping events selected.  
   - `lastEndTime = -∞` → keeps track of the end time of the last chosen event.  

3. **Iterate over sorted events**:
   - If an event’s start time ≥ `lastEndTime`, select it.  
   - Update `lastEndTime = end` of that event.  
   - Increment `count`.  

4. **Return `count`** as the maximum events possible.  

---

## Time and Auxiliary Space (extra space used)

| Step              | Time Complexity | Auxiliary Space | Explanation |
|-------------------|-----------------|-----------------|-------------|
| Merge Sort        | O(n log n)      | O(n)            | Sorting events by end time |
| Greedy Selection  | O(n)            | O(1)            | Single pass through events |
| **Total**         | **O(n log n)**  | **O(n)**        | Sorting dominates |

---

## Test Cases

| **Input Events**                                | **Output (Max Events)** | **Explanation** |
|------------------------------------------------|--------------------------|-----------------|
| `[[3,3],[4,7],[4,5],[3,4],[1,2]]`              | 4                        | Pick `[1,2], [3,3], [3,4], [4,5]` |
| `[[1,10],[2,9],[3,8],[4,7]]`                   | 1                        | All overlap, pick earliest finishing |
| `[[1,2],[3,4],[5,6],[7,8]]`                    | 4                        | No overlaps, pick all |
| `[[1,3],[2,3],[3,3],[4,5]]`                    | 3                        | Pick `[1,3], [3,3], [4,5]` |
| `[[5,10]]`                                     | 1                        | Single event |
| `[]`                                           | 0                        | No events |
| `[[100,200],[300,400],[500,600]]`              | 3                        | Non-overlapping large values |
| `[[1,1],[2,2],[2,2],[3,3]]`                    | 3                        | Pick `[1,1], [2,2], [3,3]` |

---

## Files
- `NonOverlappingMaxEvents.java` – Java implementation with merge sort and greedy selection.  
