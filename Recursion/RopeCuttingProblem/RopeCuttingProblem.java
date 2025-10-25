public class RopeCuttingProblem {
    public static int maximumCut(int n, int a, int b, int c)
    {
        if ( n == 0 )
            return 0;

        if ( n <= -1 )
            return -1;

        int result = Math.max(maximumCut(n-a, a, b, c), Math.max(maximumCut(n-b, a, b, c), maximumCut(n-c, a, b, c)));
        if (result == -1)
            return -1;

        return result + 1;
    }

    public static void main(String[] args)
    {
        int n = 17, a = 10, b = 11, c = 3;
        System.out.println(maximumCut(n, a, b, c));
    }
}
