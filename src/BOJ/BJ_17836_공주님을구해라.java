package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17836_공주님을구해라 {
    static int[][] map,visit;
    static int N,M,T;
    static int[] dx= {1,-1,0,0},dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = parse(st.nextToken());
        M = parse(st.nextToken());
        T = parse(st.nextToken());

        map = new int[N][M];
        visit = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = parse(st.nextToken());
            }
        }

        Queue<Hero> q = new LinkedList<>();
        visit[0][0] = 1;
        Hero sword = new Hero(-1,-1);
        int swordDist = 0;

        q.offer(new Hero(0,0)); // 시작

        if(map[0][0] == 2){ // 시작위치에 검이 있을 때
            int dist = N-1 + M-1;
            if(dist > T) System.out.println("Fail");
            else System.out.println(dist);
            return;
        }else {
            while (!q.isEmpty()) {
                Hero cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    Hero nxt = new Hero(cur.x + dx[i], cur.y + dy[i]);
                    if (nxt.x >= M || nxt.x < 0 || nxt.y >= N || nxt.y < 0) continue; // 맵 밖
                    if (map[nxt.y][nxt.x] == 1) continue; // 벽이면 못지나감
                    if (visit[nxt.y][nxt.x] != 0) continue; // 이미 왔던 곳
                    visit[nxt.y][nxt.x] = visit[cur.y][cur.x] + 1;
                    if (map[nxt.y][nxt.x] == 2) { // 검이 있는 곳
                        sword.x = nxt.x;
                        sword.y = nxt.y;
                        swordDist = visit[nxt.y][nxt.x] - 1;
                    }
                    q.offer(nxt);
                }
            }
            swordDist += (N - 1 - sword.y) + (M - 1 - sword.x);
        }
        if(sword.x == -1){ // 검까지 갈 수 없음
            if(visit[N-1][M-1]==0 || visit[N-1][M-1]-1 > T) System.out.println("Fail"); // 갈 수 없음
            else {
                System.out.println(visit[N - 1][M - 1] - 1); // 일반 경로
            }
        }else{ // 검을 사용해서 가거나 그냥 도착지에 가거나
            int dist;
            if(visit[N-1][M-1] == 0){ // 검을 이용하는데
                dist = swordDist;
            }else {
                dist = Math.min(visit[N - 1][M - 1] - 1, swordDist);
            }
            if(dist > T) System.out.println("Fail"); // 제한시간보다 오래 걸림
            else System.out.println(dist);
        }
    }

    public static int parse(String s){
        return Integer.parseInt(s);
    }
}

class Hero{
    int x,y;

    public Hero(int x, int y) {
        this.x = x;
        this.y = y;
    }
}