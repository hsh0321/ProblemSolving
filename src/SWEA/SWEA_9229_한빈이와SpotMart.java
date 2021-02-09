package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229_한빈이와SpotMart{
    static int temp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = parse(bf.readLine());
        for(int t=1;t<=tc;t++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = parse(st.nextToken()), M = parse(st.nextToken());
            st = new StringTokenizer(bf.readLine());

            int arr[] = new int[N];
            for(int i=0;i<N;i++){
                arr[i] = parse(st.nextToken());
            }
            dfs(arr,0,0,M,0);

            if(temp==0)sb.append("#").append(t).append(" ").append(-1).append('\n');
            else sb.append("#").append(t).append(" ").append(temp).append('\n');
            temp = 0;
        }
        System.out.println(sb);
    }

    public static void dfs(int[] arr,int s,int depth,int m,int weight){
        if(depth == 2){
            if(weight <= m)temp = Math.max(temp,weight);
            return;
        }
        for(int i=s;i<arr.length;i++) {
            if(arr[i] >= m)continue;
            dfs(arr, i + 1, depth + 1, m, weight + arr[i]);
        }
    }

    public static int parse(String s){
        return Integer.parseInt(s);
    }
}
