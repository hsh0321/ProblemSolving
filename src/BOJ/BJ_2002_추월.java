package BOJ;

import java.io.*;
import java.util.*;

public class BJ_2002_추월 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        HashMap<String,Boolean> map = new HashMap<>();
        String[] inList = new String[N];
        for(int i=0;i<N;i++){
            inList[i] = bf.readLine();
            map.put(inList[i],false);
        }

        String[] outList = new String[N];
        for(int i=0;i<N;i++){
            outList[i] = bf.readLine();
        }

        int answer=0;
        int in=0,out=0;
        while(in < N || out < N){
            if(map.get(inList[in])) {
                in++;
            }else if(outList[out].equals(inList[in])){
                out++;
                in++;
            }else{
                answer++;
                map.put(outList[out],true);
                out++;
            }
        }
        System.out.println(answer);
    }
}
