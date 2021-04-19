package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_8382_방향전환 {
    static BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;
    public static void main(String[] args) throws IOException{
        T=Integer.parseInt(bf.readLine());
        for(int t=1;t<=T;t++) {
            sb.append("#"+Integer.toString(t)+" ");
            int sx,sy,ex,ey;
            int a,b,c,d;
            st=new StringTokenizer(bf.readLine());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());
            d=Integer.parseInt(st.nextToken());
            sx=Math.min(a, c);
            sy=Math.min(b, d);
            ex=Math.max(a, c);
            ey=Math.max(b, d);
            ex-=sx;
            ey-=sy;
            sx=0;
            sy=0;
            int ans=0;
            if(ex<=1&&ey<=1) {
                ans=ex+ey;
                sb.append(Integer.toString(ans)+"\n");
                continue;
            }
            if(ex==ey) {
                ans=(ex-sx)*2;
                sb.append(Integer.toString(ans)+"\n");
                continue;
            }
            int k=Math.max(ex, ey);
            int m=Math.min(ex, ey);
            if(k%2==1) {
                if(m%2==1) {
                    ans=2*k;
                }else {
                    ans=2*k-1;
                }
            }else {
                if(m%2==1) {
                    ans=2*(k-1)+1;
                }else {
                    ans=2*(k-1)+2;
                }
            }
            sb.append(Integer.toString(ans)+"\n");
        }

        System.out.println(sb);
    }



}