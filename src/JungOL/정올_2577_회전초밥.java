package JungOL;

// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1838&sca=99&sfl=wr_hit&stx=2577

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 정올_2577_회전초밥 {
    static int N,d,k,c;
    static int[] arr = new int[3001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        ArrayList<Integer> sushi = new ArrayList<>();

        for(int i=0;i<N;i++){
            sushi.add(Integer.parseInt(bf.readLine()));
        }

        int cnt = 0,answer=0;

        Queue<Integer> q = new LinkedList<>();
        int tmp;
        for(int i=0;i<k;i++){
            tmp = sushi.get(i);
            q.offer(tmp);
            if(arr[tmp] == 0)cnt++;
            arr[tmp]++;
        }

        if(arr[c] == 0)answer = cnt + 1;
        else answer = cnt;

        int t,front;
        for(int i=k;i<N+k;i++){
            t = cnt;
            front = q.poll();
            arr[front]--;
            if(arr[front] == 0)t--;

            tmp = sushi.get(i%N);
            q.add(tmp);

            if(arr[tmp] == 0)t++;
            arr[tmp]++;
            if(arr[c] == 0)answer = Math.max(answer,t+1);
            else answer = Math.max(answer,t);
            cnt = t;
        }

        System.out.println(answer);
    }
}
