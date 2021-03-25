package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1251_하나로 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=tc;t++) {
            int N = Integer.parseInt(in.readLine());
            long[][] map = new long[N][N];
            boolean[] visited = new boolean[N];
            long[] minEdge = new long[N];

            StringTokenizer stX = new StringTokenizer(in.readLine());
            StringTokenizer stY = new StringTokenizer(in.readLine());

            int[][] list = new int[N][2];
            for(int i=0;i<N;i++){
                list[i][0] = Integer.parseInt(stX.nextToken());
                list[i][1] = Integer.parseInt(stY.nextToken());
            }
            double E = Double.parseDouble(in.readLine());

            for (int i = 0; i < N; i++) {
                long dx,dy,dist;
                for(int j=0;j<N;j++){
                    dx = Math.abs(list[i][0] - list[j][0]);
                    dy = Math.abs(list[i][1] - list[j][1]);
                    dist = (long)(Math.pow(dx,2) + Math.pow(dy,2));
                    map[i][j] = dist;
                }
                minEdge[i] = Long.MAX_VALUE;
            }

            long result = 0;
            minEdge[0] = 0;

            for (int c = 0; c < N; c++) {
                long min = Long.MAX_VALUE;
                int minLine = 0;
                for (int i = 0; i < N; i++) {
                    if (!visited[i] && min > minEdge[i]) {
                        min = minEdge[i];
                        minLine = i;
                    }
                }

                result += min;
                visited[minLine] = true;
                for (int i = 0; i < N; i++) {
                    if (!visited[i] && map[minLine][i] != 0 && minEdge[i] > map[minLine][i]) {
                        minEdge[i] = map[minLine][i];
                    }
                }
            }
            sb.append('#').append(t).append(' ').append((long)(Math.round(result*E))).append('\n');
        }
        System.out.println(sb);
    }
}
