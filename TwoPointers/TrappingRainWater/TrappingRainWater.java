public class TrappingRainWater {
    public static int maxWater(int[] arr)
    {
        int left = 1;
        int right = arr.length - 2;

        int leftMax = arr[left - 1];
        int rightMax = arr[right + 1];

        int result = 0;
        while ( left <= right )
        {
            if ( rightMax < leftMax ) {
                result += Math.max(0, rightMax - arr[right]);
                rightMax = Math.max(rightMax, arr[right]);
                right--;
            } else {
                result += Math.max(0, leftMax - arr[left]);
                leftMax = Math.max(leftMax, arr[left]);
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] arr = {0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2};
        System.out.println(maxWater(arr));
    }
}
