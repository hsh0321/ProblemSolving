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
        s += '-';
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '-'){
                if(inBracket){
                    saveInt += Integer.parseInt(save.toString());
                    answer -= saveInt;
                    saveInt = 0;
                    save.setLength(0);
                }else {
                    saveInt += Integer.parseInt(save.toString());
                    answer += saveInt;
                    saveInt = 0;
                    save.setLength(0);
                    inBracket = true;
                }
            }else if(s.charAt(i) == '+'){
                saveInt += Integer.parseInt(save.toString());
                save.setLength(0);
            }else{
                save.append(s.charAt(i));
            }
        }
//        saveInt += Integer.parseInt(save.toString());
//        answer -= saveInt;

        System.out.println(answer);
    }
}

// 10-20+30-40+30-30-30+20+10-30
//