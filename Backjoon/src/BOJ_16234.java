import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 인구 이동 (https://www.acmicpc.net/problem/16234)
 */
public class BOJ_16234 {

    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int ans;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NLR = br.readLine().split(" ");
        N = Integer.parseInt(NLR[0]);
        L = Integer.parseInt(NLR[1]);
        R = Integer.parseInt(NLR[2]);
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(data[j]);
            }
        }

        ans = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            ans++;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(j, i)) {
                            flag = true;
                        }
                    }
                }
            }
        }

        bw.write((ans - 1) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static boolean bfs(int x, int y) {
        int totalPopulation = 0;
        List<Point> points = new ArrayList<>();
        Queue<Point> queue = new LinkedList<>();
        Point first = new Point(x, y);
        queue.offer(first);
        points.add(first);
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            totalPopulation += map[current.y][current.x];

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + current.x;
                int ny = dy[i] + current.y;

                if (isPossibleRange(nx, ny) && !visited[ny][nx] && isPossibleUnion(current.x, current.y, nx, ny)) {
                    Point neighborPoint = new Point(nx, ny);
                    queue.offer(neighborPoint);
                    points.add(neighborPoint);
                    visited[ny][nx] = true;
                }
            }
        }

        int size = points.size();
        if (size != 1) {
            for (Point point : points) {
                map[point.y][point.x] = totalPopulation / size;
            }

            return true;
        }

        return false;
    }

    static boolean isPossibleRange(int x, int y) {
        return (x >= 0 && x < N) && (y >= 0 && y < N);
    }

    static boolean isPossibleUnion(int currentX, int currentY, int neighborX, int neighborY) {
        int subs = Math.abs(map[currentY][currentX] - map[neighborY][neighborX]);
        return (subs >= L && subs <= R);
    }

    static class Point {
        int x;
        int y;
        int population;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
