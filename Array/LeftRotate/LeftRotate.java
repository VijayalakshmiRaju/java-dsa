import java.util.Arrays;

public class LeftRotate {
    public static void leftRotate(int[] arr)
    {
        int temp = arr[0];
        for ( int i = 1; i < arr.length; i++ ) {
            arr[i-1] = arr[i];
        }

        arr[arr.length-1] = temp;
    }

    public static void leftRotateNaive(int[] arr, int k)
    {
        for ( int i = 0; i < k; i++ ) {
            leftRotate(arr);
        }
    }

    public static void leftRotateOptimized( int[] arr, int k )
    {
        int n = arr.length;
        int[] temp = new int[k];
        for ( int i = 0; i < k; i++ ) {
            temp[i] = arr[i];
        }

        for ( int i = k; i < n; i++ ) {
            arr[i - k] = arr[i];
        }

        for ( int i = 0; i < k; i++ ) {
            arr[n - k + i] = temp[i];
        }
    }

    public static void main(String[] args)
    {
        System.out.println("====================================");
        int[] arr = {1,2,3,4,5};
        System.out.println("BEFORE ROTATING");
        System.out.println(Arrays.toString(arr));
        int k = 3;
        leftRotateNaive(arr, 3);
        System.out.println("AFTER ROTATING");
        System.out.println(Arrays.toString(arr));
        System.out.println("====================================");

        int[] arr1 = {1,2,3,4,5};
        System.out.println("BEFORE ROTATING");
        System.out.println(Arrays.toString(arr1));
        leftRotateOptimized(arr1, 3);
        System.out.println("AFTER ROTATING");
        System.out.println(Arrays.toString(arr1));
        System.out.println("====================================");
    }
}
