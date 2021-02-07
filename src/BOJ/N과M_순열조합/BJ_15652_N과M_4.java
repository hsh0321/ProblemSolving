package BOJ;

import java.util.Scanner;

public class BJ_15652_N과M_4 {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        dfs(0,0);
        System.out.println(sb);
    }

    public static void dfs(int s,int depth){
        if(depth == M){
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }
        for(int i=s;i<N;i++) {
            arr[depth] = i+1;
            dfs(s,depth+1);
            s++;
        }
    }
}
