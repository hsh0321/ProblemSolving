package 기초알고리즘;

import java.io.*;
import java.util.*;

/**
 * boj.kr/1753
 */

public class Dijkstra_PQ {
    static ArrayList<Edge>[] adj;
    static boolean[] check;
    static int[] dist;

    static class Edge implements Comparable<Edge> {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(stringTokenizer.nextToken());
        int E = Integer.parseInt(stringTokenizer.nextToken());
        int start = Integer.parseInt(br.readLine());
        adj = new ArrayList[V+1];
        for (int i = 1; i <= V; i++)
            adj[i] = new ArrayList<>();
        for(int i=0; i<E; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            int w = Integer.parseInt(stringTokenizer.nextToken());
            adj[u].add(new Edge(v,w));
        }
        check = new boolean[V+1];
        dist = new int[V+1];

        dijkstra(start);

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=1; i<=V; i++){
            if(dist[i]!=Integer.MAX_VALUE)
                stringBuilder.append(dist[i] + "\n");
            else
                stringBuilder.append("INF\n");
        }
        System.out.print(stringBuilder.toString());
    }

    public static void dijkstra(int start){
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        Arrays.fill(dist,Integer.MAX_VALUE);
        priorityQueue.add(new Edge(start,0));
        dist[start] = 0;
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            int destination = edge.destination;
            if(check[destination])
                continue;
            else
                check[edge.destination] = true;
            for (Edge next : adj[destination]) {
                if (dist[next.destination] >= dist[destination] + next.weight) {
                    dist[next.destination] = dist[destination] + next.weight;
                    priorityQueue.add(new Edge(next.destination,dist[next.destination]));
                }
            }
        }
    }
}
