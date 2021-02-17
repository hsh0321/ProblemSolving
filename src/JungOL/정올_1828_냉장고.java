    package JungOL;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.Comparator;
    import java.util.StringTokenizer;

    public class 정올_1828_냉장고 {
        static int N;
        static int[][] list;
        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(bf.readLine());

            list = new int[N][2];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                list[i][0] = Integer.parseInt(st.nextToken());
                list[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1] ;
                }
            });

            int ans = 0;
            for(int i=0;i<N;){
                int temp = list[i][1];
                int j;
                for(j=i+1;j<N;j++){
                    if(list[j][0] > list[i][1])break;
                }
                ans++;
                i = j;
            }

            System.out.println(ans);

    //        for (int[] ints : list) {
    //            System.out.println(ints[0] + "," + ints[1]);
    //        }
        }
    }
