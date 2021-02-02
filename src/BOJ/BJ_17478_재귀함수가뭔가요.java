package BOJ;

import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Stack;

public class BJ_17478_재귀함수가뭔가요 {
    static String[] arr = new String[5];
    static StringBuffer ans = new StringBuffer("");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<StringBuffer> s = new Stack<StringBuffer>();

        arr[0] = "\"재귀함수가 뭔가요?\"";
        arr[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
        arr[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
        arr[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
        arr[4] = "라고 답변하였지.";
        StringBuffer tmp = new StringBuffer("");
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=0;j<4;j++){
                ans.append(tmp).append(arr[j]).append("\n");
            }
            s.push(new StringBuffer(tmp));
            tmp.append("____");
        }

        ans.append(tmp).append(arr[0]).append("\n");
        ans.append(tmp).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
        ans.append(tmp).append("라고 답변하였지.").append("\n");

        while(!s.empty()){
            ans.append(s.pop()).append(arr[4]).append("\n");
        }
        System.out.print(ans);
    }

}

