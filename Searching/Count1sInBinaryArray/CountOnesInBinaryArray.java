public class CountOnesInBinaryArray {

    // Function to count number of 1's in sorted binary array
    public static int countOnes(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int lastOneIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == 1) {
                lastOneIndex = mid;   // store the index
                low = mid + 1;        // move right
            } else {
                high = mid - 1;       // move left
            }
        }

        // If no 1 is found, return 0
        return lastOneIndex + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1, 1, 1, 0, 0, 0};
        int[] arr2 = {1, 1, 1, 1, 1, 1, 1};
        int[] arr3 = {0, 0, 0, 0};

        System.out.println("Count of 1's: " + countOnes(arr1)); // 5
        System.out.println("Count of 1's: " + countOnes(arr2)); // 7
        System.out.println("Count of 1's: " + countOnes(arr3)); // 0
    }
}
