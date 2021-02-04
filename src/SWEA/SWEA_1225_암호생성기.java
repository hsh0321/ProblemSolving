package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225_암호생성기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        for(int i=1;i<=10;i++){
            bf.readLine();
            Queue<Integer> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int min = Integer.MAX_VALUE;

            for(int data=0;data<8;data++){
                int tmp = Integer.parseInt(st.nextToken());
                q.offer(tmp);
                min = Math.min(min,tmp);
            }
            int sub = 0;

            int temp = min/15 - 1;
            if(min > 15){
                for(int t = 0;t<8;t++) {
                    q.offer(q.poll() - temp*15);
                }
            }

            while(q.peek() - ((sub%5) + 1) > 0){
                q.offer(q.poll() - (sub%5 + 1));
                sub++;
            }
            q.poll();
            q.offer(0);

            StringBuilder answer = new StringBuilder();
            for (Integer integer : q) {
                answer.append(integer).append(" ");
            }

            ans.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(ans);
    }
}
