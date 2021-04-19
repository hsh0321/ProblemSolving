package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_3238_이항계수구하기 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            long N = Long.parseLong(st.nextToken());
            long R = Long.parseLong(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            sb.append('#').append(tc).append(' ').append(nCr(N, R, P)).append('\n');
        }
        System.out.print(sb);
    }

    static long pow(long x, long y, long p) {
        long res = 1L;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    static long nCr(long n, long r, int p) {
        if (r == 0) return 1L;
        long num = 1L;
        long[] fac = new long[p+1];
        fac[0] = 1L;

        for (int i = 1 ;i < p; i++) {
            fac[i] = fac[i - 1] * i % p;
        }

        while (n > 0 || r > 0) {
            int newN = (int) (n % p);
            int newR = (int) (r % p);
            if(newN < newR) {
                num = 0;
                break;
            }
            num = num * fac[newN] % p;
            num = num * pow(fac[newR], p-2,p) % p * pow(fac[newN - newR], p-2,p) % p % p;

            n /= p;
            r /= p;
        }
        return num;
    }
}