package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3109_빵집 {

    static int R, C, ans;
    static char map[][];
    static boolean visit[][];
    static int[] dr = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++)
            map[i] = br.readLine().toCharArray();

        for (int i = 0; i < R; i++) {
            visit[i][0] = true;
            dfs(0, i);
        }

        System.out.println(ans);
    }

    private static boolean dfs(int curX, int curY) {
        if (curX == C - 1) {
            ans++;
            return true;
        }
        int nxtX = curX + 1,nxtY;
        for (int d = 0; d < 3; d++) {
            nxtY = curY + dr[d];
            if (nxtY < 0 || nxtY >= R) continue;
            if (map[nxtY][nxtX] == 'x' || visit[nxtY][nxtX]) continue;
            visit[nxtY][nxtX] = true;
            if (dfs(nxtX, nxtY)) return true;
        }
        return false;
    }
}