package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1953_탈주범검거 {
    static int[][] map;
    static int[][] visit;


    static int[] dr = {-1,0,1,0},dc = {0,1,0,-1}; // 북 동 남 서
    static final int[][] tunnel = {
            {0, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 0},
            {0, 0, 1, 1},
            {1, 0, 0, 1},
    };


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=T;t++){
            st = new StringTokenizer(bf.readLine());
            int N,M,R,C,L;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visit = new int[N][M];

            for(int i=0;i<N;i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0;j<M;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = 1;
            int time = 0;
            Queue<Point> q = new LinkedList<>();
            visit[R][C] = 1;
            q.offer(new Point(R,C));

            while(!q.isEmpty()) {
                if(time == L-1)break;
                int size = q.size();
                while(size-- > 0) {
                    Point cur = q.poll();
                    int type = map[cur.r][cur.c];
                    for (int i = 0; i < 4; i++) {
                        if (tunnel[type][i] == 0) continue;
                        int dir = tunnel[type][i];
                        Point nxt = new Point(cur.r + dr[i], cur.c + dc[i]);
                        if (nxt.r < 0 || nxt.r >= N || nxt.c < 0 || nxt.c >= M) continue;
                        if (map[nxt.r][nxt.c] == 0) continue;
                        if (visit[nxt.r][nxt.c] != 0) continue;
                        if (tunnel[map[nxt.r][nxt.c]][(i + 2) % 4] == 1) { // 파이프가 안맞음
                            visit[nxt.r][nxt.c] = visit[cur.r][cur.c] + 1;
                            q.offer(nxt);
                            answer++;
                        }
                    }
                }
                time++;
            }
            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }


    static class Point{
        int r, c;

        public Point(int x, int y) {
            this.r = x;
            this.c = y;
        }
    }
}
