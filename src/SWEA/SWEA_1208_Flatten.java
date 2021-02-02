package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1208_Flatten {
    static StringBuffer ans = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case=1;test_case<=10;test_case++){
            PriorityQueue<Integer> asc = new PriorityQueue<>();
            PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());

            int dump = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i=0;i<100;i++){
                int h = Integer.parseInt(st.nextToken());
                asc.add(h);
                desc.add(h);
            }

            while(dump-- != 0){
                asc.add(asc.poll()+1);
                desc.add(desc.poll()-1);
            }

            ans.append("#").append(test_case).append(" ").append(desc.peek() - asc.peek()).append("\n");
        }
        System.out.println(ans);
    }
}
