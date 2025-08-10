/**
 * Program to find the Majority Element in an array using the Boyer-Moore Voting Algorithm
 * with an additional verification step.
 * A majority element is the element that appears more than n/2 times in the array.
 * If no majority element exists, returns -1.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MajorityElement {
    public static int majorityElement(int[] arr)
    {
        int count = 0;
        int candidate = -1;

        // Phase 1: Find a candidate element
        for ( int i = 0; i < arr.length; i++ )
        {
            if ( count == 0 )
            {
                candidate = arr[i];
                count = 1;
            }
            else
            {
                if ( arr[i] == candidate )
                    count++;
                else
                    count--;
            }
        }
        count = 0;
        for (int j : arr) {
            if (j == candidate)
                count++;
        }

        if ( count > (arr.length/2))
            return candidate;
        return -1;
    }

    public static void main(String[] args)
    {
        int[] nums = {2, 2, 1, 1, 1, 3, 2};
        int result = majorityElement(nums);
        if (result != -1) {
            System.out.println("Majority Element: " + result);
        } else {
            System.out.println("No Majority Element Found");
        }
    }
}
