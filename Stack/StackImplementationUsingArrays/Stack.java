public class Stack {

    int top;          // Index of the current top element
    int capacity;     // Maximum size of the stack
    int[] stackArr;   // Array that holds stack elements

    // Default constructor: creates an empty stack with capacity = 10
    public Stack() {
        this.top = -1; // stack is empty initially
        this.capacity = 10;
        this.stackArr = new int[capacity];

        // Initialize stack with -1 (optional, just for clarity)
        for (int i = 0; i < 10; i++) {
            stackArr[i] = -1;
        }
    }

    // Constructor: create stack with existing array, given capacity and size
    public Stack(int[] stackArr, int capacity, int size) {
        this.top = size - 1;  // set top to last filled element
        this.capacity = capacity;
        this.stackArr = new int[capacity];

        // Copy provided elements into stack
        for (int i = 0; i <= top; i++) {
            this.stackArr[i] = stackArr[i];
        }

        // Fill unused positions with -1 (to indicate empty)
        for (int i = top + 1; i < capacity; i++) {
            this.stackArr[i] = -1;
        }
    }

    // Check if stack is full
    public boolean isFull() {
        return this.top + 1 == capacity;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return this.top == -1;
    }

    // Push a new value onto the stack
    public boolean push(int value) {
        if (!isFull()) {
            this.stackArr[++top] = value;
            System.out.println("Pushed: " + value);
            return true;
        }
        System.out.println("Push failed: Stack is FULL!");
        return false;
    }

    // Pop (remove) the top value from stack
    public int pop() {
        if (!isEmpty()) {
            int element = this.stackArr[top];
            this.stackArr[top--] = -1; // reset popped position
            System.out.println("Popped: " + element);
            return element;
        }
        System.out.println("Pop failed: Stack is EMPTY!");
        return -1;
    }

    // Peek at the top value without removing it
    public int peek() {
        if (!isEmpty()) {
            System.out.println("Peek: " + stackArr[top]);
            return stackArr[top];
        }
        System.out.println("Peek failed: Stack is EMPTY!");
        return -1;
    }

    // Return current stack size
    public int size() {
        if (!isEmpty()) {
            return top + 1;
        }
        return 0; // better than -1 (size can't be negative)
    }

    // Display stack contents
    public void displayStack() {
        if (!isEmpty()) {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArr[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Stack is EMPTY!");
        }
    }

    // Empty the stack completely
    public void makeStackEmpty() {
        while (!isEmpty()) {
            pop();
        }
        System.out.println("Stack has been emptied!");
    }


    // Swap two elements by their indices
    public boolean swap(int index1, int index2) {
        if (index1 < 0 || index2 < 0 || index1 > top || index2 > top) {
            System.out.println("Swap failed: Invalid indices (" + index1 + ", " + index2 + ")");
            return false;
        }

        if (!isEmpty() && top + 1 >= 2) {
            int temp = stackArr[index1];
            stackArr[index1] = stackArr[index2];
            stackArr[index2] = temp;
            System.out.println("Swapped indices " + index1 + " and " + index2);
            return true;
        }

        System.out.println("Swap failed: Stack has fewer than 2 elements.");
        return false;
    }


    // Main method with test cases
    public static void main(String[] args) {
        System.out.println("=== Stack Implementation Test ===");
        Stack stack = new Stack();

        // Test push until full
        for (int i = 1; i <= 12; i++) {
            stack.push(i * 10);
        }
        stack.displayStack();

        // Test peek
        stack.peek();

        // Test pop
        stack.pop();
        stack.displayStack();

        // Test size
        System.out.println("Current size: " + stack.size());

        // Test swap valid case
        stack.swap(0, 3);
        stack.displayStack();

        // Test swap invalid index
        stack.swap(-1, 2);
        stack.swap(0, 100);

        // Empty stack completely
        stack.makeStackEmpty();
        stack.displayStack();

        // Pop and peek on empty stack
        stack.pop();
        stack.peek();

        // Test constructor with initial array
        int[] initialArr = {5, 15, 25};
        Stack stack2 = new Stack(initialArr, 5, 3);
        stack2.displayStack();
        stack2.push(35);
        stack2.displayStack();
        stack2.swap(0, 2);
        stack2.displayStack();
    }
}
