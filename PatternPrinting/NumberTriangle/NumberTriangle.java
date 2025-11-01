public class NumberTriangle {
    public static void printNumberTriangle(int n)
    {
        for ( int row = 1; row <= n; row++ ) {
            for (int space = 1; space <= n - row; space++)
                System.out.print(" ");

            for (int num = 1; num <= row; num++)
                System.out.print(row + " ");

            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int num = 7;
        printNumberTriangle(num);
    }
}
