package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16234_인구이동 {
    static int[][] map,visit;
    static int[][] chk; //
    static int[] dx = {1,-1,0,0},dy={0,0,1,-1};
    static int N,L,R;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visit = new int[N][N];
        chk = new int[N*N + 1][2]; // 합산 저장용

        int r,c;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(;;){
            // 국경 나누기
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(visit[i][j] == 0) {
                        bfs(new Point(j, i));
                    }
                }
            }

            // 인구 합치기
            boolean flag = false;
            for(int i=0;i<N;i++) {
                for (int j = 0; j < N; j++) {
                    if (chk[visit[i][j]][1] > 1) {
                        map[i][j] = chk[visit[i][j]][0] / chk[visit[i][j]][1];
                        flag = true; // 인구 이동이 있음
                    }
                }
            }
            if(!flag)break;

            answer++;

            clear();
            cnt = 1;
        }
        System.out.println(answer);
    }

    static void bfs(Point p){
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        visit[p.y][p.x] = cnt;
        int num = 1; // 연결 도시수
        int population = map[p.y][p.x]; // 총 인구
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i=0;i<4;i++){
                Point nxt = new Point(cur.x + dx[i],cur.y + dy[i]);
                if(nxt.x >= N || nxt.y >= N || nxt.x < 0 || nxt.y < 0)continue;
                if(visit[nxt.y][nxt.x] != 0)continue; // 이미 방문
                int sub = Math.abs(map[nxt.y][nxt.x] - map[cur.y][cur.x]);
                if(sub >= L && sub <= R){ //국경 개방
                    visit[nxt.y][nxt.x] = cnt;
                    population += map[nxt.y][nxt.x];
                    q.offer(nxt);
                    num++;
                }
            }
        }
        chk[cnt][0] = population; // 인구
        chk[cnt][1] = num; // 나라 수
        cnt++;
    }

    static void clear(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                visit[i][j] = 0;
            }
        }

        for(int i=1;i<cnt;i++){
            chk[i][0]=0;
            chk[i][1]=0;
        }
    }

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
