# First Non-Repeating Character

This folder contains a Java implementation of finding the **first non-repeating character** in a given string.  
The program provides two approaches:
- **HashMap-based approach** (works for both uppercase `A–Z` and lowercase `a–z`).
- **Array-based approach** (uses fixed-size frequency array for `A–Z` and `a–z`).

---

## Algorithm Logic

### HashMap Approach
1. Traverse the string and count the frequency of each character using a `HashMap`.
2. Traverse the string again and return the index of the first character with frequency `1`.
3. If no such character exists, return `-1`.

### Array Approach
1. Initialize a frequency array of size `52` (26 uppercase + 26 lowercase).
2. Count occurrences of each character:
   - For `A–Z`, store counts at index `0–25`.
   - For `a–z`, store counts at index `26–51`.
3. Traverse the string again and return the index of the first character with frequency `1`.
4. If none exists, return `-1`.

---

## Time and Space Complexity

| Approach      | Time Complexity | Auxiliary Space |
|---------------|------------------|-----------------|
| HashMap       | O(n)             | O(1) – at most 52 unique characters (constant space) |
| Array         | O(n)             | O(1) – fixed array size of 52 |

> `n` is the length of the string.

---

## Files

- `FirstNonRepeatingCharacter.java`: Java source file containing both approaches with test cases in the `main` method.
- `README.md`: This file – explanation, logic, and complexity.

---
