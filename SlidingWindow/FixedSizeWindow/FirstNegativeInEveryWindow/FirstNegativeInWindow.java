import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FirstNegativeInWindow {

    /**
     * Returns a list containing the first negative integer
     * in every window of size k.
     * If a window has no negative number, 0 is added.
     */
    static List<Integer> firstNegInt(int arr[], int k) {

        // Left and right pointers for sliding window
        int i = 0, j = 0;

        // Stores the result
        List<Integer> answer = new ArrayList<>();

        // Deque to store negative numbers in the current window
        Deque<Integer> dq = new ArrayDeque<>();

        while (j < arr.length) {

            // Step 1: Add current element to deque if it is negative
            if (arr[j] < 0) {
                dq.addLast(arr[j]);
            }

            // Step 2: If window size is less than k, just expand window
            if (j - i + 1 < k) {
                j++;
            }
            else {
                // Step 3: Window size is exactly k

                // If no negative number exists in the window
                if (dq.isEmpty()) {
                    answer.add(0);
                }
                // First negative number is at the front of deque
                else {
                    answer.add(dq.peekFirst());
                }

                // Step 4: Remove the element going out of the window
                // If it is the same as the front of deque
                if (!dq.isEmpty() && arr[i] == dq.peekFirst()) {
                    dq.pollFirst();
                }

                // Slide the window
                i++;
                j++;
            }
        }

        return answer;
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        // Test Case 1
        int[] arr1 = {-8, 2, 3, -6, 10};
        int k1 = 2;
        System.out.println("Output 1: " + firstNegInt(arr1, k1));
        // Expected: [-8, 0, -6, -6]

        // Test Case 2
        int[] arr2 = {12, -1, -7, 8, -15, 30, 16, 28};
        int k2 = 3;
        System.out.println("Output 2: " + firstNegInt(arr2, k2));
        // Expected: [-1, -1, -7, -15, -15, 0]

        // Test Case 3 (No negative numbers)
        int[] arr3 = {12, 1, 3, 5};
        int k3 = 3;
        System.out.println("Output 3: " + firstNegInt(arr3, k3));
        // Expected: [0, 0]

        // Test Case 4 (All negative numbers)
        int[] arr4 = {-1, -2, -3, -4};
        int k4 = 2;
        System.out.println("Output 4: " + firstNegInt(arr4, k4));
        // Expected: [-1, -2, -3]

        // Test Case 5 (k = 1)
        int[] arr5 = {4, -5, 6, -7};
        int k5 = 1;
        System.out.println("Output 5: " + firstNegInt(arr5, k5));
        // Expected: [0, -5, 0, -7]
    }
}
