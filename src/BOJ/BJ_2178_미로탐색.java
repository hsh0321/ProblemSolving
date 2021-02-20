package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178_미로탐색 {
    public static void main(String[] args) throws IOException {
        int N,M;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] visit = new int[N][M];
        for(int i=0;i<N;i++){
            String s = bf.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int[] dx = {1,-1,0,0},dy={0,0,1,-1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visit[0][0] = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0;i<4;i++){
                int[] nxt = new int[2];
                nxt[0] = cur[0] + dx[i];
                nxt[1] = cur[1] + dy[i];
                if(nxt[0] >= M || nxt[0] < 0 || nxt[1] >= N || nxt[1] < 0)continue;
                if(map[nxt[1]][nxt[0]] == 0)continue; // 벽
                if(visit[nxt[1]][nxt[0]]!=0)continue;
                visit[nxt[1]][nxt[0]] = visit[cur[1]][cur[0]]+1;
                q.offer(nxt);
            }
        }

        System.out.println(visit[N-1][M-1]);
    }
}
