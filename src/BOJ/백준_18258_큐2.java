package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_18258_큐2 {
    static BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bf.readLine()); // 1 ~ 2백만

        Deque<Integer> q = new LinkedList<>();
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            switch (st.nextToken()){
                case "push":
                    q.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!q.isEmpty())ans.append(q.poll()).append("\n");
                    else ans.append(-1).append("\n");
                    break;
                case "size":
                    ans.append(q.size()).append("\n");
                    break;
                case "empty":
                    if(q.isEmpty())ans.append(1).append("\n");
                    else ans.append(0).append("\n");
                    break;
                case "front":
                    if(!q.isEmpty())ans.append(q.peek()).append("\n");
                    else ans.append(-1).append("\n");
                    break;
                case "back":
                    if(!q.isEmpty())ans.append(q.getLast()).append("\n");
                    else ans.append(-1).append("\n");
                    break;
            }
        }
        System.out.println(ans);
    }
}
