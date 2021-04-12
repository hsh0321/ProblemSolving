
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder arr, answer = new StringBuilder();
        StringTokenizer st;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        String p;
        int n, T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            deque.clear();
            p = br.readLine();
            n = Integer.parseInt(br.readLine());
            arr = new StringBuilder(br.readLine());
            st = new StringTokenizer(arr.substring(1, arr.length() - 1), ",");
            while (st.hasMoreTokens())
                deque.addLast(Integer.parseInt(st.nextToken()));
            boolean error = false;
            int r_cnt = 0, length = p.length();
            for (int i = 0; i < length; i++) {
                if (p.charAt(i) == 'R') {
                    if (i > 0 && p.charAt(i - 1) == 'D') r_cnt = 0;
                    r_cnt++;
                } else {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (r_cnt % 2 == 0)
                        deque.pollFirst();
                    else
                        deque.pollLast();
                }
            }
            if (error) answer.append("error").append("\n");
            else {
                int size = deque.size();
                answer.append("[");
                if (r_cnt % 2 == 0)
                    while (!deque.isEmpty())
                        answer.append(deque.pollFirst()).append(",");
                else
                    while (!deque.isEmpty())
                        answer.append(deque.pollLast()).append(",");
                if (size > 0)
                    answer.deleteCharAt(answer.length() - 1);
                answer.append("]").append("\n");
            }
        }
        System.out.print(answer);
    }
}