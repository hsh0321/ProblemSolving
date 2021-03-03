package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3190_뱀 {
    static int N,K,L;
    static int[][] map; // 뱀은 1 과일은 2
    static Deque<Point> snake;
    static Queue<Move> moves = new LinkedList<>();

    static int[][] d = {{0,-1},{1,0},{0,1},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        K = Integer.parseInt(bf.readLine());

        map = new int[N+1][N+1];
        StringTokenizer st;
        for(int i=0;i<K;i++){
            st = new StringTokenizer(bf.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
        }

        L = Integer.parseInt(bf.readLine());
        snake = new LinkedList<>();
        snake.offer(new Point(1,1));

        for(int i=0;i<L;i++){
            int X; // 시간
            char C; // 방향
            st = new StringTokenizer(bf.readLine());
            X = Integer.parseInt(st.nextToken());
            C = st.nextToken().charAt(0);
            moves.offer(new Move(X, C));
        }

        int time = 0;
        int dir = 1; // 0 상 1 우 2 하 3 좌
        map[1][1] = 1; // 초기위치
        while(true){
            //System.out.println(time);
            time++;
            Point nxt = new Point(snake.getFirst().x,snake.getFirst().y);
            nxt = next(nxt,dir);
            if(nxt.x > N || nxt.y > N || nxt.x <= 0 || nxt.y <= 0)break; // 맵밖
            if(map[nxt.y][nxt.x] == 1)break; // 자기 몸과 부딪힘

            snake.addFirst(new Point(nxt.x,nxt.y)); // 몸이 늘어남

            if(map[nxt.y][nxt.x] == 0){ // 사과가 아닐 때
                Point tail = snake.pollLast(); // 꼬리부분 없앰
                map[tail.y][tail.x] = 0;
            }
            map[nxt.y][nxt.x] = 1;

            if(!moves.isEmpty() && time == moves.peek().time){
                dir = changeDir(dir,moves.peek().dir);
                moves.poll();
            }
        }
        System.out.println(time);
    }

    static Point next(Point cur,int dir){
        Point nxt = new Point(cur.x,cur.y);
        nxt.x += d[dir][0];
        nxt.y += d[dir][1];
        return nxt;
    }

    static int changeDir(int i,char dir){
        int newDir=i;
        switch (i){
            case 0:
                if(dir == 'L')newDir=3;
                else newDir=1;
                break;
            case 1:
                if(dir == 'L')newDir=0;
                else newDir=2;
                break;
            case 2:
                if(dir == 'L')newDir=1;
                else newDir=3;
                break;
            case 3:
                if(dir == 'L')newDir=2;
                else newDir=0;
                break;
        }
        return newDir;
    }

    static class Point {
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Move{
        int time;
        char dir;
        public Move(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }
}


