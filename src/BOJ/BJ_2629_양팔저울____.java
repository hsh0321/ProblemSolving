package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2629_양팔저울____ {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); // 추의 개수

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 추의 무게
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken()); // 토크나이제이션
        }

        int M = Integer.parseInt(bf.readLine()); // 확인하고자 하는 구슬
        st = new StringTokenizer(bf.readLine());

        boolean[][] dp = new boolean[N][40005]; // N개까지 구슬을 담을 수 있을 때 측정 가능 무게 여부 배열
        dp[0][0] = true;
        dp[0][arr[0]] = true; // 초기값
        for(int i=1;i<N;i++){ // n개의 구슬
            dp[i][arr[i]-arr[i-1]]=true; // 이전 구슬을 뺏을 때 가능
            dp[i][arr[i]] = true; // 현재 구슬만 사용



            for(int j=0;j<=40001;j++){ // 최대 무게 40000까지 체크
                if(j-arr[i] >= 0 && dp[i-1][j-arr[i]]){
                    dp[i][j] = true; // 이전 상태에서 현재 구슬 추가하는 것
                    dp[i][j-arr[i]] = true;
                }
                if(dp[i-1][j]){
                    dp[i][j] = true; // 이전 상태가 가능하면 가능
                    if(arr[i]-j>=0)dp[i][arr[i]-j]=true;
                }
            }
        }

        StringBuilder answer = new StringBuilder(); // 정답 만들기
        for(int i=0;i<M;i++){
            int w = Integer.parseInt(st.nextToken()); // 무게 입력
            if(dp[N-1][w])answer.append('Y').append(' '); // true이면 y
            else answer.append('N').append(' '); // false면 n
        }
        System.out.println(answer); // 정답 출력
    }
}
