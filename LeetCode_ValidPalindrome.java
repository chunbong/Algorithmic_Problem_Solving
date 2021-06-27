public class LeetCode_ValidPalindrome {

    public static boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= 'A' && cur <= 'Z') {
                sb.append(Character.toString(cur).toLowerCase());
            }
            if (cur >= 'a' && cur <= 'z') {
                sb.append(cur);
            }
            if (cur >= '0' && cur <= '9') {
                sb.append(cur);
            }
        }

        String origin = sb.toString();
        if (origin.equals(sb.reverse().toString())) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }
}
