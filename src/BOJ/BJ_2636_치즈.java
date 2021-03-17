package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2636_치즈 {
    static int R,C;
    static int[][] map;
    static int[][] visit;

    static int[] dx = {1,-1,0,0},dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for(int i=0;i<R;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<C;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(new Point(0,0)); // 치즈 밖 공간 찾기
        int cheeseNum = 0;
        int time = 0;
        while(true){
            time++;
            print();
            int tmp = eraseCheese();
            if(tmp > 0){
                cheeseNum = tmp;
            }else{
                break;
            }
        }
        System.out.println(time-1 + "\n" + cheeseNum);
        //print();
    }

    static int eraseCheese(){
        Queue<Point> q = new LinkedList<>();
        // 지울거 저장
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j] == 1){ // 치즈일 때
                    for(int k=0;k<4;k++){
                        if(map[i+dy[k]][j+dx[k]]==9){
                            q.offer(new Point(j,i));
                            break;
                        }
                    }
                }
            }
        }

        int num = q.size();
        while(!q.isEmpty()){
            Point cur = q.poll();
            bfs(cur); // 치즈 밖 공간 찾기
            //map[cur.y][cur.x] = 9;

        }

        return num;
    }

    static void bfs(Point src){
        Queue<Point> q = new LinkedList<>();
        q.offer(src);
        map[src.y][src.x] = 9;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                Point nxt = new Point(cur.x + dx[i], cur.y + dy[i]);
                if (nxt.x >= C || nxt.x < 0 || nxt.y >= R || nxt.y < 0) continue;
                if (map[nxt.y][nxt.x] == 1 || map[nxt.y][nxt.x] == 9) continue; // 치즈
                map[nxt.y][nxt.x] = 9;
                q.offer(nxt);
            }
        }
    }

    static void print(){
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
