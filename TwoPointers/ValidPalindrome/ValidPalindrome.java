public class ValidPalindrome {
    public static boolean isPalindrome( String s )
    {
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < s.length(); i++ ) {
            if ( (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                sb.append(s.charAt(i));
            } else if ( s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' ) {
                char lowerCase = (char)(s.charAt(i) + 32);
                sb.append(lowerCase);
            }
        }

        String cleanedString = sb.toString();
        int left = 0;
        int right = cleanedString.length() - 1;

        while ( left < right ) {
            if ( cleanedString.charAt(left) != cleanedString.charAt(right) ) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
