# Binary Search
This folder contains the implementation of Binary Search in Java:
 - Iterative method
 - Recursive method

The algorithm assumes the array is **sorted in ascending order**.

## Algorithm

Binary Search works by repeatedly dividing the search space in half:

1. Compare the middle element with the target.
2. If equal -> return index.
3. If target < mid -> search in the left half.
4. If target > mid -> search in the right half.

### Time and Auxillary Space(extra space used)

| Approach     | Time Complexity | Auxiliary Space | Explanation |
|--------------|------------------|------------------|-------------|
| Iterative    | O(log n)         | O(1)             | Constant space, loop-based logic |
| Recursive    | O(log n)         | O(log n)         | Each recursive call adds a new frame to the stack |

## Files
- `BinarySearch.java` - Java file with both iterative and recursive implementations.

## Input
- Sorted integer array
- Target value to search

## Output
- Index of the element if found, otherwise `-1`