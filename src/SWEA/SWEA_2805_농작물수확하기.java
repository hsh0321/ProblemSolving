package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class SWEA_2805_농작물수확하기 {

    static int map[][] = new int[50][50];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for(int i=1;i<=t;i++) {
            int size = Integer.parseInt(bf.readLine());


            for (int j = 0; j < size; j++) {
                String s = bf.readLine();
                for (int k = 0; k < size; k++) {
                    map[j][k] = s.charAt(k) - '0';
                }
            }

            int answer = 0;
            for (int row = 0; row < size; row++) {
                int start = size / 2;
                for (int col = 0; col <= row%(size / 2); col++) {
                    if (col == 0) answer += map[row][start + col];
                    else answer += map[row][start + col] + map[row][start - col];
                }
            }

            for (int mid = 0; mid < size; mid++) {
                answer += map[size / 2][mid];
            }

            answer -= map[size / 2][size / 2];
            System.out.println("#"+i+" "+answer);
            //sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        //System.out.println(sb);
        bf.close();
    }
}
