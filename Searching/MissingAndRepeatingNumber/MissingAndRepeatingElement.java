import java.util.Arrays;

public class MissingAndRepeatingElement {

    public static int[] findMissingAndRepeatingElementUsingSorting(int[] arr)
    {
        Arrays.sort(arr);
        int n = arr.length;

        int missingNumber = -1;
        int repeatingNumber = -1;

        // If the first number isn't 1, then 1 is missing
        if ( arr[0] != 1 )
        {
            missingNumber = 1;
        }

        for (int i = 0; i < n - 1; i++ )
        {
            // Repeating: adjacent equal values after sort
            if (arr[i] == arr[i+1])
            {
                repeatingNumber = arr[i];
            }
            // Missing: a gap > 1 implies the missing number is arr[i] + 1
            else if ( arr[i+1] -  arr[i] > 1 )
            {
                missingNumber = arr[i] + 1;
            }

            if ( missingNumber != -1 && repeatingNumber != -1 )
            {
                break;
            }
        }

        // If no gap found, the missing number is N (e.g., [1,2,3,4,4])
        if ( missingNumber == 1 )
        {
            missingNumber = n;
        }

        return new int[] { missingNumber, repeatingNumber };
    }

    public static void main(String[] args)
    {
        int[] arr = { 2, 3, 2, 1, 5};
        int[] result = findMissingAndRepeatingElementUsingSorting(arr);
        System.out.println("MISSING NUMBER: " + result[0]);
        System.out.println("REPEATING NUMBER: " + result[1]);
    }
}
