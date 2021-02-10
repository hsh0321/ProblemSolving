import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int numOfCycle = Math.min(N, M) / 2;
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < R; i++) {
            rotate(numOfCycle);
        }

        StringBuilder sb = new StringBuilder();

        for (int[] y : map) {
            for (int x : y) {
                sb.append(x).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void rotate(int num) { // 4 * 5 , 2
        for (int s = 0; s < num; s++) {
            int up = s; // 0 , 1
            int down = N - 1 - s;
            int left = s;
            int right = M - 1 - s;

            int tmp = map[s][s];
            for (int i = left; i < right; i++){ // 위
                map[up][i] = map[up][i + 1];
            }
            for (int i = up; i < down; i++){ // 오른쪽
                map[i][right] = map[i + 1][right];
            }
            for (int i = right; i > left; i--){ // 아래
                map[down][i] = map[down][i - 1];
            }
            for (int i = down; i > up; i--){ // 왼쪽
                map[i][left] = map[i - 1][left];
            }
            map[up + 1][left] = tmp;
        }
    }
}