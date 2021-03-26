package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14502_연구소 {

    static int N,M;
    static int[][] map,tmp;
    static int[] dx = {1,-1,0,0},dy = {0,0,1,-1};
    static Queue<int[]> virus;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        tmp = new int[N][M];

        virus = new LinkedList<>();
        int safeArea = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    virus.offer(new int[]{i,j});
                }else if(map[i][j] == 0){
                    safeArea++;
                }
            }
        }
        dfs(0,0,safeArea);
        System.out.println(answer);
    }

    static void dfs(int depth,int loc,int areaNum){
        if(depth == 3){
            int virusNum = bfs();
            answer = Math.max(answer,areaNum - virusNum);
            return;
        }
        int r,c;
        for(int i=loc;i<N*M;i++){
            r = i / M;
            c = i % M;
            if(map[r][c] != 0)continue;
            map[r][c] = 1;
            dfs(depth+1,loc+1,areaNum-1);
            map[r][c] = 0;
        }
    }

    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        for (int[] ints : virus) {
            q.offer(ints);
        }

        for(int i=0;i<N;i++)
            for(int j=0; j<M;j++)
                tmp[i][j] = map[i][j];

        int addq = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0;i<4;i++){
                int[] nxt = new int[]{cur[0] + dy[i], cur[1] + dx[i]};
                if(nxt[0] >= N || nxt[0] <0 || nxt[1] >=M || nxt[1] < 0)continue;
                if(tmp[nxt[0]][nxt[1]] != 0)continue;
                tmp[nxt[0]][nxt[1]] = 2; // 바이러스 전염
                q.offer(nxt);
                addq++;
            }
        }
        return addq;
    }
}
