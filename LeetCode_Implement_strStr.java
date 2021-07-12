
public class LeetCode_Implement_strStr {

	public static int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}

		if (needle.length() > haystack.length()) {
			return -1;
		}

		int answer = -1;
		int needleIndex = 0;

		for (int i = 0; i < haystack.length(); i++) {
			// needleIndex가 needle의 길이와 같아지면 sub string을 찾은 것
			if (needleIndex < needle.length()) {
				// needleIndex가 needle의 길이 보다 작을 때는 haystack과 needle을 비교
				if (haystack.charAt(i) == needle.charAt(needleIndex)) { // 같은 문자라면 문자의 시작 index를 기록하고, needleIndex를 증가시키지만
					if (answer == -1) {
						answer = i;
					}
					needleIndex++;
				} else { // 같은 문자가 아니라면 answer와 needleIndex를 초기화한다
					if (answer != -1) {
						i = answer + 1;
					}
					answer = -1;
					needleIndex = 0;
				}
			}
		}

		return answer;
    }

	public static void main(String[] args) {
		System.out.println(strStr("mississippi", "issipi"));
	}
}
