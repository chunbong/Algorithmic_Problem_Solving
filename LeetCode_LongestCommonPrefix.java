public class LeetCode_LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        StringBuilder sb = new StringBuilder();
        int i = 0;
        char ch;
        String firstString = strs[0];
        while(true) {
            boolean isAllEquals = true;

            if (i >= firstString.length()) {
                break;
            }
            ch = firstString.charAt(i);

            for(int j = 1; j < strs.length; j++) {
                String current = strs[j];
                if (i < current.length()) {
                    char curCh = current.charAt(i);
                    if (curCh != ch) {
                        isAllEquals = false;
                        break;
                    }
                } else {
                    isAllEquals = false;
                    break;
                }
            }

            if (isAllEquals) {
                sb.append(ch);
                i++;
            } else {
                break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"cir","car"}));
    }
}
