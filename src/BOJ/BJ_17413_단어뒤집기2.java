package BOJ;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_17413_단어뒤집기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Object b = new PriorityQueue<Integer>();
        StringBuilder S = new StringBuilder(sc.nextLine());

        boolean inBracket = false;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '<') inBracket = true;
            else if (S.charAt(i) == '>') inBracket = false;
            else if(S.charAt(i) == ' ')continue;
            else if (!inBracket) {
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < S.length(); j++) {
                    if (S.charAt(j) == ' ' || S.charAt(j) == '<') break;
                    sb.append(S.charAt(j));
                }

                sb.reverse();
                for (int j = 0; j < sb.length(); j++) {
                    S.setCharAt(i + j, sb.charAt(j));
                }
                i += sb.length()-1;
            }
        }
        System.out.println(S);
    }
}
