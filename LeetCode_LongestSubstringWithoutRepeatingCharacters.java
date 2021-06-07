public class LeetCode_LongestSubstringWithoutRepeatingCharacters {

    public int findSubstringStartingAtIndex(String s, int index) {

        int[] alphabet = new int[127];
        int alphabetIndex = -1;

        int length = 0;

        for (int i = index; i < s.length(); i++) {
            alphabetIndex = s.charAt(i) - 0;
            if (alphabet[alphabetIndex] == 0) {
                alphabet[alphabetIndex]++;
                length++;
            } else {
                break;
            }
        }

        return length;
    }

    public int lengthOfLongestSubstring(String s) {

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            answer = Math.max(answer, findSubstringStartingAtIndex(s, i));
        }

        return answer;
    }
}
