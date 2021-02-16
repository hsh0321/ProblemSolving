package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SWEA_6808_규영이와인영이의카드게임 {
    static int[] A = new int[9],B = new int[9],newB = new int[9];// 규영이 인영이
    static boolean[] check,visit;
    static int win = 0,lose=0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=tc;t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            win = 0;lose = 0;
            check = new boolean[19];
            visit = new boolean[9];
            for(int i=0;i<9;i++){
                A[i] = Integer.parseInt(st.nextToken());
                check[A[i]] = true;
            }
            int idx = 0;
            for(int i=1;i<19;i++){
                if(check[i])continue;
                B[idx++] = i;
            }
            perm(0);

            sb.append("#").append(t).append(' ').append(win).append(' ').append(lose).append('\n');
        }
        System.out.println(sb);
    }
    public static void perm(int depth) {
        if (depth == 9) {
            int totalA=0,totalB=0;
            for(int i=0;i<9;i++){
                if(A[i] > newB[i])totalA += A[i] + newB[i];
                else totalB += A[i] + newB[i];
            }
            if(totalA > totalB)win++;
            else if(totalA < totalB)lose++;
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!visit[i]) {
                visit[i] = true;
                newB[depth] = B[i];
                perm(depth + 1);
                visit[i] = false;
            }
        }
    }
}
