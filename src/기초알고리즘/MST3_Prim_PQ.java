package 기초알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MST3_Prim_PQ {
    public static class Edge implements Comparable<Edge> {
        int node;
        double dis;

        public Edge(int node, double dis) {
            this.node = node;
            this.dis = dis;
        }
        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.dis, o.dis);
        }
    }

    static int V,E, ans = 0, cnt = 0;
    static ArrayList<ArrayList<Edge>> graph;
    static boolean[] visit;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        pq = new PriorityQueue<>();

        //정점의 수
        V = Integer.parseInt(st.nextToken());
        //간선의 수
        E = Integer.parseInt(st.nextToken());
        visit = new boolean[V];

        graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) -1;
            int B = Integer.parseInt(st.nextToken()) -1;
            int dis = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Edge(B, dis));
            graph.get(B).add(new Edge(A, dis));
        }
        //임의의 정점(0)부터 시작한다.
        pq.add(new Edge(0,0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            //방문했다면 continue;
            if(visit[edge.node]) continue;
            visit[edge.node] = true;
            //거리 증가
            ans += edge.dis;
            //그래프에 연결된 노드를 돌면서 방문하지 않았다면 pq에 넣어준다.
            for (Edge next : graph.get(edge.node)) {
                if(!visit[next.node]) {
                    pq.add(next);
                }
            }
            //모든 정점을 순회하였다.
            if (++cnt == V) break;
        }
        System.out.println(ans);
    }
}
