package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5644_무선충전 {
    static int test_case;
    static int M,A;

    static BufferedReader bf;
    static StringTokenizer st;
    static int[] dr = {0,-1,0,1,0},dc = {0,0,1,0,-1};
    static ArrayList<Integer>[][] map = new ArrayList[10][10];
    static Point[][] loc;
    static boolean[][][] visit;
    static int[] power;

    static class Point{
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        test_case = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=1;t<=test_case;t++){
            input();
            int allSum = 0;
            for(int i=0;i<=M;i++){
                int tmp1=0,tmp2=0;
                //System.out.print(i + "초 : " + loc[i][0].r + ","+loc[i][0].c + " /// ");

                int sum = 0;
                int aNum,bNum; // 사용하는 충전기
                int tmp;
                for(int a =0;a<map[loc[i][0].r][loc[i][0].c].size();a++){
                    aNum = map[loc[i][0].r][loc[i][0].c].get(a);
                    for(int b=0;b<map[loc[i][1].r][loc[i][1].c].size();b++){
                        bNum = map[loc[i][1].r][loc[i][1].c].get(b);
                        tmp = power[aNum] + power[bNum];
                        if(aNum == bNum)tmp /= 2;
                        sum = Math.max(sum,tmp);
                    }
                }
                allSum += sum;
            }
            sb.append("#").append(t).append(" ").append(allSum).append('\n');
        }
        System.out.println(sb);
    }

    static void input() throws IOException {
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                map[i][j] = new ArrayList<>();
                map[i][j].add(0);
            }
        }

        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());

        loc = new Point[M+1][2]; // a,b의 위치 [T][0] : A, [T][1] : B
        Point aLoc = new Point(0,0);
        Point bLoc = new Point(9,9);
        st = new StringTokenizer(bf.readLine());
        loc[0][0] = new Point(0,0);
        for(int i=1;i<=M;i++){ // a 좌표
            int dir = Integer.parseInt(st.nextToken());
            aLoc.r += dr[dir];
            aLoc.c += dc[dir];
            loc[i][0] = new Point(aLoc.r,aLoc.c);
        }

        st = new StringTokenizer(bf.readLine());
        loc[0][1] = new Point(9,9);
        for(int i=1;i<=M;i++){ // a 좌표
            int dir = Integer.parseInt(st.nextToken());
            bLoc.r += dr[dir];
            bLoc.c += dc[dir];
            loc[i][1] = new Point(bLoc.r,bLoc.c);
        }
        // AP
        visit = new boolean[10][10][A+1];
        power = new int[A+1];
        for(int i=1;i<=A;i++) {
            st = new StringTokenizer(bf.readLine());
            int x,y,c,p;
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            chargeArea(i,new Point(y-1,x-1),c);
            power[i] = p;
        }
    }

    static void chargeArea(int num,Point p,int area){
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        map[p.r][p.c].add(num);
        int cnt = 0;
        while(cnt != area){
            int size = q.size();
            while(size-- != 0){
                Point cur = q.poll();
                for(int i=1;i<5;i++){
                    Point nxt = new Point(cur.r,cur.c);
                    nxt.r += dr[i];
                    nxt.c += dc[i];
                    if(nxt.r < 0 || nxt.r >= 10 || nxt.c < 0 || nxt.c >= 10)continue;
                    if(visit[nxt.r][nxt.c][num])continue;
                    visit[nxt.r][nxt.c][num] = true;
                    map[nxt.r][nxt.c].add(num); // ac추가
                    q.offer(nxt);
                }
            }
            cnt++;
        }
    }
}
