import java.util.*;

public class Programmers_모의고사 {

    public static int[] solution(int[] answers) {
        int[] answer = {};

        int[] firstPerson = new int[]{1, 2, 3, 4, 5};
        int[] secondPerson = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdPerson = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int firstPersonIndex = 0;
        int secondPersonIndex = 0;
        int thirdPersonIndex = 0;

        ArrayList<Integer> score = new ArrayList<>(Arrays.asList(0, 0, 0));

        for (int i = 0; i < answers.length; i++) {
            int currentAnswer = answers[i];

            firstPersonIndex = i % 5;
            if (currentAnswer == firstPerson[firstPersonIndex]) {
                score.set(0, score.get(0)+1);
            }

            secondPersonIndex = i % 8;
            if (currentAnswer == secondPerson[secondPersonIndex]) {
                score.set(1, score.get(1)+1);
            }

            thirdPersonIndex = i % 10;
            if (currentAnswer == thirdPerson[thirdPersonIndex]) {
                score.set(2, score.get(2)+1);
            }
        }

        int maxScore = Collections.max(score);
        ArrayList<Integer> tempAnswer = new ArrayList<>();

        for (int i = 0; i < score.size(); i++) {
            if (score.get(i) == maxScore) {
                tempAnswer.add(i+1);
            }
        }

        Collections.sort(tempAnswer);

        answer = new int[tempAnswer.size()];
        for(int i = 0; i < tempAnswer.size(); i++) {
            answer[i] = tempAnswer.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});
    }
}
