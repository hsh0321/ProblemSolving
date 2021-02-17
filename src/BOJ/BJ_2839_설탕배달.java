package BOJ;

import java.util.Scanner;

public class BJ_2839_설탕배달 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        // 5 10 15 20 25 나머지 0
        // 6 11 16 21 26 나머지 1
        // 7 12 17 22 25 나머지 2
        // 8 13 18 23 28 나머지 3
        // 9 14 19 24 29 나머지 4

        if (N == 4 || N == 7) {
            System.out.println(-1);
        }
        else if (N % 5 == 0) { // 5로 나누어 떨어질 때
            System.out.println(N / 5);
        }
        else if (N % 5 == 1 || N % 5 == 3) {
            System.out.println((N / 5) + 1);
        }
        else if (N % 5 == 2 || N % 5 == 4) {
            System.out.println((N / 5) + 2);
        }
    }
}
