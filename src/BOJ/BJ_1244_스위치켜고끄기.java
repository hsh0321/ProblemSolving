package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1244_스위치켜고끄기 {
    static int N;
    static boolean[] button;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        button = new boolean[N+1];

        StringTokenizer token = new StringTokenizer(bf.readLine());
        for(int i=1;i<=N;i++){
            button[i] = token.nextToken().equals("1") ? true : false;
        }

        int num = Integer.parseInt(bf.readLine());
        for(int i=0;i<num;i++){
            String[] s = bf.readLine().split(" ");
            if(s[0].equals("1")){
                man(Integer.parseInt(s[1]));
            }else{
                woman(Integer.parseInt(s[1]));
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i=1;i<=N;i++) {
             if (button[i]) ans.append("1 ");
             else ans.append("0 ");
             if(ans.length() % 40 == 0){
                 System.out.println(ans);
                 ans.setLength(0);
             }
        }
        System.out.print(ans);
    }

    public static void man(int num){
        int mul = num;
        for(int i=2;i<=N+1;i++){
            if(mul > N)break;
            button[mul] = !button[mul];
            mul = num*i;
        }
    }

    public static void woman(int num){
        button[num] = !button[num];
        for(int i=1;i<=N;i++){
            if(num + i > N || num - i <= 0)break;
            if(button[num + i] == button[num - i]){
                button[num + i] = !button[num + i];
                button[num - i] = !button[num - i];
            }else{
                break;
            }
        }
    }
}
