package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_11047_동전0 {
    public static void main(String[] args) throws IOException {
        int N,K;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        String sp[] = s.split(" ");

        N = Integer.parseInt(sp[0]); K = Integer.parseInt(sp[1]);
        ArrayList<Integer> moneyType = new ArrayList<>();

        int tmp;
        for(int i=0;i<N;i++){
            tmp = Integer.parseInt(bf.readLine());
            if(tmp <= K)
                moneyType.add(tmp);
        }

        int cnt = 0;
        for(int i=moneyType.size()-1; i>=0;i--){
            cnt += K/moneyType.get(i);
            K %= moneyType.get(i);
        }

        System.out.println(cnt);
    }
}
