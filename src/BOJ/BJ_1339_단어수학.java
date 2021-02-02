package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1339_단어수학 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[] s = new String[10];
        int alphabet[] = new int[26];

        for (int i = 0; i < N; i++) {
            s[i] = sc.next();
            for (int j = 0; j < s[i].length(); j++) {
                alphabet[s[i].charAt(j) - 'A'] += Math.pow(10, s[i].length() - j - 1);
            }
        }

        Arrays.sort(alphabet);
        int answer = 0, idx = 9;
        for (int i = 25; i >= 0; i--) {
            if(alphabet[i] == 0)break;
            answer += (idx--) * alphabet[i];
            //System.out.println(alphabet[i]);
        }
        System.out.println(answer);
    }
}
