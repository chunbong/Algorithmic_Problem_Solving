public class LeetCode_LongestCommonPrefix {

    // --- 내 풀이
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
    // ---

    /**
     * 코드 출처 - Leet Code
     */
    public static String longestCommonPrefix_verticalScanning(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"cir","car"}));
    }
}
