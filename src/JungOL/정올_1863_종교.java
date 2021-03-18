package JungOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정올_1863_종교 {
    static int n,m;
    static int[] arr;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        cnt = new int[n+1];
        for(int i=0;i<n;i++){
            arr[i] = i;
        }


        int a,b;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(bf.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        int answer = 0;
        for(int i=0;i<n;i++)if(i == arr[i])answer++;
        System.out.println(answer);
    }


    // 1 3 5 7 9

    public static int find(int n) {
        if(n == arr[n])return n;
        arr[n] = find(arr[n]);
        return arr[n];
    }

    public static void union(int n, int m) {
        int a = find(n);
        int b = find(m);
        if(a < b) arr[b] = a;
        else{
            arr[a] = b;
            if(arr[a] == arr[b])cnt[a]++;
        }
    }
}
