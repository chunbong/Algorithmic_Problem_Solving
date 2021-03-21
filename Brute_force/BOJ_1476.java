package Brute_force;

import java.util.Scanner;

public class BOJ_1476 {

    static int E;
    static int S;
    static int M;

    public static int solution() {

        int i = 1;
        int e = 0;
        int s = 0;
        int m = 0;

        while(true) {
            if (i % 15 == 0) {
                e = 15;
            } else {
                e = i % 15;
            }

            if (i % 28 == 0) {
                s = 28;
            } else {
                s = i % 28;
            }

            if (i % 19 == 0) {
                m = 19;
            } else {
                m = i % 19;
            }

            if (e == E && s == S && m == M) {
                return i;
            }

            i++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        E = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();


        System.out.println(solution());
    }
}
