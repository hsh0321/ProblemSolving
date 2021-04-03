import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static String num[] = {"zero","one","two","three","four","five" // 미리 저장할 숫자 영어
                         ,"six","seven","eight","nine"};

    static class Number{ // 숫자와 변환한 값을 저장할 클래스
        int x; // 숫자
        String s; // 변환된 숫자 영어 문자열
        public Number(int x, String s) { // 생성자
            this.x = x;
            this.s = s;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); // 스캐너
        int M,N; // M,N 선언
        M = sc.nextInt(); // M 입력
        N = sc.nextInt(); // N 입력

        ArrayList<Number> list = new ArrayList<>(); // 숫자들을 담을 List
        StringBuilder sb,tmp; // 숫자와 문자
        for(int i=M;i<=N;i++){
            sb = new StringBuilder(Integer.toString(i)); // 숫자를 string으로 저장
            tmp = new StringBuilder(); // 숫자를 영어로 변환
            for(int j=0;j<sb.length();j++){ // 숫자 길이만큼 반복
                tmp.append(num[sb.charAt(j)-'0']).append(' '); // 미리 저장한 영어 배열을 사용하여 영어 완성
            }
            list.add(new Number(i,tmp.toString())); // 리스트에 추가
        }

        Collections.sort(list, new Comparator<Number>() { // string을 기준으로 정렬
            @Override
            public int compare(Number o1, Number o2) {
                return o1.s.compareTo(o2.s); // string compareTo 함수를 사용
            }
        });

        StringBuilder answer = new StringBuilder(); // 정답
        for(int i=1;i<=list.size();i++){ // List 사이즈 만큼 반복
            answer.append(list.get(i-1).x).append(' ');
            if(i != 0 && i%10==0)answer.append('\n'); // 10개 단위로 줄바꿈
        }

        System.out.println(answer);
    }
}