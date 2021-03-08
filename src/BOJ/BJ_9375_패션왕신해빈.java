package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_9375_패션왕신해빈 {
    static int tc;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0;t<tc;t++){
            int n = Integer.parseInt(bf.readLine());
            HashMap<String,Integer> map = new HashMap<>();
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                st.nextToken();
                String k = st.nextToken();
                if(map.containsKey(k))
                    map.put(k,map.get(k)+1);
                else
                    map.put(k,1);

            }

            int mul = 1;
            for (Integer value : map.values()) {
                mul *= value+1;
            }
            sb.append(mul-1).append('\n');
        }
        System.out.println(sb);
    }
}
