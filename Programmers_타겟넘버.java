public class Programmers_타겟넘버 {

    // i를 더할지 말지
    // sum : 지금까지 계산한 수
    public static int calc(int i, int target, int[] numbers, int sum, int answer) {

        // 끝까지 봤는데
        if (i > numbers.length-1) {
            // 구한 값이 target 과 같으면, 케이스를 하나 구한 것
            if (sum == target) {
                return answer + 1;
            }
            return answer;
        }

        // i 번째 수를 더해보자
        answer = calc(i+1, target, numbers, sum + numbers[i], answer);

        // i 번째 수를 빼보자
        answer = calc(i+1, target, numbers, sum - numbers[i], answer);

        return answer;
    }

    public static int solution(int[] numbers, int target) {
        return calc(0, target, numbers, 0, 0);
    }

    public static void main(String[] args) {
        solution(new int[]{1, 1, 1, 1, 1}, 3);
    }
}
