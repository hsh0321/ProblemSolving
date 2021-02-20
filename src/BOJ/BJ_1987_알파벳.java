package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1987_알파벳 {
    static int dx[] = {1,-1,0,0},dy[]={0,0,1,-1};
    static boolean visit[][];
    static char map[][];
    static boolean alphabet[];
    static int R,C,ans=0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];
        alphabet = new boolean[26];

        StringBuilder sb;
        for(int i=0;i<R;i++){
            sb = new StringBuilder(bf.readLine());
            for(int j=0;j<C;j++){
                map[i][j] = sb.charAt(j);
            }
        }
        alphabet[map[0][0]-'A'] = true;
        dfs(0,0,0);

        System.out.println(ans+1);
    }
    
    public static void dfs(int depth, int x, int y){
        for(int i=0;i<4;i++){
            int nxtX = x + dx[i];
            int nxtY = y + dy[i];
            if(nxtX >= C || nxtX < 0 || nxtY >= R || nxtY < 0)continue;
            if(alphabet[map[nxtY][nxtX]-'A'])continue;
            alphabet[map[nxtY][nxtX]-'A'] = true;
            dfs(depth+1,nxtX,nxtY);
            alphabet[map[nxtY][nxtX]-'A'] = false;
        }
        ans = Math.max(depth,ans);
    }
}
