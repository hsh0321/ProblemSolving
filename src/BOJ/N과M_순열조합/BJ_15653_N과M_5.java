package BOJ.N과M_순열조합;

import java.io.*;
import java.util.*;

public class BJ_15653_N과M_5 {
    static int[] arr;
    static boolean[] visit;
    static int[] out;
    static int N,M;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder(bf.readLine());
            N = sb.charAt(0) - '0';
            M = sb.charAt(2) - '0';

            arr = new int[N];
            visit = new boolean[N];
            out = new int[M];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            dfs(0,0);
            System.out.println(answer);
    }

    public static void dfs(int s1,int depth){
        if(depth == M){
            for (int i : out) {
                answer.append(i).append(' ');
                
            }
            answer.append('\n');
            return;
        }
        for(int i=0;i<N;i++){
            if(visit[i])continue;
            out[depth] = arr[i];
            visit[i] = true;
            dfs(i+1,depth+1);
            visit[i] = false;
        }
    }
}
