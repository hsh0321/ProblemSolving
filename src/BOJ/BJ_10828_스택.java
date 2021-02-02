package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_10828_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        Stack<Integer> s = new Stack<>();
        for(int i=0;i<N;i++){
            String menu = bf.readLine();
            String arr[] = menu.split(" ");


            if(arr[0].equals("push")){
                s.add(Integer.parseInt(arr[1]));
            }else if(arr[0].equals("pop")){
                if(s.isEmpty()) System.out.println(-1);
                else System.out.println(s.pop());
            }else if(arr[0].equals("size")){
                System.out.println(s.size());
            }else if(arr[0].equals("empty")){
                if(s.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }else if(arr[0].equals("top")){
                if(s.isEmpty()) System.out.println(-1);
                else System.out.println(s.peek());
            }
        }
    }
}
