    package BOJ;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.StringTokenizer;

    public class BJ_1967_트리의지름 {

        static ArrayList<Node>[] tree; // 트리
        static boolean check[]; // 방문 체크
        static int maxDistNum,maxLen; // 가장 먼 노드와 최대길이

        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(bf.readLine());

            tree = new ArrayList[N+1]; // 노드 번호로 넣기 위해 +1
            check = new boolean[N+1];

            for(int i=0;i<=N;i++){
                tree[i] = new ArrayList<>();
            }

            for(int i=0;i<N-1;i++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int src = Integer.parseInt(st.nextToken());
                int dst = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                tree[src].add(new Node(dst,d));
                tree[dst].add(new Node(src,d)); // 양방향 그래프
            }

            check[1] = true;
            dfs(tree[1],1,0); // 1번노드 기준으로 가장 먼 노드 탐색

            check = new boolean[N+1];
            maxLen = 0;
            check[maxDistNum] = true; // 1번 노드 방문
            dfs(tree[maxDistNum],maxDistNum,0); // 찾은 노드에서 가장 먼노드
            System.out.println(maxLen);
        }

        public static void dfs(ArrayList<Node> list,int num,int length){
            if(length > 0 && list.size() == 1){ // 리프노드까지
                if(length > maxLen){ // 가장 큰 거리 발견 시
                    maxLen = length;
                    maxDistNum = num;
                }
                return;
            }

            for (Node node : list) { // 현재 노드와 연결된 노드들 탐
                if(check[node.dst])continue;
                check[node.dst] = true;
                dfs(tree[node.dst],node.dst,length + node.dist);
                check[node.dst] = false;
            }
        }

        public static class Node{
            int dst,dist;

            public Node(int dst, int dist) {
                this.dst = dst;
                this.dist = dist;
            }
        }

    }
