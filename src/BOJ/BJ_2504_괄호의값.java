package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_2504_괄호의값 {

    public static Stack<Character> stack=new Stack<Character>();

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        boolean f = false;
        long ans=0;
        int mul=1;

        // (()[[]])([])
        // (2+(3*3))*2+(2*3)
        // (2*2)+(3*3*2)+(2*3)

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') {
                stack.add(s.charAt(i));
                mul*=2;
            }
            if(s.charAt(i)=='[') {
                stack.add(s.charAt(i));
                mul*=3;
            }
            if(s.charAt(i)==')') {
                if(stack.empty() || stack.peek()!='(') {
                    f =true;
                    break;
                }if(s.charAt(i-1)=='(')
                    ans+=mul;
                stack.pop();
                mul/=2;

            }else if(s.charAt(i)==']') {
                if(stack.empty() || stack.peek()!='[') {
                    f =true;
                    break;
                }
                if(s.charAt(i-1)=='[')
                    ans+=mul;
                stack.pop();
                mul/=3;
            }
        }
        if(f ==true || !stack.empty()) {
            System.out.println(0);
        }else {
            System.out.println(ans);
        }
    }

}