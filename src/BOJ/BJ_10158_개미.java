package BOJ;

import java.util.Scanner;

public class BJ_10158_개미 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w,h,p,q,t;
        w = sc.nextInt();
        h = sc.nextInt();
        p = sc.nextInt();
        q = sc.nextInt();
        t = sc.nextInt();
        int dp,dq;
        dp = t % (2*w); // 가로 실제 이동 횟수
        dq = t % (2*h); // 세로 실제 이동 횟수

        p += dp; // 초기 위치
        q += dq;

        int ansX,ansY;
        if(p / w == 2){ // 2번 꺽임
            ansX = p%w;
        }else if(p / w == 1){ // 1번 꺽임
            ansX = w - (p%w);
        }else{ // 안꺽임
            ansX = p;
        }

        if(q / h == 2){
            ansY = q%h;
        }else if(q / h == 1){
            ansY = h - (q%h);
        }else{
            ansY = q;
        }

        System.out.println(ansX + " " + ansY);
    }
}
