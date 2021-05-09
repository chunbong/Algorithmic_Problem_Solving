import java.util.Arrays;

public class HackerRank_RepeatedString {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */
    public static long repeatedString(String s, long n) {
        long result = 0;

        int aInS = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                aInS++;
            }
        }

        long quotient = n / s.length();
        int remainder = (int) (n % s.length());

        result = quotient * aInS;

        String subString = s.substring(0, remainder);
        for (int i = 0; i < subString.length(); i++) {
            if (subString.charAt(i) == 'a') {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(repeatedString("a", 1000000000000L));
    }
}
