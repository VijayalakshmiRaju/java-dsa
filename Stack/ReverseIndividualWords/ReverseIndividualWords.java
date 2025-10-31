import java.util.Stack;

public class ReverseIndividualWords {
    public static String reverseWords(String str)
    {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for ( int i = 0; i < str.length(); i++ ) {
            if ( str.charAt(i) != ' ')
                stack.push(str.charAt(i));
            else {
                while ( !stack.isEmpty() ) {
                    result.append(stack.pop());
                }

                result.append(" ");
            }
        }

        while ( !stack.isEmpty() ) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "Welcome to the club";
        String reversed = reverseWords(str);
        System.out.println(reversed);
    }
}
