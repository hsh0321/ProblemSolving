package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1600_말이되고픈원숭이 {
    static int K,W,H;
    static int[][] map;
    static int[][][] visit;

    // 나이트 이동
    static int[] kx = { 2,1,-1,-2,-2,-1,1,2 }, ky = { 1,2,2,1,-1,-2,-2,-1 };
    // 일반 이동
    static int[] mx = { 1,0,-1,0 }, my = { 0,1,0,-1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visit = new int[H][W][K+1];
        for(int i=0;i<H;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<W;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());

    }

    static int bfs(){
        if(W==1 && H == 1){ // 예외
            if(map[0][0] == 1){
                return -1;
            }else{
                return 0;
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0,0));
        visit[0][0][0] = 1;
        while(!q.isEmpty()){
            Point cur = q.poll();
            Point nxt;
            for(int i=0;i<12;i++){
                if(i<4){ // 일반 이동
                    nxt = new Point(cur.x + mx[i], cur.y + my[i],cur.jump);
                }else{ // 나이트 이동
                    if(cur.jump == K)break; // 점프 전부 사용
                    nxt = new Point(cur.x + kx[i-4],cur.y + ky[i-4],cur.jump+1);
                }
                if(nxt.x >= W || nxt.x < 0 || nxt.y >= H || nxt.y < 0)continue; // 맵 밖
                if(map[nxt.y][nxt.x] == 1)continue; // 장애물
                if(visit[nxt.y][nxt.x][nxt.jump] != 0)continue; // 방문
                q.offer(nxt);
                visit[nxt.y][nxt.x][nxt.jump] = visit[cur.y][cur.x][cur.jump] + 1;
                if(nxt.x == W-1 && nxt.y == H-1){ // 도착지에 도착 했을 때
                    return visit[nxt.y][nxt.x][nxt.jump] -1;
                }
            }
        }
        return -1; // 갈 수 없는 경우
    }

    static class Point{
        int x,y,jump;

        public Point(int x, int y, int jump) {
            this.x = x;
            this.y = y;
            this.jump = jump;
        }
    }
}
