package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class SWEA_1096_물놀이를가자 {
    static int N,M;
    static char[][] map = new char[1001][1001];
    static int[][] visit = new int[1001][1001];

    static int[] dx = {1,-1,0,0},dy={0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());



        StringBuilder sb = new StringBuilder();

        for(int t=1;t<=tc;t++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            Queue<Point> q = new LinkedList<>();
            for(int i=0;i<N;i++){
                String s = bf.readLine();
                for(int j=0;j<M;j++){
                    map[i][j] = s.charAt(j);
                    if(map[i][j] == 'W'){
                        q.offer(new Point(j,i));
                        visit[i][j] = 1;
                    }
                }
            }

            while(!q.isEmpty()){
                Point cur = q.poll();
                for(int i=0;i<4;i++){
                    Point nxt = new Point(cur.x+dx[i],cur.y+dy[i]);
                    if(nxt.x >= M || nxt.x < 0 || nxt.y >= N || nxt.y < 0)continue;
                    if(map[nxt.y][nxt.x] == 'W')continue;
                    if(visit[nxt.y][nxt.x] != 0)continue;
                    visit[nxt.y][nxt.x] = visit[cur.y][cur.x] + 1;
                    q.offer(nxt);
                }
            }

            int answer = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j] == 'L'){
                        answer += visit[i][j] -1;
                    }
                }
            }

            sb.append('#').append(t).append(' ').append(answer).append('\n');
            clear();
        }
        System.out.println(sb);
    }

    static void clear(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visit[i][j] = 0;
            }
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
