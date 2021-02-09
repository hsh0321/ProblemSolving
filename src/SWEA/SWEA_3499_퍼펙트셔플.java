package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3499_퍼펙트셔플 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        for(int i=1;i<=t;i++){
            int size = Integer.parseInt(bf.readLine());
            String[] a = new String[size/2+1];
            String[] b = new String[size/2+1];
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int anum=0;anum<size/2;anum++){
                a[anum] = st.nextToken();
            }
            if(size%2==1)a[size/2] = st.nextToken();
            for(int bNum=0;bNum<size/2;bNum++){
                b[bNum] = st.nextToken();
            }
            for(int k=0;k<size/2;k++){
                sb.append(a[k]).append(' ').append(b[k]).append(' ');
            }
            if(size%2==1)sb.append(a[size/2]);

            System.out.println("#" + i + " " + sb);
        }
    }
}
