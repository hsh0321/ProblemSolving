package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_13418_학교탐방하기 {
    static int N,M;
    static Edge[] edges;
    static int[] set;

    static class Edge{
        int src,dst,dist;

        public Edge(int src, int dst, int dist) {
            this.src = src;
            this.dst = dst;
            this.dist = dist;
        }
    }

    static int find(int a){
        if(set[a] == a)return a;
        return find(set[a]);
    }

    static boolean union(int a,int b){
        int p1 = find(a);
        int p2 = find(b);
        if(p1==p2)return false; // 사이클 발생
        set[p1] = p2;
        return true; // 합쳐짐
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = null;
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        set = new int[N+1];
        edges = new Edge[M+1];

        for(int i=0;i<=N;i++)set[i]=i;

        int A,B,C;
        for(int i=0;i<M+1;i++){
            st = new StringTokenizer(bf.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(A,B,C == 0 ? 1:0); // 오르막길 1 내리막길 0
        }

        // 최적의 경로
        Arrays.sort(edges,((o1, o2) -> o1.dist - o2.dist));
        int cnt = 0;
        int dist = 0;
        for (Edge edge : edges) {
            if(union(edge.src,edge.dst)){
                dist += edge.dist;
                if(++cnt == N)break;
            }
        }

        int minDist = (int)Math.pow(dist,2);

        for(int i=0;i<=N;i++)set[i]=i;
        // 최악 경로
        cnt = 0;
        dist = 0;
        for(int i=edges.length-1;i>=0;i--){
            if(union(edges[i].src,edges[i].dst)){
                dist += edges[i].dist;
                if(++cnt == N)break;
            }
        }
        int maxDist = (int)Math.pow(dist,2);
        System.out.println(maxDist-minDist);
    }
}
