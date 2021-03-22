import java.util.*;

public class Programmers_전화번호목록 {

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(new String[]{"123","456","789"});
    }
}
