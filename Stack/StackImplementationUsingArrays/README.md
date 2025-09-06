# Stack Implementation (Array-based)

This folder contains a **Java implementation of a Stack** using arrays.  
The stack supports all standard stack operations along with an additional **swap** operation.

---

## Features

1. **Empty check** – `isEmpty()`  
2. **Full check** – `isFull()`  
3. **Push** – `push(int value)`  
4. **Pop** – `pop()`  
5. **Peek** – `peek()`  
6. **Size** – `size()`  
7. **Display** – `displayStack()`  
8. **Make Stack Empty** – `makeStackEmpty()`  
9. **Swap elements at two indices** – `swap(int index1, int index2)`  

---

## Algorithm Logic

### Push
- Check if the stack is **not full**.
- Increment `top` and insert the element.
- If full, push fails.

### Pop
- Check if the stack is **not empty**.
- Return the element at `top`, then decrement `top`.
- If empty, return `-1`.

### Peek
- Return the element at `top` without removing it.
- If empty, return `-1`.

### Swap
- Validate both indices are within `0` to `top`.
- Swap the two elements if stack has at least **2 elements**.

---

## Complexities

| Operation       | Time Complexity | Space Complexity |
|-----------------|-----------------|------------------|
| Push            | O(1)            | O(1)             |
| Pop             | O(1)            | O(1)             |
| Peek            | O(1)            | O(1)             |
| Swap            | O(1)            | O(1)             |
| Display         | O(n)            | O(1)             |
| Make Empty      | O(n)            | O(1)             |

---

## Edge Cases Covered

1. **Push on full stack** → fails with message.  
2. **Pop from empty stack** → returns `-1` with message.  
3. **Peek from empty stack** → returns `-1` with message.  
4. **Swap with invalid indices** → prints error message.  
5. **Emptying stack completely** using `makeStackEmpty()`.  
6. **Custom constructor** to build stack from an existing array.  

---

## Notes
- Default capacity = **10**.  
- Elements beyond `top` are initialized with `-1` for clarity.  
- Swap requires at least **2 elements** in stack.  
