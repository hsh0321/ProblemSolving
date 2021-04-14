package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_14890_활주로 {
    static int N,X;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());
        for(int t=1;t<=T;t++){
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            map = new int[N][N];

            for(int i=0;i<N;i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for(int i=0;i<N;i++){
                if(makeLoad(i,0,0))cnt++;
                if(makeLoad(0,i,1))cnt++;
            }
            sb.append('#').append(t).append(' ').append(cnt).append('\n');
        }
        System.out.println(sb);
    }

    static boolean makeLoad(int r,int c,int dir){
        boolean[] visited = new boolean[N]; // 경사로
        int[] tmp = new int[N]; // 임시저장

        for (int i = 0; i < N; i++) {
            tmp[i] = (dir == 0) ? map[r][c + i] : map[r + i][c];
        }

        for (int i = 0; i < N - 1; i++) {
            if (tmp[i] == tmp[i + 1]) { // 같은 높이
                continue;
            }

            if (Math.abs(tmp[i] - tmp[i + 1]) > 1) { // 높이 차 1초과
                return false;
            }

            // 경사로 둘 수 있는
            if (tmp[i] - 1 == tmp[i + 1]) {
                for (int j = i + 1; j <= i + X; j++) {
                    if (j >= N || visited[j] || tmp[j] != tmp[i + 1]) {
                        return false;
                    }
                    visited[j] = true;
                }
            } else if (tmp[i] + 1 == tmp[i + 1]) {
                for (int j = i; j > i - X; j--) {
                    if (j < 0 || visited[j] || tmp[j] != tmp[i]) {
                        return false;
                    }
                    visited[j] = true;
                }
            }

        }
        return true;
    }
}
