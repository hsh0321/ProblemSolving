package BOJ;

import java.io.*;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_17299_오등큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());

        int arr[] = new int[N];
        int cnt[] = new int[1000001];
        int ans[] = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int tmp;
        for(int i=0;i<N;i++){
            tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            cnt[tmp]++;
        }

        Stack<Integer> s = new Stack<Integer>();

        s.push(0);
        for (int i = 0; i < N; i++) {
            while (!s.isEmpty() && cnt[arr[i]] > cnt[arr[s.peek()]]) {
                ans[s.pop()] = arr[i];
            }
            s.push(i);
        }

        //bw.write("a");
        for(int i=0;i<N;i++){
            if(ans[i] == 0) bw.write("-1");
            else bw.write(Integer.toString(ans[i]));
            bw.write(" ");
        }

        bw.close();
        bf.close();
    }
}
