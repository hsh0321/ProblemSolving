import java.io.*;
import java.util.*;

public class SWEA_1233_계산기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10 ; tc++) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (i%2 == 0) stack.push(c - '0');
                else if (c == '*') {
                    int num = stack.pop() * (s.charAt(i + 1) - '0');
                    stack.push(num);
                    ++i;
                }
            }

            long sum = 0;
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }

            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}