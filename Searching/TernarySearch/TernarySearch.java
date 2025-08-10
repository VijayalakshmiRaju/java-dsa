import java.util.Scanner;

/**
 * Ternary Search implementation (Iterative and Recursive)
 * Works on sorted arrays (ascending order).
 */
public class TernarySearch {
    /**
     * Iterative Ternary Search
     * Time Complexity: O(log₃ n)
     * Auxiliary Space: O(1)
     */
    public static int ternarySearchIterative(int[] arr, int target)
    {
        int low = 0;
        int high = arr.length - 1;

        while ( low <= high )
        {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;

            if ( arr[mid1] == target )
            {
                return mid1;
            }
            else if ( arr[mid2] == target )
            {
                return mid2;
            }
            else if ( arr[mid1] > target )
            {
                high = mid1 - 1;
            }
            else if ( arr[mid2] < target )
            {
                low = mid2 + 1;
            }
            else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        return  -1;
    }

    /**
     * Recursive Ternary Search
     * Time Complexity: O(log₃ n)
     * Auxiliary Space: O(log₃ n) due to recursion
     */
    public static int ternarySearchRecursive(int[] arr, int target, int low, int high)
    {
        if ( low > high )
        {
            return -1;
        }

        int mid1 = low + ( high - low ) / 3;
        int mid2 = high - ( high - low ) / 3;

        if ( arr[mid1] == target )
        {
            return mid1;
        }
        else if ( arr[mid2] == target )
        {
            return mid2;
        }
        else if ( arr[mid1] > target )
        {
            return ternarySearchRecursive(arr, target, low, mid1 - 1);
        }
        else if ( arr[mid2] < target )
        {
            return ternarySearchRecursive(arr, target, mid2 + 1, high);
        }
        else {
            return ternarySearchRecursive(arr, target, mid1 + 1, mid2 - 1);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " sorted integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target value to search: ");
        int target = sc.nextInt();

        // Iterative Search
        int resultIterative = ternarySearchIterative(arr, target);
        System.out.println("\nUsing Iterative Ternary Search:");
        if (resultIterative != -1)
            System.out.println("Element found at index: " + resultIterative);
        else
            System.out.println("Element not found");

        // Recursive Search
        int resultRecursive = ternarySearchRecursive(arr, target, 0, arr.length - 1);
        System.out.println("\nUsing Recursive Ternary Search:");
        if (resultRecursive != -1)
            System.out.println("Element found at index: " + resultRecursive);
        else
            System.out.println("Element not found");
    }
}
