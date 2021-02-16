package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17406_배열돌리기4 {
    static int[][] map,tmp;
    static int N,M,K;

    static int[] arr;
    static boolean[] visit;
    static int[][] command; // k {r,c,s}
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        tmp = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                tmp[i][j] = map[i][j]; // 복사
            }
        }
        command = new int[K][3];
        for(int i=0;i<K;i++){ // 회전연산
            st = new StringTokenizer(bf.readLine());
            int r,c,s;
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            //rotate(r-1,c-1,s);
            command[i][0] = r;
            command[i][1] = c;
            command[i][2] = s;

        }
        arr = new int[K];
        for(int i=0;i<K;i++){
            arr[i] = i;
        }
        visit = new boolean[K];
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int depth) {
        if (depth == K) {
            for (int i=0; i<K;i++) {
                   rotate(command[arr[i]-1][0]-1,command[arr[i]-1][1]-1,command[arr[i]-1][2]);
            }
            for(int i=0;i<N;i++){ // 최소값
                int sum = 0;
                for(int j=0;j<M;j++)
                    sum+=map[i][j];
                answer = Math.min(sum,answer);
            }
            //초기화
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    map[i][j] = tmp[i][j];
                }
            }
            return;
        }
        for (int i = 0; i < K; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void rotate(int r,int c,int s){
        for (int cycle = 1; cycle <= s; cycle++) {
            int up = r - cycle; // 0 , 1
            int down = r + cycle;
            int left = c - cycle;
            int right = c + cycle;

            int tmp = map[r-cycle][c+cycle];
            for (int i = right; i > left; i--){ // 위
                map[up][i] = map[up][i-1];
            }
            for (int i = up; i < down; i++){ // 왼쪽
                map[i][left] = map[i + 1][left];
            }
            for (int i = left; i < right; i++){ // 아래
                map[down][i] = map[down][i + 1];
            }
            for (int i = down; i > up; i--){ // 오른쪽
                map[i][right] = map[i - 1][right];
            }

            map[up+1][right] = tmp;
        }
    }
}
