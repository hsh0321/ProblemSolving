package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_5525_IOIOI {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());

        String S = bf.readLine();

        boolean inBracket = false;
        boolean flag = true; // true면 I false면 O

        int len = 0; // IOI.. 길이
        int answer = 0;

        for(int i=0;i<S.length();i++){
            if(inBracket){ // 탐색 중
                if(!flag){ // O가 나와야함
                    if(S.charAt(i) == 'O'){ // 올바른 순서
                        len++;
                        flag = true;
                    }else{ // 초기화 // 또 I가 나옴 // ..IOII
                        if(len/2 >= N){ // O가 포함된 개수 비교
                            answer += len/2 - N + 1;
                        }
                        len = 0;
                        inBracket = false;
                        i--;
                    }
                }else{ // I가 나와야함
                    if(S.charAt(i) == 'I'){ // 올바른 순서
                        len++;
                        flag = false;
                    }else{ // ..IOIOO
                        len--; // 이거 안해줘서 20퍼 까지밖에 안갔었음
                        if(len/2 >= N){ // O가 포함된 개수 비교
                            answer += len/2 - N + 1;
                        }
                        len = 0;
                        inBracket = false;
                    }
                }
            }else{ // 아님
                if(S.charAt(i) == 'I'){
                    inBracket = true;
                    flag = false;
                    len++;
                }else{
                    continue;
                }
            }
        }

        if(len%2 == 0){
            len--;
        }
        if(len/2 >= N){ // O가 포함된 개수 비교
            answer += len/2 - N + 1;
        }

        System.out.println(answer);

    }
}
