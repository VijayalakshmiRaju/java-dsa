public class ButterflyPattern {
    public static void printButterfly( int number )
    {
        for ( int i = 1; i <= number; i++ ) {
            for ( int j = 1; j <= 2 * number; j++ ) {
                if( j > i && j <= 2 * number - i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }

            System.out.println();
        }

        for ( int i = number; i >= 1; i-- ) {
            for ( int j = 1; j <= 2 * number; j++ ) {
                if ( j > i && j <= 2* number - i )
                    System.out.print(" ");
                else
                    System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        // Number of rows
        int n = 6;
        printButterfly(n);
    }
}
