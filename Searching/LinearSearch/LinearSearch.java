import java.util.Scanner;

/**
 * Linear Search implementation in Java
 * Works for unsorted and sorted arrays.
 */
public class LinearSearch {

    /**
     * Time Complexity: O(n)
     * Auxiliary Space: O(1)
     */
    public static int linearSearch(int[] arr, int target)
    {
        for ( int i = 0; i < arr.length; i++ )
        {
            if ( arr[i] == target )
            {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input target
        System.out.print("Enter target value to search: ");
        int target = sc.nextInt();

        // Perform search
        int index = linearSearch(arr, target);

        // Output result
        if (index != -1)
            System.out.println("Element found at index: " + index);
        else
            System.out.println("Element not found");
    }
}
