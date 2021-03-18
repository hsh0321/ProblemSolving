package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {
    static int T;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        for(int tc=1;tc<=T;tc++){
            int n,m;
            StringTokenizer st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n+1];

            for(int i=0;i<=n;i++){
                arr[i] = i;
            }

            int op,a,b;
            sb.append('#').append(tc).append(' ');
            for(int i=0;i<m;i++){
                st = new StringTokenizer(bf.readLine());
                op = Integer.parseInt(st.nextToken());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                if(op==0){
                    union(a,b);
                }else{
                    if(find(a) == find(b))sb.append(1);
                    else sb.append(0);
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static int find(int n) {
        if(n == arr[n])return n;
        return find(arr[n]);
    }

    public static void union(int n, int m) {
        int a = find(n);
        int b = find(m);
        if(a > b) arr[b] = a;
        else arr[a] = b;
    }
}
