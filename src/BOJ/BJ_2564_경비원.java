package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2564_경비원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(br.readLine());
        int[] store = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if(dir == 1){
                store[i] = value;
            }else if(dir == 2){
                store[i] = 2 * n + m - value;
            }else if(dir == 3){
                store[i] = 2 * (n + m) - value;
            }else{
                store[i] = n + value;
            }
        }

        int sum = 0;
        for (int i = 0; i < num; i++) {
            int temp = Math.abs(store[num] - store[i]);
            sum += (temp > (n + m)) ? 2 * (n + m) - temp : temp;
        }
        System.out.println(sum);
    }

}
