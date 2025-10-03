# Valid Palindrome

This project contains a simple Java program to check whether a given string is a **valid palindrome**.  

A valid palindrome is defined as a string that reads the same backward as forward **after ignoring spaces, punctuation, and case differences**. For example:  
- `"A man, a plan, a canal: Panama"` → **true**  
- `"racecar"` → **true**  
- `"hello"` → **false**

---

## Features
- Removes all non-alphanumeric characters (ignores spaces, punctuation, symbols).  
- Converts uppercase characters to lowercase for comparison.  
- Uses **two-pointer technique** for efficient palindrome checking.  
- Supports numbers and letters.  
- Includes a main method with multiple test cases, including **edge cases**.

---

## How It Works
1. Clean the input string:  
   - Keep only letters (`a–z`, `A–Z`) and digits (`0–9`).  
   - Convert uppercase letters to lowercase.  
2. Use **two pointers** (`left` and `right`) to compare characters from both ends.  
3. If all characters match, the string is a palindrome.  

---

## Test Cases Covered
The program tests multiple scenarios including:  
- Palindromes (`racecar`, `Madam`, `12321`, `A man, a plan, a canal: Panama`)  
- Non-palindromes (`hello`, `world`, `palindrome`, `12345`)  
- Edge cases (empty string, only spaces, only punctuation, single character, digits, two-letter cases).  

---

## Complexity Analysis

| Operation | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| Cleaning the string (building alphanumeric lowercase string) | **O(n)** | **O(n)** |
| Palindrome check with two-pointer comparison | **O(n/2) ≈ O(n)** | **O(1)** |
| **Overall** | **O(n)** | **O(n)** |

Where **n = length of the input string**.  

---

## How to Run
1. Save the file as `ValidPalindrome.java`.  
2. Compile the program:  
   ```bash
   javac ValidPalindrome.java
   ```
3. Run
   ```bash
   java ValidPalindrome
   ```
