# Decode String by Reversing Chunks

## Problem Statement

You are given an **encoded string** `s` and an integer `k`.  
The string was encoded using the following process:

1. Take the first `k` characters of the original string.
2. Reverse them and append to the result.
3. Repeat the process for every consecutive `k` characters until the end of the string.
4. If the last chunk has fewer than `k` characters, reverse it as well.

Your task is to **decode** the given string to get back the original string.

---

### Example

#### Input
s = "cbafedgh"
k = 3


#### Encoding Process
Original string: `abcdefgh`

- First `k=3` → `abc` → reverse → `cba`
- Next `k=3` → `def` → reverse → `fed`
- Remaining `gh` → reverse → `hg`

Encoded string = `cbafedhg`

#### Decoding Process
To decode, we reverse each chunk again:

- First chunk: `cba` → `abc`
- Second chunk: `fed` → `def`
- Last chunk: `hg` → `gh`

Result = `abcdefgh`

---

## Approach

1. Iterate through the string in steps of `k`.
2. For each chunk:
   - Calculate the `endIndex` (handle the last chunk carefully).
   - Append characters from `endIndex` down to `i` (manual reverse).
3. Build the final result string by concatenating all reversed chunks.

---

## Example Walkthrough

**Input:** `s = "cbafedgh", k = 3`

| Chunk Index | Characters | Reversed | Result So Far |
|------------|-----------|---------|---------------|
| 0–2        | `cba`     | `abc`  | `abc` |
| 3–5        | `fed`     | `def`  | `abcdef` |
| 6–7        | `hg`      | `gh`   | `abcdefgh` |

**Output:** `abcdefgh`

---

## Time and Space Complexity

| Complexity | Explanation |
|-----------|-------------|
| **Time**  | **O(n)** — We traverse every character once, and append it exactly once. |
| **Space** | **O(1)** extra space (ignoring the output string). No extra arrays or buffers are used. |

---

## Test Cases

The following test cases are included in the code:

| # | Input String | k | Expected Output | Notes |
|---|-------------|---|----------------|------|
| 1 | `cbafedgh` | 3 | `abcdefgh` | Normal case |
| 2 | `A` | 1 | `A` | Single character |
| 3 | `abcd` | 1 | `abcd` | k=1 (no reversal) |
| 4 | `abcd` | 10 | `dcba` | k > length (whole string reversed) |
| 5 | `""` | 3 | `""` | Empty string |
| 6 | `xyz` | 0 | `xyz` | k=0 (return as is) |
| 7 | `cbafedhg` | 3 | `abcdefgh` | Last chunk smaller than k |
| 8 | `cbade` | 3 | `abcde` | Odd length string |
| 9 | `ccbbaa` | 2 | `aabbcc` | Repeated characters |

---

## Sample Output
Test 1 | Input: "cbafedgh", k=3 | Output: "abcdefgh" | Expected: "abcdefgh" | PASS
Test 2 | Input: "A", k=1 | Output: "A" | Expected: "A" | PASS
Test 3 | Input: "abcd", k=1 | Output: "abcd" | Expected: "abcd" | PASS
Test 4 | Input: "abcd", k=10 | Output: "dcba" | Expected: "dcba" | PASS
Test 5 | Input: "", k=3 | Output: "" | Expected: "" | PASS
Test 6 | Input: "xyz", k=0 | Output: "xyz" | Expected: "xyz" | PASS
Test 7 | Input: "cbafedhg", k=3 | Output: "abcdefgh" | Expected: "abcdefgh" | PASS
Test 8 | Input: "cbade", k=3 | Output: "abcde" | Expected: "abcde" | PASS
Test 9 | Input: "ccbbaa", k=2 | Output: "aabbcc" | Expected: "aabbcc" | PASS
