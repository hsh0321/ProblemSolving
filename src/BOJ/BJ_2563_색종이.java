package BOJ;

import java.util.Scanner;

public class BJ_2563_색종이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] map = new boolean[101][101];

        int num = sc.nextInt();
        for(int i=0;i<num;i++){
            int x = sc.nextInt(), y= sc.nextInt();
            for(int j = x; j<x+10;j++){
                for(int k=y;k<y+10;k++){
                    map[j][k] = true;
                }
            }
        }
        int cnt = 0;
        for(int x=0;x<=100;x++){
            for(int y=0;y<=100;y++){
                if(map[x][y])cnt++;
            }
        }
        System.out.println(cnt);
    }
}
