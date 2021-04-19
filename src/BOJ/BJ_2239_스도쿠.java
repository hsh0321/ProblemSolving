package BOJ;

import java.io.*;
import java.util.*;

public class BJ_2239_스도쿠 {
    static int[][] sudoku = new int[9][9];
    static ArrayList<int[]> empty = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = s.charAt(j) - '0';
                if (sudoku[i][j] == 0) empty.add(new int[]{i, j});
            }
        }
        dfs(0);
    }

    static void dfs(int index) {
        if (index == empty.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) sb.append(sudoku[i][j]);
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        int[] now = empty.get(index);
        for (int i = 1; i <= 9; i++) {
            if (check(now[0], now[1], i)) {
                sudoku[now[0]][now[1]] = i;
                dfs(index + 1);
                sudoku[now[0]][now[1]] = 0;
            }
        }
    }

    static boolean check(int x, int y, int val) {
        // 가로세로 검사
        for (int i = 0; i < 9; i++) {
            if (sudoku[x][i] == val) return false;
            if (sudoku[i][y] == val) return false;
        }

        // 3x3 검사
        int sx = (x/3) * 3;
        int sy = (y/3) * 3;
        for (int i = sx; i < sx+3; i++) {
            for (int j = sy; j < sy+3; j++) {
                if (sudoku[i][j] == val) return false;
            }
        }

        return true;
    }
}