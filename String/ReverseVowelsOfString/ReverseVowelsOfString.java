public class ReverseVowelsOfString {

    public static String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] charArr = s.toCharArray();
        int left = 0;
        int right = charArr.length - 1;

        while (left < right) {
            // move left until a vowel is found
            while (left < right && vowels.indexOf(charArr[left]) == -1) {
                left++;
            }

            // move right until a vowel is found
            while (left < right && vowels.indexOf(charArr[right]) == -1) {
                right--;
            }

            // swap vowels
            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;

            left++;
            right--;
        }

        return new String(charArr);
    }

    // Main method with test cases
    public static void main(String[] args) {
        // Normal case
        System.out.println("hello → " + reverseVowels("hello")); // holle

        // Word with no vowels
        System.out.println("rhythm → " + reverseVowels("rhythm")); // rhythm

        // Word with only vowels
        System.out.println("aeiou → " + reverseVowels("aeiou")); // uoiea

        // Mixed case
        System.out.println("LeetCode → " + reverseVowels("LeetCode")); // LeotCede

        // Single character vowel
        System.out.println("a → " + reverseVowels("a")); // a

        // Single character consonant
        System.out.println("z → " + reverseVowels("z")); // z

        // Empty string
        System.out.println("\"\" → " + reverseVowels("")); // ""

        // String with spaces
        System.out.println("\" a e i o u \" → " + reverseVowels(" a e i o u ")); // " u o i e a "

        // Palindrome with vowels
        System.out.println("madam → " + reverseVowels("madam")); // madam

        // Uppercase vowels
        System.out.println("HELLO → " + reverseVowels("HELLO")); // HOLLE

        // Sentence with punctuation
        System.out.println("hEllo, World! → " + reverseVowels("hEllo, World!")); // hOlle, Werld!
    }
}
