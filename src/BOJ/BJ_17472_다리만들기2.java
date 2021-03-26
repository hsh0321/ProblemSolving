package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_17472_다리만들기2 {
    static int N,M;
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {1,-1,0,0},dc={0,0,1,-1};
    static ArrayList<ArrayList<Edge>> graph;
    static ArrayList<int[]>[] listOfGround;
    static PriorityQueue<Edge> pq;
    static boolean[] check;

    static class Edge implements Comparable<Edge> {
        int node;
        int dis;

        public Edge(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.dis, o.dis);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        pq = new PriorityQueue<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 해당 땅 생성
        listOfGround = new ArrayList[11];
        for(int i=0;i<=10;i++){
            listOfGround[i] = new ArrayList<>();
        }

        // 섬 번호 매기
        int islandNum = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 1 && !visit[i][j]){
                    findIsland(islandNum,new int[]{i,j});
                    islandNum++;
                }
            }
        }
        check = new boolean[islandNum+1];

        graph = new ArrayList<>();
        for (int i = 0; i <= islandNum; i++) {
            graph.add(new ArrayList<>());
        }


        // 간선 추가
        for(int i=1;i<=islandNum;i++){
            makeBridge(i);
        }

        // 프림
        int ans = 0, cnt =0;
        pq.add(new Edge(1,0));
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(check[edge.node]) continue;
            check[edge.node] = true;

            ans += edge.dis;

            for (Edge next : graph.get(edge.node)) {
                if(!check[next.node]) {
                    pq.add(next);
                }
            }
            if (++cnt == islandNum) break;
        }
        boolean flag = true;
        for(int i=1;i<islandNum;i++){
            if(!check[i])flag = false;
        }

        if(!flag) System.out.println(-1);
        else System.out.println(ans);


        //print();
    }

    static void makeBridge(int num){ // 노드에 간선 추가 함수
        for(int i=0;i<listOfGround[num].size();i++){ // 땅의 개수만큼
            int[] edge; // dst, dist
            for(int j=0;j<4;j++) { // 4방향 탐색
                edge = crossIsland(num,listOfGround[num].get(i),j);
                if(edge != null && edge[1] > 1){ // 간선 추가 1보다 길고 존재 할 때
                    graph.get(num).add(new Edge(edge[0],edge[1]));
                }
            }
        }
    }

    static int[] crossIsland(int num,int[] p,int dir){ // 다리 놓을 수 있는 경우 찾기
        int dist=0;
        int[] tmp = new int[2];
        tmp[0] = p[0]; tmp[1] = p[1];
        tmp[0] += dr[dir]; tmp[1] += dc[dir];
        while(!(tmp[0] < 0 || tmp[0] >= N || tmp[1] < 0 || tmp[1] >= M) && map[tmp[0]][tmp[1]] != num){ // 자기 섬이 아니여야만함.
            if(map[tmp[0]][tmp[1]] != 0){ // 다른 땅 발견
                return new int[]{map[tmp[0]][tmp[1]],dist};
            }
            tmp[0] += dr[dir]; tmp[1] += dc[dir];
            dist++;
        }

        return null; // 존재하지 않음
    }

    static void findIsland(int num,int[] p){ // 섬 번호 붙이기
        Queue<int[]> q = new LinkedList<>();
        q.offer(p);
        listOfGround[num].add(p);
        map[p[0]][p[1]] = num;
        visit[p[0]][p[1]] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0;i<4;i++){
                int[] nxt = new int[]{cur[0] + dr[i],cur[1] + dc[i]};
                if(nxt[0] < 0 || nxt[0] >= N || nxt[1] < 0 || nxt[1] >= M)continue;
                if(map[nxt[0]][nxt[1]] == 0)continue;
                if(visit[nxt[0]][nxt[1]])continue;
                visit[nxt[0]][nxt[1]] = true;
                map[nxt[0]][nxt[1]] = num;
                q.offer(nxt);
                listOfGround[num].add(nxt);
            }
        }
    }

    static void print(){
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }
}
