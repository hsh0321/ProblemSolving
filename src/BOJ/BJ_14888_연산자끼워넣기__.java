package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_14888_연산자끼워넣기 {

    static int[] arr;
    static int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<4;i++){
            int tmp = sc.nextInt();
            for(int j=0;j<tmp;j++){
                list.add(i);
            }
        }
        int[] output = new int[list.size()];
        boolean[] visited = new boolean[list.size()];

        perm(list, output, visited, 0, list.size(),list.size());

        System.out.print(max + "\n" + min);
    }

    static void perm(ArrayList<Integer> list, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            int answer = arr[0];
            for(int i=0;i<r;i++) {
                switch (output[i]){
                    case 0: // +
                        answer += arr[i+1];
                        break;
                    case 1: // -
                        answer -= arr[i+1];
                        break;
                    case 2: // *
                        answer *= arr[i+1];
                        break;
                    case 3: // /
                        answer /= arr[i+1];
                        break;
                }
            }
            max = Math.max(answer,max);
            min = Math.min(answer,min);
            return;
        }

        for (int i=0; i<n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = list.get(i);
                perm(list, output, visited, depth + 1, n, r);
                visited[i] = false;;
            }
        }
    }
}
