package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2105_디저트카페 {
    static int test;
    static int N;
    static int[][] map;
    static boolean[] dessert;
    static boolean[][] visit;
    static int[][] move = {{1,1},{1,-1},{-1,-1},{-1,1}};
    static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        test = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc=1;tc<=test;tc++){
            N = Integer.parseInt(bf.readLine());
            map = new int[N][N];
            visit = new boolean[N][N];
            dessert = new boolean[101];
            answer = 0;
            
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    visit[i][j] = true;
                    dessert[map[i][j]] = true;
                    find(i,j,i,j,1,0);
                    // 출발점 현재지점 이동거리 방향
                    visit[i][j] = false;
                    dessert[map[i][j]] = false;
                }
            }
            if(answer != 0)sb.append('#').append(tc).append(' ').append(answer).append('\n');
            else sb.append('#').append(tc).append(' ').append(-1).append('\n');
        }
        System.out.println(sb);
    }

    private static void find(int sX, int sY, int x, int y, int cnt, int dir) {
        if(dir==4) return;
        int tx = x+ move[dir][0];
        int ty = y+ move[dir][1];
        if(tx<0 || ty<0 || tx>=N || ty>=N) return; // 범위 밖
        if(visit[tx][ty]|| dessert[map[tx][ty]]) { // 이미 방문 했거나 먹은 디저트 종류일 때
            if(tx==sX&&ty==sY)answer = Math.max(answer, cnt); // 도착지 도착
            return;
        }
        dessert[map[tx][ty]] = true;
        visit[tx][ty] = true;
        find(sX,sY,tx,ty,cnt+1,dir); // 계속 가거나
        find(sX,sY,tx,ty,cnt+1,dir+1); // 방향 틀거나
        dessert[map[tx][ty]] = false;
        visit[tx][ty] = false;
    }
}