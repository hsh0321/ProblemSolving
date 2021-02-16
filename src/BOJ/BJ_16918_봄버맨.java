package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16918_봄버맨 {
    static int R, C, N; // 입력 변수
    static int[][] map; // 입력 맵
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static Queue<Bomb> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = parse(st.nextToken());
        C = parse(st.nextToken());
        N = parse(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String s = bf.readLine();
            for (int j = 0; j < C; j++) {
                if(s.charAt(j) == '.')map[i][j] = -1; // 빈 공간
                else map[i][j] = 2; // 처음 1초 지남
            }
        }

        for(int time = 1;time<N;time++){ // 1초부터 시작
            print();
            Queue<Bomb> q = new LinkedList<>();
            for(int y=0;y<R;y++){ //
                for(int x=0;x<C;x++){
                    if(map[y][x] == -1)map[y][x] = 3; // 빈공간에 폭탄 생성
                    else map[y][x]--; // 폭탄 타이머 -1
                    if(map[y][x]==0)q.offer(new Bomb(x,y)); // 시간이 0초 : 폭발 시킬 폭탄 좌표 저장
                }
            }

            while(!q.isEmpty()){ // 폭탄 폭발
                Bomb cur = q.poll();
                map[cur.y][cur.x] = -1; // 폭발 시키고 아무것도 없는 공간으로 대입
                for(int i=0;i<4;i++){
                    Bomb nxt = new Bomb(cur.x,cur.y);
                    nxt.x += dx[i];
                    nxt.y += dy[i];
                    if(nxt.x >= C || nxt.x < 0 || nxt.y >= R || nxt.y < 0)continue; // 범위 밖
                    map[nxt.y][nxt.x] = -1; // 빈 공간으로 만듬
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j]>0)sb.append('O');
                else sb.append('.');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static int parse(String s) {
        return Integer.parseInt(s);
    }

    public static void print(){
        for(int y=0;y<R;y++){
            System.out.println(Arrays.toString(map[y]));
        }
        System.out.println();
    }
}

class Bomb{
    int x,y;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
}