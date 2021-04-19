package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_17471_게리맨더링 {
    static int N;
    static int[] population;
    static int[][] map;
    static int parents[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        population = new int[N+1];
        map = new int[N+1][N+1];


        for(int i=1;i<=N;i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;i<Integer.parseInt(st.nextToken());j++){
                int dst = Integer.parseInt(st.nextToken());
                map[i][dst] = 1;
            }
        }

        for(int i=1;i<1<<N;i++){
            for(int j=0;j<N;j++){
                if((i & (1<<j)) > 0){

                }
            }
        }
    }

    static void make() {// 크기가 1인 단위집합을 만든다.
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int a) {
        if(parents[a]==a) return a;
        return parents[a] = findSet(parents[a]); // path compression 후
    }

    static boolean union(int a,int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }
}
