package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14891_톱니바퀴 {
    static String[] Wheel = new String[4];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<4;i++){
            Wheel[i] = bf.readLine();
        }

        int K = Integer.parseInt(bf.readLine());
        for(int i=0;i<K;i++){
            int num,dir;
            StringTokenizer st = new StringTokenizer(bf.readLine());
            num = Integer.parseInt(st.nextToken());
            dir = Integer.parseInt(st.nextToken());

            boolean[] check = {false,false,false,false};
            check[num-1] = true;
            dfs(check,num-1,dir);
        }
        int answer = 0;
        for(int i=0;i<4;i++){
            answer += Wheel[i].charAt(0);
        }
        System.out.println(answer);
    }

    static void dfs(boolean[] check,int n,int d){ // 2오른 6왼쪽
        if(n > 0 && Wheel[n].charAt(6) != Wheel[n-1].charAt(2)){ // 왼쪽
            String s = new String();
            if(d==1){ // 시계방향
                s = Wheel[n].charAt(7) + Wheel[n].substring(0,7);
            }else{
                s = Wheel[n].substring(1,7) + Wheel[n].charAt(0);
            }
        }
        if(n < 3 && Wheel[n].charAt(2) != Wheel[n+1].charAt(6)){ // 오른

        }
    }
}



