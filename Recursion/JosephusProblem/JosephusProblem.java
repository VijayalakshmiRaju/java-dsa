public class JosephusProblem {

    /**
     * Recursive function to find the position of the survivor in the Josephus Problem.
     *
     * @param n Number of people in the circle
     * @param k Step count — every k-th person is eliminated
     * @return The position (1-indexed) of the survivor
     */
    public static int josephus(int n, int k) {
        // Base case: when only one person remains, they are the survivor
        if (n == 1)
            return 1;

        // Recursive relation:
        // Survivor position shifts by (k - 1) each time a person is eliminated.
        // The modulo ensures we wrap around the circle.
        return (josephus(n - 1, k) + k - 1) % n + 1;
    }

    public static void main(String[] args) {
        // Test Case 1: Basic example
        int n1 = 7, k1 = 3;
        System.out.println("Survivor (n=" + n1 + ", k=" + k1 + "): " + josephus(n1, k1));
        // Expected output: 4

        // Test Case 2: Smallest circle (edge case)
        int n2 = 1, k2 = 5;
        System.out.println("Survivor (n=" + n2 + ", k=" + k2 + "): " + josephus(n2, k2));
        // Expected output: 1 (only one person)

        // Test Case 3: Two people, k = 1 (eliminate every 1st person)
        int n3 = 2, k3 = 1;
        System.out.println("Survivor (n=" + n3 + ", k=" + k3 + "): " + josephus(n3, k3));
        // Expected output: 2 (first is eliminated immediately)

        // Test Case 4: Two people, k = 2 (eliminate every 2nd person)
        int n4 = 2, k4 = 2;
        System.out.println("Survivor (n=" + n4 + ", k=" + k4 + "): " + josephus(n4, k4));
        // Expected output: 1

        // Test Case 5: Larger group, standard step size
        int n5 = 10, k5 = 3;
        System.out.println("Survivor (n=" + n5 + ", k=" + k5 + "): " + josephus(n5, k5));
        // Expected output: 4

        // Test Case 6: Large k value (k > n)
        int n6 = 5, k6 = 12;
        System.out.println("Survivor (n=" + n6 + ", k=" + k6 + "): " + josephus(n6, k6));
        // Expected output: 5 (works fine due to modulo behavior)

        // Test Case 7: Large input (performance check)
        int n7 = 20, k7 = 7;
        System.out.println("Survivor (n=" + n7 + ", k=" + k7 + "): " + josephus(n7, k7));

        // Test Case 8: Very large k (stress test)
        int n8 = 10, k8 = 1000;
        System.out.println("Survivor (n=" + n8 + ", k=" + k8 + "): " + josephus(n8, k8));
    }
}
