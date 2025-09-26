import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    // Function to convert Roman numeral to integer
    public static int romanToInteger(String roman) {
        // Map to hold Roman numeral characters and their decimal values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int totalValue = 0;   // Final result
        int prevValue = 0;    // Keeps track of the last processed value (right to left)

        // Iterate from right to left
        for (int i = roman.length() - 1; i >= 0; i--) {
            int currentValue = romanMap.get(roman.charAt(i));

            // If current value is smaller than the previous one, subtract it
            // Example: IV → I (1) is less than V (5), so subtract 1
            if (currentValue < prevValue) {
                totalValue -= currentValue;
            }
            // Otherwise, add it to total and update prevValue
            else {
                totalValue += currentValue;
                prevValue = currentValue;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        // Test cases with normal and tricky values
        String[] testCases = {
                "I",        // Smallest Roman numeral → 1
                "III",      // 3
                "IV",       // Subtractive notation → 4
                "IX",       // 9
                "LVIII",    // 58 = L(50) + V(5) + III(3)
                "MCMXCIV",  // 1994 = M(1000) + CM(900) + XC(90) + IV(4)
                "MMMCMXCIX",// 3999 (largest valid Roman numeral)
                "XL",       // 40 = 50 - 10
                "XC",       // 90 = 100 - 10
                "CD",       // 400 = 500 - 100
                "CM",       // 900 = 1000 - 100
        };

        System.out.println("=== Roman to Integer Conversion Test Cases ===");
        for (String roman : testCases) {
            int result = romanToInteger(roman);
            System.out.printf("Roman: %-10s → Integer: %d%n", roman, result);
        }
    }
}
