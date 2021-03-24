package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[][] dp = new int[N + 1][3];

        StringTokenizer st = null;
        int r, g, b;
        st = new StringTokenizer(bf.readLine());
        dp[1][0] = Integer.parseInt(st.nextToken());
        dp[1][1] = Integer.parseInt(st.nextToken());
        dp[1][2] = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            r = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            dp[i][0] = r + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = g + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = b + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    }
}
