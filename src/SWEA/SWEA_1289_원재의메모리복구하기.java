package SWEA;

import java.io.*;

public class SWEA_1289_원재의메모리복구하기 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        int test = Integer.parseInt(bf.readLine());
        for(int t = 1; t <= test; t++) {
            sb = new StringBuilder(bf.readLine());
            int cnt = sb.charAt(0) - '0';
            for(int i = 1; i < sb.length(); i++) {
                if(sb.charAt(i) != sb.charAt(i-1))cnt++;
            }
            System.out.println("#" + t + " " + cnt);
        }
        // bw.close();
        bf.close();
    }
}
