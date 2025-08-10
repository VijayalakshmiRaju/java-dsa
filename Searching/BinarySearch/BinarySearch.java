import java.util.Scanner;
/**
 * Binary Search implementation (Iterative and Recursive)
 * Assumes the array is sorted in ascending order.
 */
public class BinarySearch {
    public static int binarySearchIterative(int[] arr, int element)
    {
        int low = 0;
        int high = arr.length - 1;
        while( low <= high )
        {
            int mid = ( low + high ) / 2;
            if ( element == arr[mid])
            {
                return mid;
            }
            else if (element > arr[mid])
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int element, int low, int high)
    {
        if (low > high )
        {
            return -1;
        }

        int mid = ( low + high ) / 2;
        if ( arr[mid] == element )
        {
            return mid;
        }
        else if ( arr[mid] > element )
        {
            return binarySearchRecursive(arr, element, low, mid-1);
        }
        else {
            return binarySearchRecursive(arr, element, mid+1, high);
        }
    }

    public static void main(String[] args)
    {
        Scanner sin  = new Scanner(System.in);

        // Input array size and elements
        System.out.print("ENTER NUMBER OF ELEMENTS: ");
        int n = sin.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " sorted integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sin.nextInt();
        }

        // Input target to search
        System.out.print("Enter target value to search: ");
        int target = sin.nextInt();

        // Iterative Search
        int resultIterative = binarySearchIterative(arr, target);
        System.out.println("\nUsing Iterative Binary Search:");
        if (resultIterative != -1)
            System.out.println("Element found at index: " + resultIterative);
        else
            System.out.println("Element not found");

        // Recursive Search
        int resultRecursive = binarySearchRecursive(arr, target, 0, arr.length - 1);
        System.out.println("\nUsing Recursive Binary Search:");
        if (resultRecursive != -1)
            System.out.println("Element found at index: " + resultRecursive);
        else
            System.out.println("Element not found");
    }
}


