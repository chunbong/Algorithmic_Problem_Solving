public class LeetCode_FindTheTownJudge {

    public static int findJudge(int n, int[][] trust) {

        // 나가는 간선의 갯수를 체크
        int[] outDegreeCounting = new int[n+1];
        // 진입하는 간선의 갯수를 체크
        int[] inDegreeCounting = new int[n+1];

        // trust를 반복하면서 나가는 간선의 수를 증가
        for (int[] pair : trust) {
            outDegreeCounting[pair[0]]++;
            inDegreeCounting[pair[1]]++;
        }

        int zeroCounting = 0;
        int answer = -1;
        for (int i = 1; i <= n; i++) {
            if (outDegreeCounting[i] == 0) {
                if (inDegreeCounting[i] == n-1) {
                    answer = i;
                    zeroCounting++;
                    if (zeroCounting > 1) {
                        return -1;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(findJudge(3, new int[][]{{1,2}}));
    }
}
