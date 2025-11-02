public class PalindromeTriangle {
    public static void printPattern(int number)
    {
        for ( int i = 1; i <= number; i++ ) {
            for ( int space = 1; space <= number - i; space++ )
                System.out.print("  ");

            for ( int num = i; num >= 1; num-- )
                System.out.print(num + " ");

            for ( int num = 2; num <= i; num++ )
                System.out.print(num + " ");

            System.out.println();
        }
    }

    public static void main(String args[])
    {
        int n = 6;
        printPattern(n);
    }
}
