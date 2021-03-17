import java.util.*;
import java.io.*;
public class Solution {
    static char [][]map = new char[1001][1001];
    static int[][] distance = new int[1001][1001];
    static int N,M;
    static int[][]dydx={
            {0,1},
            {0,-1},
            {1,0},
            {-1,0},
    };
    static int answer;
    static class Node{
        int y,x;
        public Node(int y, int x){
            this.y=y;
            this.x=x;
        }
    }
    static Queue<Node> queue=new ArrayDeque<>(); //bfs 돌리는 큐
    static Queue<Node> Wqueue=new ArrayDeque<>(); //물 위치 저장한 큐
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T=Integer.parseInt(br.readLine());
        for(int test=1;test<=T;test++){
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            for(int y=0;y<N;y++){
                String input=br.readLine();
                for(int x=0;x<M;x++) {
                    map[y][x] = input.charAt(x);
                    if(map[y][x]=='W'){
                        Wqueue.offer(new Node(y, x));
                        distance[y][x]=1; //물 위치에 1 로 초기화 -> 나중에 1 빼면서 answer에 더할 예정
                    }
                }
            }
            answer=0;
            solution();
            bw.write("#"+test+" "+answer+"\n");
            clear();
        }
        bw.flush();
        bw.close();
    }
    static void solution(){
        while(!Wqueue.isEmpty()){
            queue.offer(Wqueue.poll());
            bfs();
        }
        //물 위치에 1을 저장했으므로 값을 더할 때는 answer에 (값 -1)을 더한다.
        for(int y=0;y<N;y++){
            for(int x=0;x<M;x++){
                answer+=distance[y][x]-1;
            }
        }
    }

    static void clear(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j]=0;
                distance[i][j]=0;
            }
        }
    }

    static void bfs(){
        while(!queue.isEmpty()){
            Node now=queue.poll();
            for(int i=0;i<4;i++){
                int yy=now.y+dydx[i][0];
                int xx=now.x+dydx[i][1];
                if(yy<0 || xx<0 || yy>=N || xx>=M) continue;
                if( map[yy][xx]=='W') continue; //map이 물이면 컨티뉴
                int level=distance[now.y][now.x];
                if(distance[yy][xx]>1 && distance[yy][xx]<=level+1) continue; //이미 방문한 곳이지만 level+1 보다 작으므로 컨티뉴
                distance[yy][xx]=level+1; //아직 방문하지 않았거나, 방문했지만 level+1 보다 크므로 값 갱신
                queue.offer(new Node(yy, xx));
            }
        }
    }
}