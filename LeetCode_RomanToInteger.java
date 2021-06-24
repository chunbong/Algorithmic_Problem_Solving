import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_RomanToInteger {

    public static int romanToInt(String s) {
        Map<Character, Integer> romanToInteger = new HashMap<>();
        romanToInteger.put('I', 1);
        romanToInteger.put('V', 5);
        romanToInteger.put('X', 10);
        romanToInteger.put('L', 50);
        romanToInteger.put('C', 100);
        romanToInteger.put('D', 500);
        romanToInteger.put('M', 1000);

        Map<Character, List<Character>> subtractionPair = new HashMap<>();
        subtractionPair.put('I', Arrays.asList('V', 'X'));
        subtractionPair.put('X', Arrays.asList('L', 'C'));
        subtractionPair.put('C', Arrays.asList('D', 'M'));

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            answer += romanToInteger.get(current);

            if (i + 1 < s.length()) {
                char after = s.charAt(i+1);

                if (subtractionPair.containsKey(current)) {

                    List<Character> subtractionList = subtractionPair.get(current);

                    if (subtractionList.contains(after)) {
                        answer += (romanToInteger.get(after) - 2 * romanToInteger.get(current));
                        i++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
