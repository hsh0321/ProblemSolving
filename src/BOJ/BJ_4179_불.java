package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4179_불 {
    static int R,C;
    static char[][] map;
    static boolean[][] visit;

    static Queue<Point> fires = new LinkedList<>();
    static Queue<Point> q = new LinkedList<>();

    static int dx[] = {1,-1,0,0},dy[] = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];
        Point src = new Point();
        for(int i=0;i<R;i++){
            String s = bf.readLine();
            for(int j=0;j<C;j++){
                map[i][j] = s.charAt(j);
                if(s.charAt(j) == 'J')src = new Point(j,i);
                else if(s.charAt(j) == 'F') fires.offer(new Point(j,i));
            }
        }

        q.offer(src);

        int answer = 0;
        boolean flag = false;
        for(;;){
            if(flag)break;
            int size = fires.size();

            // 불 퍼짐
            for(int i=0;i<size;i++){
                Point cur = fires.poll();
                for(int j=0;j<4;j++){
                    Point nxt = new Point(cur.x + dx[j], cur.y + dy[j]);
                    if(nxt.x >= C || nxt.x < 0 || nxt.y >= R || nxt.y < 0)continue;
                    if(map[nxt.y][nxt.x] == '#' || map[nxt.y][nxt.x] == 'F')continue;
                    if(visit[nxt.y][nxt.x])continue;
                    map[nxt.y][nxt.x] = 'F';
                    visit[nxt.y][nxt.x] = true;
                    fires.offer(nxt);
                }
            }

            if(q.isEmpty()){
                answer = 0;
                break;
            }

            int size2 = q.size();
            for(int i=0;i<size2;i++){
                if(flag)break;
                Point cur = q.poll();
                //if(map[cur.y][cur.x] == 'F')continue;
                for(int j=0;j<4;j++){
                    Point nxt = new Point(cur.x+dx[j],cur.y+dy[j]);
                    if(nxt.x >= C || nxt.x < 0 || nxt.y >= R || nxt.y < 0){
                        flag = true;
                        break;
                    }
                    if(visit[nxt.y][nxt.x] || map[nxt.y][nxt.x] == 'F')continue;
                    if(map[nxt.y][nxt.x] == '#' || map[nxt.y][nxt.x] == 'J')continue; // 벽
                    visit[nxt.y][nxt.x] = true;
                    map[nxt.y][nxt.x] = 'J';
                    q.offer(nxt);
                }
            }
            answer++;
        }
        System.out.println(answer == 0 ? "IMPOSSIBLE" : answer);
    }

    static void erase(){
        for (boolean[] booleans : visit) {
            for (boolean aBoolean : booleans) {
                aBoolean = false;
            }
        }
    }

    static void print(){
        for(int i=0;i<R;i++){
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }

    static class Point{
        int x,y;

        public Point() {}

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
