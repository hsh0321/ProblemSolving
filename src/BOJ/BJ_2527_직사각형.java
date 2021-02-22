package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2527_직사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int lx, ly, rx, ry,w,h;
            lx = Integer.parseInt(st.nextToken());
            ly = Integer.parseInt(st.nextToken());
            rx = Integer.parseInt(st.nextToken());
            ry = Integer.parseInt(st.nextToken());
            w = rx-lx;
            h = ry-ly;

            int lx2, ly2, rx2, ry2,w2,h2;
            lx2 = Integer.parseInt(st.nextToken());
            ly2 = Integer.parseInt(st.nextToken());
            rx2 = Integer.parseInt(st.nextToken());
            ry2 = Integer.parseInt(st.nextToken());
            w2 = rx2-lx2;
            h2 = ry2-ly2;

            int sumW = Math.max(rx,rx2) - Math.min(lx,lx2);
            int sumH = Math.max(ry,ry2) - Math.min(ly,ly2);

            if(w + w2 > sumW && h + h2 > sumH){
                System.out.println('a');
            }
            else if((w + w2 == sumW && h + h2 > sumH) || (h + h2 == sumH && w + w2 > sumW)){
                System.out.println('b');
            }
            else if(w + w2 == sumW && h + h2 == sumH){
                System.out.println('c');
            }else{
                System.out.println('d');
            }
        }
    }
}
