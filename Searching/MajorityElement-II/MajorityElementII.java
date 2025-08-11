import java.util.ArrayList;
import java.util.List;

/**
 * Program to find all elements in an array that appear more than ⌊n/3⌋ times.
 * Uses a modified Boyer-Moore Voting Algorithm.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MajorityElementII {

    public static List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int candidate1 = -1, candidate2 = -1;

        // Phase 1: Find potential candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Phase 2: Verify candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > (nums.length / 3)) result.add(candidate1);
        if (count2 > (nums.length / 3)) result.add(candidate2);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        List<Integer> result = majorityElement(nums);
        System.out.println("Majority Elements (> n/3 times): " + result);
    }
}
