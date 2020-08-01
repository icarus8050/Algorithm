import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Bitmap (https://www.acmicpc.net/problem/8061)
 */
public class BOJ_8061 {

    static int n, m;
    static int[][] map;
    static int[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        n = Integer.parseInt(NM[0]);
        m = Integer.parseInt(NM[1]);
        map = new int[n][m];
        visited = new int[n][m];

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);

                if (map[i][j] == 1) {
                    queue.add(new Node(j, i));
                    visited[i][j] = 0;
                }
            }
        }
        bfs(queue);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(visited[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(Queue<Node> queue) {

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (isRange(nx, ny) && map[ny][nx] == 0 && visited[ny][nx] == 0) {
                    visited[ny][nx] = visited[current.y][current.x] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }
    }

    static boolean isRange(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
