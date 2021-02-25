import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_16954_움직이는미로탈출 {
    static char[][] map = new char[8][8];
    static boolean[][] visit = new boolean[8][8];
    static int[] dx = {-1,0,1,-1,0,1,-1,0,1},dy = {-1,-1,-1,0,0,0,1,1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //ArrayList<Point> walls = new ArrayList<>();
        for(int i=0;i<8;i++){
            String s = bf.readLine();
            for(int j=0;j<8;j++){
                map[i][j] = s.charAt(j);
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,7));
        boolean answer = false;

    ex :while(!q.isEmpty()){
            visit = new boolean[8][8]; // 횟수 줄이
            int t = q.size();
            for(int num=0;num<t;num++) { // 현재 큐에 담긴 개수만큼 시뮬레이션
                Point cur = q.poll();
                if(map[cur.y][cur.x] == '#')continue;
                if (cur.y == 0) {
                    answer = true;
                    break ex;
                }
                for (int i = 0; i < 9; i++) {
                    Point nxt = new Point(cur.x + dx[i], cur.y + dy[i]);
                    if (nxt.x >= 8 || nxt.x < 0 || nxt.y >= 8 || nxt.y < 0) continue;
                    if (map[nxt.y][nxt.x] == '#') continue; // 벽
                    if(visit[nxt.y][nxt.x]) continue;
                    q.offer(nxt);
                    visit[nxt.y][nxt.x] = true;
                }
            }
            map = moveMap(map);
        }

        if(answer) System.out.println(1);
        else System.out.println(0);
    }

    public static char[][] moveMap(char[][] map){
        char[][] newMap = new char[8][8];
        for(int j=0;j<8;j++)newMap[0][j] = '.';
        for(int i=0;i<7;i++){ // 맨아랫줄은 복사할 필요 없음
            for(int j=0;j<8;j++){
                newMap[i+1][j] = map[i][j];
            }
        }
        return newMap;
    }


    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
