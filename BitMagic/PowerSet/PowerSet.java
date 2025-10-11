import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void generatePowerSet(int[] arr)
    {
        int n = arr.length;
        int totalSubsets = 1 << n;

        for ( int i = 0; i < totalSubsets; i++ ) {
            List<Integer> subset = new ArrayList<>();
            for ( int j = 0; j < n; j++ ) {
                if ( (i & (1 << j)) != 0 )
                    subset.add(arr[j]);
            }
            System.out.println(subset);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        generatePowerSet(arr);
    }
}
