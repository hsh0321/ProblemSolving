import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Test_방사선치료 {
    static int[][] map;
    static ArrayList<int[][]> rect;
    public static void main(String[] args) throws IOException {
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());

        for(int t=1;t<=tc;t++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int maxX=0,maxY=0; // 가로 세로 최대값
            map = new int[N][N];
            rect = new ArrayList<>();

            int[][] r = new int[2][2];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(bf.readLine());
                r[0][0] = Integer.parseInt(st.nextToken());
                r[0][1] = Integer.parseInt(st.nextToken());
                r[1][0] = Integer.parseInt(st.nextToken());
                r[1][1] = Integer.parseInt(st.nextToken());
                maxX = Math.max(maxX,Math.max(r[0][0],r[1][0]));
                maxY = Math.max(maxY,Math.max(r[0][1],r[1][1]));

                Arrays.sort(r, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] - o2[0];
                    }
                });

                rect.add(r);
            }



            for(int size=0;size<Math.max(maxX,maxY);size++){
                for (int i = 0; i < maxY; i++) {
                    for (int j = 0; j < maxX; j++) {
                        for (int k = 0; k < rect.size(); k++) {


                        }
                    }
                }
            }
        }
    }
}
