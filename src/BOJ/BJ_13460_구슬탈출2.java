package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13460_구슬탈출2 {
    static int N, M;
    static char[][] map;
    static Position red = new Position();
    static Position blue = new Position();
    static int answer = 10000;

    // 하상좌우
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public static void move(int rX, int rY, int bX, int bY, int cnt, int dir) {
        if (cnt > 10) return;
        if (cnt >= answer) return;

        boolean rGoal = false, bGoal = false;
        int nrX = rX;
        int nrY = rY;
        int nbX = bX;
        int nbY = bY;

        // 빨간공 다음 위치
        for (; ; ) {
            if (map[nrX + dx[dir]][nrY + dy[dir]] == '#') break;
            if (map[nrX + dx[dir]][nrY + dy[dir]] == 'O') {
                rGoal = true;
                break;
            }
            nrX += dx[dir];
            nrY += dy[dir];
        }

        // 파란공 다음 위치
        for (; ; ) {
            if (map[nbX + dx[dir]][nbY + dy[dir]] == '#') break;
            if (map[nbX + dx[dir]][nbY + dy[dir]] == 'O') {
                bGoal = true;
                break;
            }
            nbX += dx[dir];
            nbY += dy[dir];
        }

        if (bGoal) return;
        else {
            if (rGoal) {
                answer = Math.min(answer, cnt); // 최소값
                return;
            }
        }

        if (nrX == nbX && nrY == nbY) {
            int red_Dist = Math.abs(rX - nrX) + Math.abs(rY - nrY);
            int blue_Dist = Math.abs(bX - nbX) + Math.abs(bY - nbY);

            if (red_Dist > blue_Dist) // 빨간공이 더 많이 움직임
            {
                nrX = nrX - dx[dir];
                nrY = nrY - dy[dir];
            } else {
                nbX = nbX - dx[dir];
                nbY = nbY - dy[dir];
            }
        }

//        System.out.println(cnt);
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if(j == nrX && i== nrY) System.out.print("R");
//                else if(j == nbX && i == nbY) System.out.print("B");
//                else if(j == red.x && i == red.y) System.out.print(".");
//                else if(j == blue.y && i == blue.y) System.out.print(".");
//                else System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();


        for (int i = 0; i < 4; i++) {
            if (i == dir) continue; // 같은 방향
            int reverse_dir = 0; // 반대 방향 하상좌우

            if (dir == 0) reverse_dir = 1;
            else if (dir == 1) reverse_dir = 0;
            else if (dir == 2) reverse_dir = 3;
            else if (dir == 3) reverse_dir = 2;

            if (i == reverse_dir) continue; // 상하좌우

            move(nrX, nrY, nbX, nbY, cnt + 1, i);
        }
    }

    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s[] = bf.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s1 = bf.readLine();
            for (int j = 0; j < M; j++) {
                if (s1.charAt(j) == 'R') {  // 빨간공
                    red.x = i;
                    red.y = j;
                    map[i][j] = '.';
                } else if (s1.charAt(j) == 'B') { // 파란공
                    blue.x = i;
                    blue.y = j;
                    map[i][j] = '.';
                }else map[i][j] = s1.charAt(j);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        for(int i=0;i<4;i++) {
            move(red.x, red.y, blue.x, blue.y, 1, i);
        }

        if (answer > 10) answer = -1;
        System.out.println(answer);
    }

    public static void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Position {
    int x, y;
}