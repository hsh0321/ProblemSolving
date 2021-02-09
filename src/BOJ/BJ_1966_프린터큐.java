package BOJ;

import java.io.*;
import java.util.*;

public class BJ_1966_프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int test_case = Integer.parseInt(bf.readLine());

        for(int i=0;i<test_case;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = parse(st.nextToken());
            int dst = parse(st.nextToken());

            // 1 2 3 4  3을 뽑으려 할 때
            Queue<Integer> q = new LinkedList<>(); // 프린터 큐
            ArrayList<Integer> list = new ArrayList<>(); // 우선순위 저장용 4 3 2 1 순으로 출력해야함
            st = new StringTokenizer(bf.readLine());

            for(int j=0;j<N;j++){
                int in = parse(st.nextToken());
                q.offer(in);
                list.add(in);
            }

            Collections.sort(list,Collections.reverseOrder()); // 우선순위를 역순으로 저장

            int idx = 0; // 현재 출력해야 할 우선순위가 가장 높은 것의 인덱스
            int answer = 0; // 출력 횟수
            while(true){
                int head = q.peek(); // 현재 출력하려는 것
                if(head == list.get(idx)){ // 출력하는 것 == 가장 큰 우선순위 ?
                    if(dst == 0){ // 뽑을려고 하는게 제일 앞에 있을 때
                        break;
                    }
                    idx++; // 뽑았으니 우선순위 idx 증가
                    answer++; // 출력횟수 증가
                }else{
                    q.offer(head); // 뒤로 넣어줌.
                }
                q.poll(); // 앞에꺼 제거
                dst = dst == 0 ? q.size()-1 : dst-1; // 뽑을려고 하는것 idx
            }
            sb.append(answer+1).append('\n');
        }
        System.out.println(sb);
    }

    public static int parse(String s){
        return Integer.parseInt(s);
    }
}