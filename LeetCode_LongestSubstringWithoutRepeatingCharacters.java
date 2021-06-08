public class LeetCode_LongestSubstringWithoutRepeatingCharacters {

	public static int findSubstringStartingAtIndex(String s, int index) {

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

	public static int lengthOfLongestSubstring(String s) {

		int answer = 0;

		for (int i = 0; i < s.length(); i++) {
			answer = Math.max(answer, findSubstringStartingAtIndex(s, i));
		}

        return answer;
    }

    public int lengthOfLongestSubstring_SlidingWindow(String s) {
        int[] chars = new int[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("bbbbb")); // 3
	}
}
