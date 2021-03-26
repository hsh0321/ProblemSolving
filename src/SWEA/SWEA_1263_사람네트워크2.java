package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1263_사람네트워크2 {
    static int tc;
    static int[][] graph;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(bf.readLine());

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=tc;t++){
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            graph = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                    if(graph[i][j] == 0)graph[i][j] = INF;
                }
            }

            for(int k=0; k<N; ++k) {
                for(int i=0; i<N; ++i) {
                    if(i==k) continue; // 출발지와 경유지가 같다면 다음 출발지
                    for(int j=0; j<N; ++j) {
                        if(i==j || k==j) continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
                        if(graph[i][k]!= INF && graph[k][j] != INF && graph[i][j] > graph[i][k]+graph[k][j]) {
                            graph[i][j] = graph[i][k]+graph[k][j];
                        }
                    }
                }
            }

            int minCC = INF;
            for(int i=0;i<N;i++){
                int sum = 0;
                for(int j=0;j<N;j++){
                    if(i==j)continue;
                    sum += graph[i][j];
                }
                minCC = Math.min(minCC,sum);
            }
            sb.append('#').append(t).append(' ').append(minCC).append('\n');
        }
        System.out.println(sb);
    }
}
