package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16973_직사각형탈출 {
    static int N,M;
    static int W, H; // 직사각형 크기
    static int sX,sY,dX,dY; // 출발지 도착지
    static int[][] map,visit;
    static int[] dx = {1,-1,0,0},dy={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visit = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(bf.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        sY = Integer.parseInt(st.nextToken());
        sX = Integer.parseInt(st.nextToken());
        dY = Integer.parseInt(st.nextToken());
        dX = Integer.parseInt(st.nextToken());

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(sX,sY));
        visit[sY][sX] = 1;
        while(!q.isEmpty()){
            Point cur = q.poll();
            if(cur.x == dX && cur.y == dY)break;
            for(int i=0;i<4;i++){
                Point nxt = new Point(cur.x + dx[i],cur.y+dy[i]);
                if(nxt.x < 1 || nxt.x + W -1 > M || nxt.y < 1 || nxt.y + H -1 > N)continue; // 범위 밖
                if(visit[nxt.y][nxt.x] != 0)continue; // 방문 체
                if(isCollision(nxt.x,nxt.y))continue; // 충돌 체크
                visit[nxt.y][nxt.x] = visit[cur.y][cur.x] + 1;
                q.offer(nxt);
            }
        }

        if(visit[dY][dX] == 0) System.out.println(-1);
        else System.out.println(visit[dY][dX]-1);
    }

    public static boolean isCollision(int x,int y){
        for(int i = y; i<y+ H; i++){
            for(int j = x; j<x+ W; j++){
                if(i > N || i < 1 || j > M || j < 1)continue;
                if(map[i][j] == 1)return true; // 직사각형 범위 안에 1이 있음
            }
        }
        return false; // 통과
    }

    public static class Point{
        int x,y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
