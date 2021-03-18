package BOJ;

// 가장 처음에 아기 상어의 크기는 2
// 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다.
// 따라서, 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.
// 아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다.

// 제한시간 2초 N <= 20

// 탐색 방법 bfs

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_16236_아기상어 {
    static int N;
    static int[][] map;
    static int[][] visit;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        map = new int[N][N];
        visit = new int[N][N];

        Shark shark = new Shark(null, 2, 0);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) shark.loc = new Point(j, i);
            }
        }

        int answer = 0;
        boolean flag = false;
        while (true) {
            if(flag)break;
            Queue<Point> q = new LinkedList<>();
            q.offer(shark.loc);
            int dist = 0;
            visit[shark.loc.y][shark.loc.x] = 1; // 초기 값

            // 물고기 탐색
            while (true) { // 물고기 탐색
                int size = q.size();
                if(q.size() == 0){
                    flag = true;
                    break;
                }
                dist++;
                PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() { // 물고기 후
                    @Override
                    public int compare(Point o1, Point o2) {
                        if (o1.y == o2.y) return o1.x - o2.x;
                        return o1.y - o2.y;
                    }
                });


                while (size-- != 0) {
                    Point cur = q.poll();
                    for (int i = 0; i < 4; i++) {
                        Point nxt = new Point(cur.x + dx[i], cur.y + dy[i]);
                        if (nxt.x >= N || nxt.x < 0 || nxt.y >= N || nxt.y < 0) continue; // 맵밖
                        if (map[nxt.y][nxt.x] > shark.size) continue; // 상어의 크기보다 큰 곳
                        if (visit[nxt.y][nxt.x] != 0) continue; // 이미 방문한 곳
                        if (map[nxt.y][nxt.x] < shark.size && map[nxt.y][nxt.x] != 0) {
                            pq.offer(nxt);
                        }
                        visit[nxt.y][nxt.x] = dist;
                        q.offer(nxt);
                    }
                }

                // 이동
                if (pq.size() > 0) { // 먹을 수 있는 물고기가 하나라도 있다면
                    map[shark.loc.y][shark.loc.x] = 0; // 기존 위치 초기화
                    shark.loc.x = pq.peek().x;
                    shark.loc.y = pq.peek().y;
                    map[shark.loc.y][shark.loc.x] = 9; // 위치 갱신
                    shark.exp++;
                    answer += dist;
                    break;
                }
            }
            // 경험치 증가 및 크기 증가
            if (shark.exp == shark.size) {
                shark.exp = 0;
                shark.size++;
            }
            //print();
            // 배열 초기화
            clear();
        }
        System.out.println(answer);
    }

    static void clear() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visit[i][j] = 0;
            }
        }
    }

    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Shark {
        Point loc;
        int size, exp;

        public Shark(Point loc, int size, int exp) {
            this.loc = loc;
            this.size = size;
            this.exp = exp;
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
