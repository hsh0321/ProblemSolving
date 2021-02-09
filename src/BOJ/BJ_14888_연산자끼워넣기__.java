package BOJ;

import java.io.*;
import java.util.*;

public class BJ_14888_연산자끼워넣기__ {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int N;
    static int[] A;
    static int[] op = new int[4];
    public static void main(String[] args) throws Exception{
        // System.setIn(new FileInputStream("src/com/company/test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parse(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());;
        for(int i=0; i<N; i++) A[i] = parse(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) op[i] = parse(st.nextToken());
        dfs(1, A[0]);
        System.out.print(max + "\n" +min);
    }
    static void dfs(int idx, int sum){
        if(idx == N) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        for(int i=0; i<4; i++){
            if(op[i] == 0) continue;
            op[i]--;
            switch (i){
                case 0:
                    dfs(idx+1, sum+A[idx]);
                    break;
                case 1:
                    dfs(idx+1, sum-A[idx]);
                    break;
                case 2:
                    dfs(idx+1, sum*A[idx]);
                    break;
                case 3:
                    dfs(idx+1, sum/A[idx]);
                    break;
            }
            op[i]++;
        }
    }
    static int parse(String s) { return Integer.parseInt(s); }
}