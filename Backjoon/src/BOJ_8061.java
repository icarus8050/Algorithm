import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Bitmap (https://www.acmicpc.net/problem/8061) 시간 초과... BFS로 다시 풀어보자
 */
public class BOJ_8061 {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int minDist;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        n = Integer.parseInt(NM[0]);
        m = Integer.parseInt(NM[1]);
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    bw.write(0 + " ");
                }
                else {
                    visited = new boolean[n][m];
                    visited[i][j] = true;
                    minDist = Integer.MAX_VALUE;
                    dfs(j, i, 0);
                    bw.write(minDist + " ");
                }
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int x, int y, int cnt) {
        if (cnt >= minDist) return;
        if (map[y][x] == 1) {
            minDist = cnt;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isRange(nx, ny) && !visited[ny][nx]) {
                visited[ny][nx] = true;
                dfs(nx, ny, cnt + 1);
                visited[ny][nx] = false;
            }
        }
    }

    static boolean isRange(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
