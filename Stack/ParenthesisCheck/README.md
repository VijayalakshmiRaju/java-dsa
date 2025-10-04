# Parenthesis Check (Balanced Parentheses)

## Problem Statement
Given a string containing the characters **'(' , ')' , '{' , '}' , '[' , ']'**, determine if the string is **valid**.

A string is considered **valid** if:
1. Every opening bracket has a corresponding closing bracket of the same type.  
2. Brackets close in the correct order.  
3. Any extra characters (like alphabets, digits, symbols) can be ignored.

---

## Approach
We solve this problem using a **stack**:

1. Traverse the input string character by character.  
2. If the character is an **opening bracket** (`(`, `{`, `[`), push it onto the stack.  
3. If the character is a **closing bracket** (`)`, `}`, `]`):  
   - If the stack is empty → invalid.  
   - If the top of the stack does not match the corresponding opening bracket → invalid.  
   - If it matches, pop from the stack.  
4. After traversal, if the stack is empty → Valid, otherwise Invalid.

---

## Example Run

**Input:**  
([{}])


**Process (Stack State):**
- `(` → push → [ ( ]  
- `[` → push → [ ( , [ ]  
- `{` → push → [ ( , [ , { ]  
- `}` → pop `{` → [ ( , [ ]  
- `]` → pop `[` → [ ( ]  
- `)` → pop `(` → [ ] (empty)

**Output:**  
Valid

---

## Test Cases

| Input        | Output   |
|--------------|----------|
| `()`         | Valid |
| `()[]{}`     | Valid |
| `([{}])`     | Valid |
| `(]`         | Invalid |
| `([)]`       | Invalid |
| `(((`        | Invalid |
| `))`         | Invalid |
| `({[})`      | Invalid |
| `` (empty)   | Valid |
| `a+b*(c-d)`  | Valid |
| `[`          | Invalid |
| `]`          | Invalid |

---

## Complexity Analysis

| Operation | Complexity |
|-----------|-------------|
| Time      | **O(n)** – Each character is processed once |
| Space     | **O(n)** – In the worst case, all characters are opening brackets |

---

## Files
- `ParenthesisCheck.java` → Implementation with test cases.  
- `README.md` → Problem explanation, approach, complexity analysis, and test cases.  

---

## How to Run
Compile and run the program:

```bash
javac ParenthesisCheck.java
java ParenthesisCheck
```
