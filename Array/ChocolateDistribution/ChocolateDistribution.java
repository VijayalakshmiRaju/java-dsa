public class ChocolateDistribution {
    public static int distributeChocolate(int numOfFriends, int numOfChocolates)
    {
        if ( numOfChocolates <= 0 )
            return numOfFriends;

        if ( numOfChocolates < numOfFriends )
            return numOfFriends - numOfChocolates;

        int balance = numOfChocolates % numOfFriends; // We can destroy the remaining chocolates
        int chocolatesToPrepare = numOfFriends - balance; // We can make chocolates in order to evenly distribute the chocolates to the friends

        return Math.min(balance, chocolatesToPrepare);
    }
}
