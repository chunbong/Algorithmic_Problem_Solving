package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static int n = 10;
    public static boolean[] visit = new boolean[n];
    public static int[][] map = new int[n][n];

    public static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visit[i] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();
            System.out.print(temp + " ");

            for (int j = 1; j < n+1; j++) {
                if (map[temp][j] == 1 && !visit[j]) {
                    q.offer(j);
                    visit[j] = true;
                }
            }
        }
    }
}
