public class PascalsTriangle {
    public static void printPattern( int number )
    {
        for ( int i = 1; i <= number; i++ ) {
            for ( int space = 1; space <= number - i; space++ ) {
                System.out.print(" ");
            }

            int val = 1;
            for ( int j = 1; j <= i; j++ ) {
                System.out.print(val + " ");
                val = val * ( i - j ) / j;
            }

            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int n = 5;
        printPattern(n);
    }
}
