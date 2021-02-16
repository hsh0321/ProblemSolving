package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_3040_백설공주일곱난쟁이 {
    static int[] arr = new int[9];
    static int[] newArr=new int[7],ans = new int[7];
    static boolean[] visit = new boolean[9];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        perm(0,0);
        Arrays.sort(ans);
        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }

    static void perm(int depth,int sum) {
        if(depth == 7){
            if(sum==100){
                ans = newArr.clone();
            }
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (visit[i])continue;
            visit[i] = true;
            newArr[depth] = arr[i];
            perm(depth+1,sum+arr[i]);
            visit[i] = false;
        }
    }
}
