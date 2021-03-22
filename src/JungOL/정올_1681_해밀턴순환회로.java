package JungOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정올_1681_해밀턴순환회로 {
    static int N;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visit;
    static int[][] map;

    public static void dfs(int src, int depth, int dist) {
        if (dist >= answer) return;

        if (depth == N - 1) {
            if (map[src][0] != 0) {
                answer = Math.min(answer, dist + map[src][0]);
            }
            return;
        }

        for (int i = 1; i < N; i++) {
            if (map[src][i] != 0 && !visit[i]) {
                visit[i] = true;
                dfs(i, depth + 1, map[src][i] + dist);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        visit = new boolean[N];

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, 0);
        System.out.println(answer);
    }
}
