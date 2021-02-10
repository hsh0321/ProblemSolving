package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576_토마토 {
    static int N,M;
    static int[][] map = new int[1001][1001];
    static int[] dx = {1,-1,0,0},dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Queue<Point> q = new LinkedList<>();
        int num = 0; // 0의 개수
        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)q.offer(new Point(j,i)); // 익은 토마토는 큐에 집어 넣음
                else if(map[i][j] == 0)num++; // 안익은 토마토의 개수
            }
        }

        int answer = 0;
        while(!q.isEmpty()){
            Point cur = q.poll();
            answer = Math.max(map[cur.y][cur.x], answer); // 최대값
            for(int i=0;i<4;i++){
                Point nxt = new Point(cur.x,cur.y); // 이동 할 위치
                nxt.x += dx[i];
                nxt.y += dy[i];
                if(nxt.x < 0 || nxt.x >= N || nxt.y < 0 || nxt.y >= M)continue; // 범위 밖
                if(map[nxt.y][nxt.x] == -1)continue; // 토마토가 들어있지 않은 칸
                if(map[nxt.y][nxt.x] > 0)continue; // 이미 방문한 곳
                map[nxt.y][nxt.x] = map[cur.y][cur.x]+1; // 이동 거리를 나타내기 위해 이전 칸의 + 1
                num--; // 익은 땅 개수 감소

                q.offer(nxt);
            }
        }
        if(num==0){ // 모두 익음
            System.out.println(answer-1); // 1부터 시작했으므로 -1해줘야함
        }else{
            System.out.println(-1); // 안익은 토마토가 남아있음
        }
    }
}

class Point{
    int x,y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}