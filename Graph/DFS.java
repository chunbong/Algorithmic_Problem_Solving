package Graph;

public class DFS {

    public static int n = 10;
    public static boolean[] visit = new boolean[n];
    public static int[][] map = new int[n][n];

    public static void dfs(int i) {
        visit[i] = true;
        System.out.print(i + "");

        for (int j = 1; j < n+1; j++) {
            if (map[i][j] == 1 && !visit[j]) {
                dfs(j);
            }
        }
    }
}
