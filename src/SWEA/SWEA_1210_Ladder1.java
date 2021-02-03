package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210_Ladder1 {

    static int dx[] = {-1,1,0},dy[] = {0,0,-1}; // 좌 우
    static int map[][] = new int[100][100];
    static StringBuilder ans = new StringBuilder();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int i=1;i<=10;i++){
            int tc = Integer.parseInt(bf.readLine());
            int sX=100,sY=100;
            for(int row=0;row<100;row++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for(int col=0;col<100;col++){
                    map[row][col] = Integer.parseInt(st.nextToken());
                    if(map[row][col] == 2){
                        sX = col;
                        sY = row;
                    }
                }
            }

            while(sY != 0){
                for(int n=0;n<3;n++){
                    int nxtX = sX + dx[n];
                    int nxtY = sY + dy[n];
                    if(nxtX >= 100 || nxtX < 0 || nxtY >=100 || nxtY < 0)continue; // 범위 밖
                    if(map[nxtY][nxtX] == 0)continue; // 사다리가 아닌 곳
                    map[sY][sX] = 0;
                    sX = nxtX;
                    sY = nxtY;
                    break;
                }
            }

            ans.append("#").append(i).append(" ").append(sX).append("\n");
        }
        System.out.println(ans);
    }
}
//
//public class SWEA_1210_Ladder1 {
//
//    static int dx[] = {-1,1,0},dy[] = {0,0,-1}; // 상 좌 우
//    static int map[][] = new int[100][100];
//    static StringBuilder ans = new StringBuilder();
//    static int answer = 0;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        for(int i=1;i<=10;i++){
//            int tc = Integer.parseInt(bf.readLine());
//            int sX=0,sY=0;
//            for(int row=0;row<100;row++){
//                StringTokenizer st = new StringTokenizer(bf.readLine());
//                for(int col=0;col<100;col++){
//                    map[row][col] = Integer.parseInt(st.nextToken());
//                    if(map[row][col] == 2){
//                        sX = col;
//                        sY = row;
//                    }
//                }
//            }
//            find(sX,sY);
//            ans.append("#").append(i).append(" ").append(answer).append("\n");
//        }
//        System.out.println(ans);
//    }
//
//    public static void find(int x,int y){
//        if(y == 0){
//            answer = x;
//            return;
//        }
//        int nxtX = x,nxtY = y;
//        for(int i=0;i<3;i++){
//            nxtX += dx[i];
//            nxtY += dy[i];
//            if(nxtX >= 100 || nxtX < 0 || nxtY >=100 || nxtY < 0)continue; // 범위 밖
//            if(map[nxtY][nxtX] == 0)continue; // 사다리가 아닌 곳
//            find(nxtX,nxtY);
//            return;
//        }
//    }
//}

