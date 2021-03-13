import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 내리막 길 (https://www.acmicpc.net/problem/1520)
 */
public class BOJ_1520 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n, m;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                dp[i][j] = -1;
            }
        }

        bw.write(dfs(0, 0) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int dfs(int y, int x) {
        if (y == n - 1 && x == m - 1) {
            return 1;
        }

        if (dp[y][x] != -1) {
            return dp[y][x];
        }

        dp[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if ((nextX >= 0 && nextX < m)
                    && (nextY >= 0 && nextY < n)
                    && map[y][x] > map[nextY][nextX]) {
                dp[y][x] += dfs(nextY, nextX);
            }
        }

        return dp[y][x];
    }
}
