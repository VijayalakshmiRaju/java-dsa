# Reverse Individual Words

## Problem Statement
Given a sentence, reverse each individual word while maintaining the original word order in the sentence.

### Example
Input : "Welcome to the club"
Output : "emocleW ot eht bulc"

---

## Approach
1. **Use a Stack**  
   - Traverse the string character by character.  
   - Push each character into a stack until a space `' '` is found.  
   - When a space is encountered, pop all characters from the stack and append them to the result (this reverses the word).  
   - Append the space and continue with the next word.

2. **Handle the Last Word**  
   - After the loop ends, pop and append any remaining characters in the stack to handle the last word.

3. **Edge Case Handling**  
   - Works correctly with multiple spaces, leading/trailing spaces, punctuation, and empty strings.

---

## Test Cases
| Test Case | Input | Expected Output |
|------------|--------|----------------|
| 1 | Welcome to the club | emocleW ot eht bulc |
| 2 | Hello | olleH |
| 3 | Java   is   fun | avaJ   si   nuf |
| 4 | *(empty string)* | *(empty string)* |
| 5 |   Welcome home   |   emocleW emoh   |
| 6 | Hello, world! | ,olleH !dlrow |
| 7 | 123 456 789 | 321 654 987 |
| 8 | (only spaces) | (only spaces) |
| 9 | HeLLo WoRLd | oLLeH dLRoW |

---

## Time Complexity
**O(n)** – Each character is pushed and popped from the stack at most once.

## Space Complexity
**O(n)** – Stack and result string require space proportional to input length.

---
