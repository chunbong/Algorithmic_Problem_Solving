
public class LeetCode_Implement_strStr {

	public static int strStr(String haystack, String needle) {
		int n = haystack.indexOf(needle);
		return n;
    }

	public static void main(String[] args) {
		System.out.println(strStr("mississippi", "pi"));
	}
}
