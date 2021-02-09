package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS {
    static int N,M,V;
    static int cnt = 0;
    static PriorityQueue<Integer>[] map = new PriorityQueue[1001];
    static PriorityQueue<Integer>[] map2 = new PriorityQueue[1001];
    static boolean[] visit = new boolean[1001];
    static boolean[] visit2 = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = parse(st.nextToken());
        M = parse(st.nextToken());
        V = parse(st.nextToken());

        for(int i=0;i<1001;i++){ // 1001개 짜리 배열
            map[i] = new PriorityQueue<>(); // 숫자가 작은 순서부터 탐색하므로 우선순위 큐 사용
            map2[i] = new PriorityQueue<>();
        }

        for(int i=0; i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int a = parse(st.nextToken());
            int b = parse(st.nextToken());
            map[a].add(b); // 간선은 양방향이므로 서로 연결
            map[b].add(a);
            map2[a].add(b);
            map2[b].add(a);
        }

        dfs(1,V);
        System.out.println();
        bfs(V);
    }

    public static void dfs(int depth,int nNum){
        if(visit[nNum])return; // 이미 방문한 노드는 볼 필요 없음.
        visit[nNum] = true; // 현재 노드를 방문했다고 바꿔줌
        System.out.print(nNum + " ");
        while(!map[nNum].isEmpty()){ // 현재 노드의 연결된 노드 탐색
            dfs(depth +1,map[nNum].poll()); // 다음 노드의 번호를 매개변수로 줌
        }
    }

    public static void bfs(int nNum){
        Queue<Integer> q = new LinkedList<>();
        q.add(nNum);
        visit2[nNum] = true; // 시작 노드 방문했다고 초기화
        System.out.print(nNum + " ");
        while(!q.isEmpty()){
            int cur = q.poll(); // 탐색하려는 노드
            while(!map2[cur].isEmpty()){ // 현재 노드에 붙어 있는 노드들 전부 탐색
                int nxt = map2[cur].poll();
                if(visit2[nxt])continue;
                q.offer(nxt); // 방문하지 않은 노드였다면 다음에 탐색하기 위해 큐에 추가
                visit2[nxt] = true; // 방문했다고 표시
                System.out.print(nxt + " ");
            }
        }
    }

    public static int parse(String s){
        return Integer.parseInt(s);
    }
}

