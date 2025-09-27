public class KthFactorOfN {
    // Function to return the kth factor of 'num'
    public static int kthFactor(int num, int k) {
        // Iterate from 1 to num to find all factors
        for (int i = 1; i <= num; i++) {
            // Check if 'i' is a factor of 'num'
            if (num % i == 0) {
                k--; // Decrement k for each factor found
            }
            // If k becomes 0, we found the kth factor
            if (k == 0) {
                return i;
            }
        }

        // If fewer than k factors exist, return -1
        return -1;
    }

    // Main method to test the kthFactor function
    public static void main(String[] args) {
        int n1 = 12, k1 = 3;
        System.out.println("Input: n = " + n1 + ", k = " + k1);
        System.out.println("Output: " + kthFactor(n1, k1)); // Expected: 3

        int n2 = 7, k2 = 2;
        System.out.println("Input: n = " + n2 + ", k = " + k2);
        System.out.println("Output: " + kthFactor(n2, k2)); // Expected: 7

        int n3 = 4, k3 = 4;
        System.out.println("Input: n = " + n3 + ", k = " + k3);
        System.out.println("Output: " + kthFactor(n3, k3)); // Expected: -1
    }
}
