package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2961_도영이만든맛있는음식 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        Food[] foods = new Food[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            foods[i] = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < 1 << N; i++) { // 0001 0010 0011 0100 0101 0110
            int s = 1, b = 0; // 초기값
            for (int j = 0; j < N; j++) { // 비트 한개씩 검사
                if ((i & (1 << j)) > 0) {
                    s *= foods[j].sourness;
                    b += foods[j].bitterness;
                }
            }
            int sub = Math.abs(s - b);
            answer = Math.min(answer, sub);
        }
        System.out.println(answer);
    }

    public static class Food {
        int sourness, bitterness; // 신맛 쓴맛

        public Food(int sourness, int bitterness) {
            this.sourness = sourness;
            this.bitterness = bitterness;
        }
    }
}

