# Minimum Meeting Rooms with Capacity Constraint

## Problem Statement

We are given a list of meetings, where each meeting is represented as:

[startTime, endTime, numberOfPeople]


We also have a **room capacity** which defines the maximum number of people allowed inside a room at a time.  

Our task is to **find the minimum number of rooms required** to schedule all valid meetings, considering the following rules:

- **Ignore** (cancel) meetings where `numberOfPeople > capacity`.
- At a time, **one room can hold only one meeting**.
- We must schedule all remaining valid meetings such that **no two overlapping meetings use the same room**.

---

## Example

### Input:
meetings = [[9, 10, 3], [9, 12, 5], [11, 12, 8]]
capacity = 10


### Step 1: Filter meetings exceeding capacity  
All meetings have numberOfPeople ≤ 10 → all are valid.

### Step 2: Find overlaps
- Meeting 1: [9, 10]
- Meeting 2: [9, 12]
- Meeting 3: [11, 12]

At **time 9 - 10** → Meeting 1 and Meeting 2 overlap → 2 rooms needed  
At **time 11 - 12** → Meeting 2 and Meeting 3 overlap → 2 rooms needed  

### Output:
Minimum rooms required = 2


---

## Approach (Sweep Line Algorithm)

We use a **sweep line algorithm** (also called "event timeline approach"):

1. **Filter meetings** → Only keep those where `numberOfPeople <= capacity`.
2. **Create events**:
   - `(startTime, +1)` for meeting start  
   - `(endTime, -1)` for meeting end
3. **Sort events**:
   - By time  
   - If two events have the same time, process `-1` (end) before `+1` (start) to avoid counting extra rooms.
4. **Sweep through events**:
   - Maintain a counter `rooms` → add `+1` for start, `-1` for end  
   - Track `maxRooms` → maximum value of `rooms` during the sweep  
   - `maxRooms` is our answer.

---

## Complexity Analysis

| Aspect              | Complexity |
|--------------------|-----------|
| **Time Complexity** | **O(N log N)** → Sorting events takes O(N log N), where N = number of meetings. |
| **Auxiliary Space** | **O(N)** → Extra list to store 2 × N events. |

---

## Example Dry Run

### Input:
meetings = [[9, 10, 3], [9, 12, 5], [11, 12, 8]], capacity = 10


| Step | Event (time, type) | Rooms Count | Max Rooms |
|------|-------------------|-------------|-----------|
| 1    | (9, +1)           | 1           | 1 |
| 2    | (9, +1)           | 2           | 2 |
| 3    | (10, -1)          | 1           | 2 |
| 4    | (11, +1)          | 2           | 2 |
| 5    | (12, -1)          | 1           | 2 |
| 6    | (12, -1)          | 0           | 2 |

**Answer = 2**

---

## Test Cases

| Test Case | Meetings | Capacity | Expected Output | Explanation |
|----------|----------|---------|----------------|-------------|
| 1 | `[[9, 10, 3], [9, 12, 5], [11, 12, 8]]` | `10` | `2` | Overlapping meetings → 2 rooms |
| 2 | `[[9, 10, 15], [10, 11, 5]]` | `10` | `1` | First meeting ignored (exceeds capacity) |
| 3 | `[[9, 10, 3], [10, 11, 4], [11, 12, 5]]` | `10` | `1` | Back-to-back meetings reuse 1 room |
| 4 | `[[9, 12, 3], [10, 12, 5], [11, 12, 4]]` | `10` | `3` | All overlapping → 3 rooms |
| 5 | `[]` | `10` | `0` | No meetings |
| 6 | `[[9, 10, 2], [9, 10, 3], [9, 10, 4]]` | `10` | `3` | All same time → 3 rooms |
| 7 | `[[9, 10, 2], [10, 11, 3], [11, 12, 4]]` | `10` | `1` | Meetings start exactly when others end |

---

## How to Run

1. Save the Java file as `MinimumMeetingRooms.java`
2. Compile the code:
   javac MinimumMeetingRooms.java
3. Run the program:
   java MinimumMeetingRooms
