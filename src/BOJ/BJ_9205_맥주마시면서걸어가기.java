package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_9205_맥주마시면서걸어가기 {

    static int testCase,storeCnt;
    static Pos[] posList;

    public static void main(String[] args) throws IOException{
        FastScanner fs  = new FastScanner();
        testCase = fs.nextInt();
        for(int i=0;i<testCase;i++){
            boolean ok = false;
            storeCnt = fs.nextInt()+2;
            posList = new Pos[storeCnt];
            for(int j=0;j<storeCnt;j++) {
                posList[j] = new Pos(fs.nextInt(),fs.nextInt());
            }
            posList[storeCnt-1].isDest = true;
            makeConnect();

            Deque<Pos> q = new ArrayDeque<>();
            q.offer(posList[0]);
            posList[0].visited = true;

            while(!q.isEmpty()){
                Pos cur = q.pollFirst();
                if(cur.isDest){
                    ok = true;
                    break;
                }

                for(Pos p : cur.conn){
                    if(p.visited==false){
                        p.visited = true;
                        q.offer(p);
                    }
                }
            }
            String answer = ok?"happy":"sad";
            System.out.println(answer);
        }
    }

    static class Pos{
        int x,y;
        boolean isDest = false;
        boolean visited = false;
        List<Pos> conn = new ArrayList<>();

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString(){
            return "("+x+ "," + y +")";
        }
    }

    static void makeConnect(){
        for(int i=0;i<storeCnt;i++){
            for(int j=i+1;j<storeCnt;j++){
                if(Math.abs(posList[i].x-posList[j].x) + Math.abs(posList[i].y-posList[j].y) <= 1000){
                    posList[i].conn.add(posList[j]);
                    posList[j].conn.add(posList[i]);
                }
            }
        }
    }

    static class FastScanner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String next() throws IOException {
            while(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException{
            return Integer.parseInt(next());
        }

        public int[] readArray(int n) throws IOException{
            int[] a = new int[n];
            for(int i=0;i<n;i++) a[i] = nextInt();
            return a;
        }


    }
}