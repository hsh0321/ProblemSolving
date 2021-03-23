package etc;

public class DP_1 {
    static int[] dp = new int[1001];
    public static void main(String[] args) {
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        for(int i=3;i<=100;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[8]);
    }
}
