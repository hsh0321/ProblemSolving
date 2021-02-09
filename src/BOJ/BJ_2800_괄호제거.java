package BOJ;

import java.util.*;

public class BJ_2800_괄호제거 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>(); // 괄호열 짝맞추기
        ArrayList<Bracket> brackets = new ArrayList<>(); // 올바른 괄호열 개수

        String s = new String(sc.nextLine());

        for (int i = 0; i < s.length(); i++) { //
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                brackets.add(new Bracket(stack.pop(), i)); // 괄호에 해당하는 인덱스
            }
        }

        Set<String> ans = new HashSet<>();
        for (int i = 1; i < 1 << brackets.size(); i++) { // 비트 마스크를 이용한 조합
            StringBuilder sb = new StringBuilder(s);
            for (int j = 0; j < brackets.size(); j++) { // 비트 한개씩 검사
                if ((i & (1 << j)) > 0) { // 0001 0010 0100 1000
                    // 나중에 지워주기 위해 캐릭터를 다른걸로 바꿔둠
                    sb.setCharAt(brackets.get(j).src,'C');
                    sb.setCharAt(brackets.get(j).dst,'C');
                }
            }
            StringBuilder temp = new StringBuilder();
            // 바꿔둔 문자열을 'C'를 제외하여 추출
            for(int k=0;k<sb.length();k++){
                if(sb.charAt(k) != 'C')temp.append(sb.charAt(k));
            }
            ans.add(temp.toString()); // 해쉬셋에 추가 -> 중복없이 사전순 정렬
        }

        ArrayList<String> list = new ArrayList(ans);
        Collections.sort(list); // 사전순 정렬

        for (String s1 : list) {
            System.out.println(s1);
        }
    }
}

class Bracket{ // 괄호
    int src,dst;
    public Bracket(int s,int d){
        this.src = s;
        this.dst = d;
    }
}