package BOJ;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BJ_1541_잃어버린괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        boolean inBracket = false;
        StringBuilder sb =new StringBuilder();
        StringBuilder save = new StringBuilder();

        int answer = 0;
        int saveInt = 0;

        s += '-'; // - 일 때 마지막으로 더해주는 작업을 하기 위해서
        // -(a+b+c+d)-(a+b+c)-(a+b)
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '-'){ // - 일때
                if(inBracket){ // 괄호 안
                    saveInt += Integer.parseInt(save.toString()); // 괄호 완 숫자 parsing
                    answer -= saveInt; // -(a+b+c) 꼴 빼기
                    saveInt = 0;
                    save.setLength(0); // 초기화
                }else { // 처음에 + 일 때?
                   saveInt += Integer.parseInt(save.toString());
                    answer += saveInt;
                    saveInt = 0;
                    save.setLength(0);
                    inBracket = true;
                }
            }else if(s.charAt(i) == '+'){ // 괄호 안 +
                saveInt += Integer.parseInt(save.toString()); // 괄호 안 합치기
                save.setLength(0);
            }else{ // 숫자일때
                save.append(s.charAt(i)); // 문자 저장
            }
        }
//        saveInt += Integer.parseInt(save.toString());
//        answer -= saveInt;

        System.out.println(answer);
    }
}

// 10-20+30-40+30-30-30+20+10-30
//