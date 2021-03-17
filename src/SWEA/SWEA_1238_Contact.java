package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1238_Contact {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder ans = new StringBuilder();
        for(int t=1;t<=10;t++) {
            LinkedList<Integer>[] list = new LinkedList[101];
            int[] visit = new int[101];

            int len, S;
            StringTokenizer st = new StringTokenizer(bf.readLine());
            len = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < 101; i++) {
                list[i] = new LinkedList<>();
            }

            for (int i = 0; i < len; i += 2) {
                int src, dst;
                src = Integer.parseInt(st.nextToken());
                dst = Integer.parseInt(st.nextToken());
                list[src].add(dst);
            }

            Queue<Integer> q = new LinkedList<>();
            PriorityQueue<Order> pq = new PriorityQueue<>(new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    if (o1.order == o2.order) {
                        return o2.num - o1.num;
                    }
                    return o2.order - o1.order;
                }
            });
            q.offer(S);
            visit[S] = 1;
            while (!q.isEmpty()) {
                int cur = q.poll();
                //System.out.println(cur);
                for (int i = 0; i < list[cur].size(); i++) {
                    int nxt = list[cur].get(i);
                    if (visit[nxt] != 0) continue;
                    visit[nxt] = visit[cur] + 1;
                    q.offer(nxt);
                    pq.offer(new Order(nxt, visit[nxt]));
                }
            }
            ans.append('#').append(t).append(' ').append(pq.peek().num).append('\n');
        }
        System.out.println(ans);
    }

    static class Order{
        int num,order; // 노드넘버 차례

        public Order(int num, int order) {
            this.num = num;
            this.order = order;
        }
    }
}
