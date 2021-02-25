import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2491_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int asc=1,desc=1;
        int ascMax =1,descMax = 1;
        int temp = Integer.parseInt(st.nextToken());
        for(int i=1;i<N;i++){
            int cur = Integer.parseInt(st.nextToken());
            if(temp <= cur){
                asc++;
            }else{
                ascMax = Math.max(ascMax,asc);
                asc = 1;
            }
            if(temp >= cur){
                desc++;
            }else{
                descMax = Math.max(descMax,desc);
                desc=1;
            }
            temp = cur;
        }
        ascMax = Math.max(ascMax,asc);
        descMax = Math.max(descMax,desc);
        System.out.println(Math.max(ascMax,descMax));
    }
}
