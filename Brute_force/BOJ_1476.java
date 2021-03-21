package Brute_force;

import java.util.Scanner;

public class BOJ_1476 {

    static int E;
    static int S;
    static int M;

    public static int solution() {

        int i = 0;

        while(true) {
            if (i % 15 == E && i % 28 == S && i % 19 == M) {
                return i+1;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        E = sc.nextInt() - 1;
        S = sc.nextInt() - 1;
        M = sc.nextInt() - 1;


        System.out.println(solution());
    }
}
