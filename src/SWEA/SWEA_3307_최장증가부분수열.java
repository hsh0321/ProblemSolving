package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3307_최장증가부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());
        int[] dp,arr;
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=tc;t++){
            int N= Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            dp = new int[N];
            arr = new int[N];
            for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());

            int max=0;
            dp[0] = 1;
            for(int i=1;i<N;i++){
                dp[i] = 1;
                for(int j=0;j<i;j++){
                    if(arr[j] < arr[i] && dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                    }
                    max = Math.max(dp[i],max);
                }
            }
            sb.append('#').append(t).append(' ').append(max).append('\n');
        }
        System.out.println(sb);
    }
}
