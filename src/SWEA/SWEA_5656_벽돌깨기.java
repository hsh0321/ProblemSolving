package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {
    static int T;
    static int N,W,H;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        StringTokenizer st = null;
        StringBuilder answer  = new StringBuilder();

        for(int t=1;t<=T;t++){
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            ans = Integer.MAX_VALUE;

            map = new int[H][W];


            for(int i=0;i<H;i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0;j<W;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0);
            answer.append('#').append(t).append(' ').append(ans).append('\n');
        }
        System.out.println(answer);
    }

    static void dfs(int depth){
        if(depth == N){
            int cnt = 0;
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    if(map[i][j]!=0)cnt++;
                }
            }
            ans = Math.min(ans,cnt);
            return;
        }
        int[][] tmp = new int[H][W];
        copyMap(map,tmp);
        for(int i=0;i<W;i++) {
            dropBall(i);
            //print();
            dfs(depth+1);
            copyMap(tmp,map);
        }
    }

    static void copyMap(int[][] src, int[][] dst){
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                dst[i][j] = src[i][j];
            }
        }
    }

    static void dropBall(int x){
        int r = 0, c= x;
        while(map[r][c] == 0){
            r++;
            if(r>=H)return;
        }
        bomb(r,c);

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<W;i++){
            int numOfWall = 0;
            for(int j=0;j<H;j++){
                if(map[j][i] != 0)list.add(map[j][i]);
                map[j][i] = 0;
            }

            for(int j=list.size()-1;j>=0;j--){
                map[H-1-j][i] = list.get(list.size()-1-j);
            }
            list.clear();
        }

    }

    static void bomb(int r,int c){
        if(map[r][c] == 0)return; // 벽이 없는 공간
        int range = map[r][c]-1;
        map[r][c] = 0; // 벽 제거

        for(int x = c-range; x<=c+range;x++){
            if(x < 0 || x>=W || x == c)continue;
            if(map[r][x] == 0)continue;
            bomb(r,x);
        }
        for(int y= r-range; y<=r+range;y++) {
            if(y < 0 || y>=H || y == r)continue;
            if(map[y][c] == 0)continue;
            bomb(y,c);
        }
    }

    static void print(){
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
