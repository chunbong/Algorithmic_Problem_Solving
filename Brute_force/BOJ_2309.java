package Brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {

    static int[] heights = new int[9];
    static int sum = 0;

    public static void solution() {

        // 결과를 오름차순으로 출력해야되기 때문에 미리 정렬
        Arrays.sort(heights);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                // 9명 난쟁이 키의 합에서 제외된 난장이들의 키를 뺐을 때 == 100 이면 7명의 난쟁이는 문제의 답이 되는 경우
                if (sum - heights[i] - heights[j] == 100) {
                    for (int k = 0; k < 9; k++) {
                        // 제외된 두명중 한명이라도 아니라면 선택된 난쟁이로, 출력함
                        if (k != i || k != j) {
                            System.out.println(heights[k]);
                        }
                    }
                    System.exit(0);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            heights[i] = sc.nextInt();
            sum += heights[i];
        }

        solution();
    }
}
