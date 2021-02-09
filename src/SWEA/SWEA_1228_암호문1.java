package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1228_암호문1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        for(int tc=1;tc<=10;tc++) {
            int N = Integer.parseInt(bf.readLine());


            StringTokenizer st = new StringTokenizer(bf.readLine());
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(st.nextToken());
            }

            int M = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < M; i++) {
                st.nextToken();
                int x = parse(st.nextToken());
                int y = parse(st.nextToken());
                for (int j = 0; j < y; j++) {
                    list.add(x+j, st.nextToken());
                }
            }
            ans.append("#").append(tc).append(" ");
            for(int i=0;i<10;i++){
                ans.append(list.get(i)).append(' ');
            }
            ans.append('\n');
        }
        System.out.println(ans);
    }

    public static int parse(String s){
        return Integer.parseInt(s);
    }
}
