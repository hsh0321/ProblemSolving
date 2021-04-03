package ETC;

import java.util.*;
import java.io.*;
public class Test_전원연결 {
    static int[][] map;
    static int N;
    static ArrayList<Point> list = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {1,-1,0,0},dy={0,0,1,-1}; // 우 좌 하 상
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(bf.readLine());

        for(int t=1;t<=tc;t++){
            N = Integer.parseInt(bf.readLine());
            map = new int[N][N];
            list = new ArrayList<>();

            for(int i=0; i<N;i++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1){
                        map[i][j] = 9; // 노드
                        if(i != 0 && i != N && j != 0 && j != N){
                            list.add(new Point(j,i));
                        }
                    }
                }
            }
            for(int i=0;i<list.size();i++){
                int cnt =0;
                for(int j=0;j<4;j++){
                    if(!check(list.get(i),j)){
                        cnt++;
                    }
                }
                if(cnt==4)list.remove(i);
            }
            dfs(0,0);
            //System.out.println(answer);
            sb.append('#').append(t).append(' ').append(answer).append('\n');
            answer = Integer.MAX_VALUE;
        }
        System.out.println(sb);
    }

    static void dfs(int depth,int len){
        if(depth == list.size()){
            answer = Math.min(len,answer);
            return;
        }
        int l = 0;
        for(int i=0;i<4;i++){
            if(!check(list.get(depth),i))continue;
            draw(list.get(depth),i);
            dfs(depth+1,len + l);
            erase(list.get(depth),i);
        }
    }

    static boolean check(Point n,int dir){
        Point nxt = new Point(0,0);
        for(int i=1;i<N;i++){
            nxt.x = n.x + (dx[dir]*i);
            nxt.y = n.y+ (dy[dir]*i);
            if(nxt.x >= N || nxt.x < 0 || nxt.y >= N || nxt.y < 0)break;
            if(map[nxt.y][nxt.x]!=0)return false; // 다른 노드가 있음
        }
        return true;
    }

    static int draw(Point n,int dir){
        Point nxt = new Point(0,0);
        int len = 0;
        for(int i=1;i<N;i++){
            nxt.x = n.x + (dx[dir]*i);
            nxt.y = n.y+ (dy[dir]*i);
            if(nxt.x >= N || nxt.x < 0 || nxt.y >= N || nxt.y < 0)break;
            map[nxt.y][nxt.x] = 1;
            len++;
        }

        return len;
    }

    static void erase(Point n,int dir){
        Point nxt = new Point(0,0);
        for(int i=1;i<N;i++){
            nxt.x = n.x + (dx[dir]*i);
            nxt.y = n.y+ (dy[dir]*i);
            if(nxt.x >= N || nxt.x < 0 || nxt.y >= N || nxt.y < 0)break;
            map[nxt.y][nxt.x] = 0;
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