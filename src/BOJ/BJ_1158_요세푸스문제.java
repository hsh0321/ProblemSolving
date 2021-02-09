package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_1158_요세푸스문제 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int tmp = 0;

        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<n; i++) {
            arr.add(i+1);
        }

        while(!arr.isEmpty()) {
            tmp = (tmp+a-1)%arr.size();
            list.add(arr.remove(tmp));
        }
        System.out.print("<");
        for(int i=0; i<n; i++) {
            System.out.print(list.get(i));

            if(i!=n-1) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}