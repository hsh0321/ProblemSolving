package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17605_배열돌리기3 {
    static int N,M,R;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<R;i++){
            switch (Integer.parseInt(st.nextToken())){
                case 1: func1();break;
                case 2: func2();break;
                case 3: func3();break;
                case 4: func4();break;
                case 5: func5();break;
                case 6: func6();break;
            }
        }
        Queue<Integer> q= new LinkedList<>();


        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void func1(){ // 상하반전
        for(int i=0;i<N/2;i++){
            int[] tmp = map[i].clone();
            map[i] = map[N-i-1].clone();
            map[N-i-1] = tmp.clone();
        }
    }

    public static void func2(){ // 좌우반전
        for(int i=0;i<N;i++){
            for(int j=0;j<M/2;j++){
                int tmp = map[i][j];
                map[i][j] = map[i][M-j-1];
                map[i][M-j-1] = tmp;
            }
        }
    }

    public static void func3(){
        int[][] tmp = new int[M][N];
        for(int i=0;i<N;i++) {
            for (int j = 0; j < M; j++) {
                tmp[j][N - i - 1] = map[i][j];
            }
        }
        int s = M;
        M = N;
        N = s;
        map = new int[N][M];
        for(int i=0;i<N;i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp[i][j];
            }
        }
    }

    public static void func4(){
        int[][] tmp = new int[M][N];
        for(int i=0;i<N;i++) {
            for (int j = 0; j < M; j++) {
                tmp[M - j - 1][i] = map[i][j];
            }
        }
        int s = M;
        M = N;
        N = s;
        map = new int[N][M];
        for(int i=0;i<N;i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp[i][j];
            }
        }
    }

    public static void func5(){
        for(int i=0;i<N/2;i++){
            for(int j=0;j<M/2;j++){
                int tmp = map[i][j];
                map[i][j] = map[i+N/2][j];
                map[i+N/2][j] = map[i+N/2][j+M/2];
                map[i+N/2][j+M/2] = map[i][j+M/2];
                map[i][j+M/2]= tmp;
            }
        }
    }

    public static void func6(){
        for(int i=0;i<N/2;i++){
            for(int j=0;j<M/2;j++){
                int tmp = map[i][j];
                map[i][j] = map[i][j+M/2];
                map[i][j+M/2] = map[i+N/2][j+M/2];
                map[i+N/2][j+M/2] = map[i+N/2][j];
                map[i+ N/2][j]= tmp;
            }
        }
    }
}

