package BOJ;

import java.util.Scanner;

public class BJ_1463_1로만들기 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new int[N+4];
        dp[1] = 0; dp[2] = 1; dp[3] = 1;

        for(int i=4;i<=N;i++){
            dp[i] = dp[i-1] + 1;
            if(i%3 == 0) dp[i] = Math.min(dp[i/3] + 1,dp[i]);
            if(i%2 == 0) dp[i] = Math.min(dp[i/2] + 1,dp[i]);
        }
        System.out.println(dp[N]);
    }
}
