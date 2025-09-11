public class ChocolateDistribution {

    public static int distributeChocolate(int numOfFriends, int numOfChocolates) {
        // Edge case: if there are no chocolates, we must make 'numOfFriends' chocolates
        // because each friend needs at least one.
        if (numOfChocolates <= 0)
            return numOfFriends;

        // If chocolates are fewer than friends, we must make enough
        // so that everyone gets at least 1.
        if (numOfChocolates < numOfFriends)
            return numOfFriends - numOfChocolates;

        // Find remainder when dividing chocolates among friends
        int balance = numOfChocolates % numOfFriends;

        // If no remainder, chocolates are already evenly distributable
        if (balance == 0)
            return 0;

        // Option 1: Destroy 'balance' chocolates so it becomes divisible
        int chocolatesToDestroy = balance;

        // Option 2: Make extra chocolates until divisible
        int chocolatesToMake = numOfFriends - balance;

        // Choose minimum time (minimum chocolates to add/destroy)
        return Math.min(chocolatesToDestroy, chocolatesToMake);
    }

    public static void main(String[] args) {
        // Test all scenarios including edge cases
        int[][] testCases = {
                {4, 10}, // Example from problem statement -> Expected: 2
                {3, 2},  // Need to make 1 chocolate -> Expected: 1
                {3, 3},  // Already divisible -> Expected: 0
                {3, 0},  // No chocolates, must make 3 -> Expected: 3
                {5, 1},  // Make 4 chocolates -> Expected: 4
                {5, 9},  // balance=4 -> destroy 4 or add 1 -> Expected: 1 (add is cheaper)
                {5, 11}, // balance=1 -> destroy 1 or add 4 -> Expected: 1 (destroy is cheaper)
                {5, 15}, // Already divisible -> Expected: 0
                {1, 0},  // Only one friend, make 1 chocolate -> Expected: 1
                {1, 7}   // One friend, 7 chocolates -> can destroy 6 -> Expected: 0 (already divisible by 1)
        };

        for (int[] test : testCases) {
            int numOfFriends = test[0];
            int numOfChocolates = test[1];
            int result = distributeChocolate(numOfFriends, numOfChocolates);

            System.out.println("Friends: " + numOfFriends +
                    ", Chocolates: " + numOfChocolates +
                    " -> Minimum time: " + result + " sec");
        }
    }
}
