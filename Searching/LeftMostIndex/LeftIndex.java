// Program to find the leftmost index of a given number in a sorted array
// Uses modified binary search for O(log n) time complexity
// Returns -1 if the number is not found
public class LeftIndex {
    public static int findLeftIndex(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int result = -1; // -1 if x is not found

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                result = mid; // store possible answer
                high = mid - 1; // search in left half
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 2, 3, 4, 5, 5, 6, 7};
        int x1 = 1;
        System.out.println("Leftmost index of " + x1 + ": " + findLeftIndex(arr1, x1)); // 0

        int[] arr2 = {10, 20, 20, 20, 20, 20, 20};
        int x2 = 20;
        System.out.println("Leftmost index of " + x2 + ": " + findLeftIndex(arr2, x2)); // 1

        int[] arr3 = {5, 7, 7, 8, 8, 10};
        int x3 = 6;
        System.out.println("Leftmost index of " + x3 + ": " + findLeftIndex(arr3, x3)); // -1 (not found)
    }
}
