import java.util.*;

public class Programmers_Level1 {

    public static String solution(String[] participant, String[] completion) {

        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i <participant.length; i++) {
            try {
                if (!(participant[i].equals(completion[i]))) {
                    answer = participant[i];
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                if (answer.isEmpty()) {
                    answer = participant[i];
                }
            }
        }

        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[]{"stanko", "ana", "mislav"};

        solution(participant, completion);
    }
}
