package BOJ;

import java.util.*;
public class BJ_12904_A와B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder S = new StringBuilder(sc.next());
        StringBuilder T = new StringBuilder(sc.next());

        while(S.length() != T.length()){
            //System.out.println(T);
            if(T.charAt(T.length()-1) == 'A'){
                T.deleteCharAt(T.length()-1);
            }else{
                T.deleteCharAt(T.length()-1);
                T.reverse();;
            }
        }

        if(S.toString().equals(T.toString()))System.out.println(1);
        else System.out.println(0);
    }
}
