import java.util.Arrays;

public class Programmers_K번째수 {

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int i = 0;

        for (int[] command : commands) {
            int startIndex = command[0] - 1;
            int endIndex = command[1];
            int k = command[2] - 1;

            int[] selected = Arrays.copyOfRange(array, startIndex, endIndex);
            Arrays.sort(selected);
            answer[i] = selected[k];
            i++;
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }
}