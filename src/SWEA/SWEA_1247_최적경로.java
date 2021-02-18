package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SWEA_1247_최적경로 {

    static int N, compX, compY, houseX, houseY, min = 1000;
    static Point[] customer = new Point[10];
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(in.readLine());

        for (int t = 1; t <= T; t++) {
            answer.append("#").append(t).append(" ");
            min = 1000;
            N = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine());
            compX = Integer.parseInt(st.nextToken());
            compY = Integer.parseInt(st.nextToken());
            houseX = Integer.parseInt(st.nextToken());
            houseY = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                customer[i] = new Point(x, y);
            }
            go(0, 0, compX, compY, 0);
            answer.append(min).append("\n");
        }

        System.out.print(answer);
        in.close();
    }

    private static void go(int index, int visited, int bx, int by, int result) {
        if (result >= min)
            return;
        if (index == N) {
            result += Math.abs(bx - houseX) + Math.abs(by - houseY);
            if (min > result)
                min = result;
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((visited & 1 << i) == 0) {
                go(index + 1, visited | (1 << i), customer[i].x, customer[i].y,
                        result + Math.abs(bx - customer[i].x) + Math.abs(by - customer[i].y));
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}