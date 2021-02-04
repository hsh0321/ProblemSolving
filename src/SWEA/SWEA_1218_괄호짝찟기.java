package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218_괄호짝찟기 {
    static StringBuffer ans = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int i=1;i<=10;i++){
            int size = Integer.parseInt(bf.readLine());
            String s = bf.readLine();

            Stack<Character> stack = new Stack<>();

            int answer = 1;
            boolean flag = false;
            for(int j=0;j<size;j++){
                if(flag)break;
                switch (s.charAt(j)){
                    case '[':
                        stack.push(']');
                        break;
                    case '{':
                        stack.push('}');
                        break;
                    case '<':
                        stack.push('>');
                        break;
                    case '(':
                        stack.push(')');
                        break;
                    case ']':
                        if(stack.isEmpty() ||stack.peek() != ']'){
                            answer = 0;  flag = true;
                        }
                        stack.pop();
                        break;
                    case '}':
                        if(stack.isEmpty() || stack.peek() != '}'){
                            answer = 0;flag = true;
                        }
                        stack.pop();
                        break;
                    case '>':
                        if(stack.isEmpty() || stack.peek() != '>'){
                            answer = 0; flag = true;
                        }
                        stack.pop();
                        break;
                    case ')':
                        if(stack.isEmpty() || stack.peek() != ')'){
                            answer = 0; flag = true;
                        }
                        stack.pop();
                        break;
                }
            }
            ans.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(ans);
    }
}
