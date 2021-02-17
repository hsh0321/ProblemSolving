
import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int N, M, K;
    static int[] brightness;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            brightness = new int[11];
            brightness[0] = N * M;
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(bf.readLine());
                int lx, ly, rx, ry, num;
                ly = Integer.parseInt(st.nextToken());
                lx = Integer.parseInt(st.nextToken());
                ry = Integer.parseInt(st.nextToken());
                rx = Integer.parseInt(st.nextToken());
                num = Integer.parseInt(st.nextToken());
                painting(lx, ly, rx, ry, num);
            }
            int answer = 0;
            for (int i = 0; i < 11; i++) {
                answer = Math.max(brightness[i], answer);
            }
            sb.append('#').append(t).append(' ').append(answer).append('\n');
        } // end of testcase
        System.out.println(sb);
    } // end of main

    public static void painting(int lx, int ly, int rx, int ry, int num) { // 좌상 우하 명도
        boolean flag = false;
        ex:
        for (int i = ly; i <= ry; i++) {
            for (int j = lx; j <= rx; j++) {
                if (num < map[i][j]) { // 기존의 색보다 어두우면
                    flag = true;
                    break ex;
                }
            }
        }
        if (flag) return;
        for (int i = ly; i <= ry; i++) {
            for (int j = lx; j <= rx; j++) {
                if (num > map[i][j]) { // 기존의 색보다 어두우면
                    brightness[map[i][j]]--; // 기존 색 개수 -1
                    brightness[num]++; // 새로운 색 + 1
                    map[i][j] = num; // 맵
                }
            }
        }
    }
}

