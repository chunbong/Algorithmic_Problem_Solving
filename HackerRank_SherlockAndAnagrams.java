import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 한 문자열의 문자를 재배열해 다른 문자를 형성할 수 있으면 두 문자열은 서로의 anagram
 * 문자열이 주어지면 하위 anagram인 하위 문자열 쌍의 수를 구하기
 *
 */
public class HackerRank_SherlockAndAnagrams {

    public static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 두 문자열의 각 알파벳 수가 동일한지 확인
    public static int checkTwoStringHaveSameNumberOfAlphabets(List<String> substringList) {

        int[][] substringListAlphabetCounting = new int[substringList.size()][26];

        for (int i = 0; i < substringList.size(); i++) {
            for (int j = 0; j < substringList.get(i).length(); j++) {
                substringListAlphabetCounting[i][(int)substringList.get(i).charAt(j)-97]++;
            }
        }

        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < substringList.size(); i++) {
            for (int j = i+1; j < substringList.size(); j++) {
                if (Arrays.equals(substringListAlphabetCounting[i], substringListAlphabetCounting[j])) {
                    pairs.add(new Pair(i, j));
                }
            }
        }

        return pairs.size();
    }

    // 해당 글자수의 하위 문자열을 뽑기
    public static int extractSubstringOfNCharacters(String s, int n) {
        List<String> substringList = new ArrayList<>();

        for (int i = 0; i <= s.length() - n; i++) {
            substringList.add(s.substring(i, i+n));
        }

        return checkTwoStringHaveSameNumberOfAlphabets(substringList);
    }

    public static int sherlockAndAnagrams(String s) {

        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            result += extractSubstringOfNCharacters(s, i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("kkkk"));
    }
}
