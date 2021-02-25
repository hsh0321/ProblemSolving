package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2116_주사위쌓기 {
    static BufferedReader bf;
    static StringTokenizer st;
    static int N;
    static int[][] cube;
    static ArrayList<int[][]> list;

    public static void main(String[] args) throws IOException {
        cube = new int[2][3]; // 0 1 반대면

        bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        list = new ArrayList<>();

        st = new StringTokenizer(bf.readLine());
        cube[0][0] = Integer.parseInt(st.nextToken());// A
        cube[0][1] = Integer.parseInt(st.nextToken());// B
        cube[0][2] = Integer.parseInt(st.nextToken());// C
        cube[1][1] = Integer.parseInt(st.nextToken());// D
        cube[1][2] = Integer.parseInt(st.nextToken());// E
        cube[1][0] = Integer.parseInt(st.nextToken());// F
        int[][] start = new int[2][3];
        int answer = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start[i][j] = cube[i][j]; // 제일 아래있는 큐브
            }
        }

        for(int i=1;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            cube[0][0] = Integer.parseInt(st.nextToken());// A
            cube[0][1] = Integer.parseInt(st.nextToken());// B
            cube[0][2] = Integer.parseInt(st.nextToken());// C
            cube[1][1] = Integer.parseInt(st.nextToken());// D
            cube[1][2] = Integer.parseInt(st.nextToken());// E
            cube[1][0] = Integer.parseInt(st.nextToken());// F
            int[][] tmp = new int[2][3];
            tmp[0] = cube[0].clone();
            tmp[1] = cube[1].clone();
            list.add(tmp); // 리스트에 저장
        }

        for (int i = 1; i <= 6; i++) { // 제일 아래 주사위
            int sBottom = i; // i일 때
            int sTop=0;
            int sum=0;
            for (int k = 0; k < 2; k++) {
                for (int j = 0; j < 3; j++)
                    if (start[k][j] == sBottom) {
                        sTop = start[k ^ 1][j]; // 바닥의 반대 숫자
                        break;
                    }
            }

            for(int m=6;m>0;m--){
                if(sTop == m || sBottom == m)continue;
                else{
                    sum += m; // 젤 첫번째 주사위의 옆면의 최대 값
                    break;
                }
            }

            for (int j = 0; j < list.size(); j++) {
                //input();
                sBottom = sTop;
                int tmp = 0;
                for (int k = 0; k < 2; k++) {
                    for (int t = 0;  t< 3; t++) {
                        if (list.get(j)[k][t] == sBottom)sTop = list.get(j)[k^1][t]; // 받내면 대입
                    }
                }
                for(int m=6;m>0;m--){
                    if(sTop == m || sBottom == m)continue; // 옆면만
                    else{
                        tmp = m; // 최대값
                        break;
                    }
                }
                sum+=tmp;
            }
            //System.out.println(sum);
            answer = Math.max(answer,sum); // 최대값
            sum = 0;
        }
        System.out.println(answer);
    }
}
