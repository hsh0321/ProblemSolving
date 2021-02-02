package BOJ;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_11399_ATM {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        int time=0;
        for(int i=0;i<N;i++){
            time = sc.nextInt();
            arr.add(time);
        }

        Collections.sort(arr);
        for(int i=1;i<N;i++){
            arr.set(i,arr.get(i-1) + arr.get(i));
        }

        int answer = 0;
        for(Integer elem : arr)answer += elem;
        System.out.println(answer);
    }
}
