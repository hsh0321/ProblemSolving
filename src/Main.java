
import java.io.*;
import java.util.*;
public class Main {
    public static int[][] arr;
    public static int N;
    public static int M;
    public static List<int[]> rotatePerm;
    static int[] orders;
    static boolean[] isSelected;
    private static int R;
    private static int[][] newArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        newArr = new int[N][M];
        rotatePerm = new ArrayList<>();
        orders = new int[R];
        isSelected = new boolean[R];
        int[][] rotateInst = new int[R][3];

        // 배열에 저장
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 회전 명령어 저장
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            rotateInst[i][0] = Integer.parseInt(st.nextToken());
            rotateInst[i][1] = Integer.parseInt(st.nextToken());
            rotateInst[i][2] = Integer.parseInt(st.nextToken());
        }

        // 순열 구하기
        getPermForRotate(0);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < rotatePerm.size(); i++) {
            for(int p=0;p<N;p++) {
                for(int q=0;q<M;q++) {
                    newArr[p][q] = arr[p][q];
                }
            }
            int[] cur = rotatePerm.get(i);
            for(int j=0;j<cur.length;j++) {
                rotate(rotateInst[cur[j]][0], rotateInst[cur[j]][1], rotateInst[cur[j]][2]);
                //result = Math.min(minRowSum(), result);
            }
            result = Math.min(minRowSum(), result);
        }
        System.out.println(result);
    }

    /** 배열 시계 방향으로 회전 시키기 */
    static void rotate(int row, int col, int s) {
        // 시작값
        int r = row - s-1;
        int c = col - s-1;
        int tmp = 0;
        int rowSize = 2*s;
        int colSize = 2*s;
        while(rowSize > 0 && colSize > 0) {
            tmp = newArr[r][c];
            for(int i=1;i<=rowSize;i++) { // 상
                newArr[r][c] = newArr[r+1][c];
                r++;
            }
            for(int i=1;i<=colSize;i++) { // 우
                newArr[r][c] = newArr[r][c+1];
                c++;
            }
            for(int i=1;i<=colSize;i++) { // 하
                newArr[r][c] = newArr[r-1][c];
                r--;
            }
            for(int i=1;i<=rowSize;i++) { // 좌
                newArr[r][c] = newArr[r][c-1];
                c--;
            }
            newArr[r][c+1] = tmp;
            rowSize -= 2;
            colSize -= 2;
            r++;
            c++;
        }// end of while
    }

    /** 배열의 행들의 합중 최솟값을 구하는 함수*/
    static int minRowSum() {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0;i<N;i++) {
            sum = 0;
            for(int j=0;j<M;j++) {
                sum+=newArr[i][j];
            }
            min = Math.min(sum, min);

        }

        return min;
    }

    /** 회전 함수 어떤 순서로 돌지 순열을 구하는 함수*/
    static void getPermForRotate(int cnt) {
        if(cnt == R) {
            int[] newOrder = Arrays.copyOfRange(orders, 0, orders.length);
            rotatePerm.add(newOrder);
            return;
        }
        for(int i=0;i<R;i++) {
            if(isSelected[i]) continue;
            orders[cnt] = i;
            isSelected[i] = true;
            getPermForRotate(cnt+1);
            isSelected[i] = false;
        }
    }
}