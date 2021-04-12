package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_18405_경쟁적전염 {
    static int dr[] = {1,-1,0,0},dc[] = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N,K;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        ArrayList<Point> virus = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0)virus.add(new Point(map[i][j],i,j));
            }
        }

        Collections.sort(virus, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.num - o2.num;
            }
        });

        Queue<Point> q = new LinkedList<>();
        for (Point point : virus) {
            q.offer(point);
        }

        int S,X,Y;
        st = new StringTokenizer(bf.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(time == S)break;
            while(size-- != 0) {
                Point cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    Point nxt = new Point(cur.r + dr[i], cur.c + dc[i]);
                    if (nxt.r < 0 || nxt.r >= N || nxt.c < 0 || nxt.c >= N) continue;
                    if (map[nxt.r][nxt.c] != 0) continue;
                    map[nxt.r][nxt.c] = map[cur.r][cur.c];
                    q.offer(nxt);
                }
            }
            time++;
        }
        System.out.println(map[X-1][Y-1]);
    }

    static class Point{
        int num;
        int r,c;

        public Point(int num, int r, int c) {
            this.num = num;
            this.r = r;
            this.c = c;
        }

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
