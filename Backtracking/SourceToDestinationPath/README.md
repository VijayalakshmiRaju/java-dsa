# Path Reconstruction with Cycle Removal

This folder contains a **Java implementation** of reconstructing a path in a directed graph where each element in the input `paths` represents a direct connection from one city to another.

The goal is to **print the full path from the source city to the destination city** while **removing cycles** (ensuring no city is visited twice).

---

## Problem Statement

You are given an array `paths`, where:

`paths[i] = [cityAi, cityBi]`


represents a direct path from **cityAi** to **cityBi**.

- It is guaranteed that the graph has **one source city** and **one destination city**.
- However, the graph **may contain cycles**.  
- We must **eliminate cycles** and print the valid path from source to destination.

---

## Example

### Input
paths = [["A","D"], ["C","B"], ["B","E"], ["E","D"], ["D","C"], ["C","F"]]

### Output
A -> D -> C -> F


Here:
- There’s a cycle: `C -> B -> E -> D -> C`.
- After removing the cycle, the valid path is: `A -> D -> C -> F`.

---

## Algorithm

### Step 1: Build Graph
- Use a **HashMap** to map each city to the list of cities it connects to directly (outgoing edges).
- Track the **in-degree** (number of incoming edges) of each city.

### Step 2: Identify Source City
- Normally, the **source city** has `in-degree = 0`.
- If no city has `in-degree = 0` (because of a cycle), pick any city from the graph as the starting point.

### Step 3: DFS / Backtracking Traversal
- Start from the **source city**.
- Use **DFS with a visited set** to avoid revisiting nodes (preventing cycles).
- Collect the path in a list.

### Step 4: Print Path
- Join the cities with `" -> "` and display.

---

## Why Backtracking?

- A simple DFS would revisit nodes in a cycle.  
- Backtracking ensures:
  - We **mark** nodes as visited when entering.
  - We **skip** already visited nodes.
  - This guarantees a **cycle-free path**.

---

## Complexity

| Step        | Time Complexity | Space Complexity |
|-------------|-----------------|------------------|
| Graph Build | O(N)            | O(N)             |
| DFS Search  | O(N)            | O(N) (visited set + recursion) |

`N = number of paths`

---

## Edge Cases Covered

1. **Simple straight path** (no cycles)  
[["A","B"], ["B","C"], ["C","D"]]
→ A -> B -> C -> D

2. **Single cycle inside path**  
[["A","B"], ["B","C"], ["C","A"], ["C","D"]]
→ A -> B -> C -> D

3. **Cycle in the middle**  
[["A","D"], ["C","B"], ["B","E"], ["E","D"], ["D","C"], ["C","F"]]
→ A -> D -> C -> F

4. **Multiple branching but single destination**  
[["X","Y"], ["Y","Z"], ["Z","W"], ["W","Y"], ["Z","A"]]
→ X -> Y -> Z -> A

5. **Cycle back to source**  
[["A","B"], ["B","C"], ["C","A"], ["C","D"]]
→ A -> B -> C -> D


---

## How to Run

- Compile:
javac SourceToDestinationPath.java

- Run
java SourceToDestinationPath
