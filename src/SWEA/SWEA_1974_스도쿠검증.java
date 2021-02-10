package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1974_스도쿠검증 {

    static boolean[] check = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());

        for(int t=1;t<=tc;t++){
            int[][] map = new int[9][9];

            for(int i=0;i<9;i++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for(int j=0;j<9;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int k=0;k<10;k++)check[k]=false;
            boolean flag = true;
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(!row(map,j,i) || !col(map,j,i) || !box(map,j,i)){
                        flag = false;
                        break;
                    }
                    for(int k=0;k<10;k++)check[k]=false;
                }
            }
            if(flag) System.out.println("#" + t + " " + 1);
            else System.out.println("#" + t + " " + 0);
        }
    }

    public static boolean row(int[][] arr,int x,int y){
        for(int i=0;i<9;i++){
            if(check[arr[y][i]])return false;
            check[arr[y][i]] = true;
        }
        return true;
    }

    public static boolean col(int[][] arr,int x,int y){
        for(int i=0;i<9;i++){
            if(!check[arr[i][x]])return false;
            check[arr[i][x]] = false;
        }
        return true;
    }

    public static boolean box(int[][] arr,int x,int y){
        int r,c;
        r = y >= 6 ? 6 : y >= 3 ? 3 : 0;
        c = x >= 6 ? 6 : x >= 3 ? 3 : 0;

        for(int i=r;i<r+3;i++){ // 0 or 3 or 6
            for(int j=c;j<c+3;j++){
                if(check[arr[i][j]])return false;
                check[arr[i][j]] = true;
            }
        }
        return true;
    }
}
