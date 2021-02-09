package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder answer = new StringBuilder();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        Stack<Tower> stack = new Stack<>();
        for(int i=0;i<N;i++){
            int cur = Integer.parseInt(st.nextToken());
            if(stack.isEmpty()){ // 스택이 비어있다면
                answer.append(0).append(' ');
            }else{
                if(cur > stack.peek().h){ // 스택에 쌓인 것이 현재보다 낮음
                    while(!stack.isEmpty() && cur > stack.peek().h){
                        stack.pop(); // ** 어차피 지금 들어온게 더 높으므로 필요 없음.
                    }
                    if(stack.isEmpty()){ // 스택에 더이상 남는게 없음
                        answer.append(0).append(' ');
                    }else { // 스택에 나보다 큰게 존재함
                        answer.append(stack.peek().idx).append(' ');
                    }
                }else{ // 신호를 수신 할 수 있는 탑이 있음.
                    answer.append(stack.peek().idx).append(' ');
                }
            }
            stack.add(new Tower(i+1,cur));
        }
        System.out.println(answer);
    }
}

class Tower{
    int idx,h;

    public Tower(int i, int h) {
        this.idx = i;
        this.h = h;
    }
}
