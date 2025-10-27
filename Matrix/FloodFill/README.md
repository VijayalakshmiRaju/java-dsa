# Flood Fill Algorithm (Java)

## Problem Statement

Implement the **Flood Fill** algorithm — similar to the "paint bucket" tool in image editing software.  
Given a 2D matrix representing a screen where each cell holds a color value (integer),  
starting from a given pixel `(x, y)`, replace the color of that pixel and all adjacent pixels  
having the same color with a new color.

---

## Example

**Input:**

x = 4, y = 4, newColor = 3
Original Screen:
1 1 1 1 1 1 1 1
1 1 1 1 1 1 0 0
1 0 0 1 1 0 1 1
1 2 2 2 2 0 1 0
1 1 1 2 2 0 1 0
1 1 1 2 2 2 2 0
1 1 1 1 1 2 1 1
1 1 1 1 1 2 2 1


**Output:**

After Flood Fill at (4,4) with color 3:
1 1 1 1 1 1 1 1
1 1 1 1 1 1 0 0
1 0 0 1 1 0 1 1
1 3 3 3 3 0 1 0
1 1 1 3 3 0 1 0
1 1 1 3 3 3 3 0
1 1 1 1 1 3 1 1
1 1 1 1 1 3 3 1

---

## Approach

1. **Get the old color** at the starting pixel `(x, y)`.  
2. If the `oldColor` is the same as `newColor`, return immediately (no change needed).  
3. Use **Depth-First Search (DFS)** recursion to fill all connected pixels that have the same color.  
4. Recursively check 4 neighboring directions:
   - Up `(x-1, y)`
   - Down `(x+1, y)`
   - Left `(x, y-1)`
   - Right `(x, y+1)`
5. Replace each valid connected pixel with the `newColor`.

---

## Example Comparison (Side by Side)

| **Original Screen** | **After Flood Fill (x=4, y=4, newColor=3)** |
|----------------------|---------------------------------------------|
| 1 1 1 1 1 1 1 1 | 1 1 1 1 1 1 1 1 |
| 1 1 1 1 1 1 0 0 | 1 1 1 1 1 1 0 0 |
| 1 0 0 1 1 0 1 1 | 1 0 0 1 1 0 1 1 |
| 1 2 2 2 2 0 1 0 | 1 3 3 3 3 0 1 0 |
| 1 1 1 2 2 0 1 0 | 1 1 1 3 3 0 1 0 |
| 1 1 1 2 2 2 2 0 | 1 1 1 3 3 3 3 0 |
| 1 1 1 1 1 2 1 1 | 1 1 1 1 1 3 1 1 |
| 1 1 1 1 1 2 2 1 | 1 1 1 1 1 3 3 1 |

---

## Time and Space Complexity

| Complexity | Explanation |
|-------------|-------------|
| **Time Complexity:** O(N × M) | In the worst case, every cell in the matrix is visited once. |
| **Space Complexity:** O(N × M) | Due to recursion call stack in DFS traversal. |

---

## Test Cases Summary

1. **Basic Case:** Regular region fill.  
2. **Uniform Screen:** All cells same color.  
3. **No Fill Needed:** Old and new colors are identical.  
4. **Non-contiguous Regions:** Fill affects only connected same-color pixels.

---
