import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 두 동전 (https://www.acmicpc.net/problem/16197)
 */
public class BOJ_16197 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n, m;
    static char[][] map = new char[21][21];
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        int x1 = 0, y1 = 0, x2 = 0, y2 = 0, coin = 0;
        for (int i = 0; i < n; i++) {
            char[] rows = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {
                map[i][j] = rows[j];
                if (map[i][j] == 'o') {
                    if (coin == 0) {
                        x1 = j;
                        y1 = i;
                        coin++;
                    } else {
                        x2 = j;
                        y2 = i;
                    }
                }
            }
        }

        dfs(0, x1, y1, x2, y2);

        if (ans == Integer.MAX_VALUE) {
            bw.write(-1 + "\n");
        } else {
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int time, int x1, int y1, int x2, int y2) {
        if (time > 10) return;
        if (time >= ans) return;
        if (!isRange(x1, y1) && !isRange(x2, y2)) return;

        if ((isRange(x1, y1) && !isRange(x2, y2))
                || (!isRange(x1, y1) && isRange(x2, y2))) {
            ans = time;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx1 = x1 + dx[i];
            int ny1 = y1 + dy[i];
            int nx2 = x2 + dx[i];
            int ny2 = y2 + dy[i];

            if (isRange(nx1, ny1) && map[ny1][nx1] == '#') {
                nx1 = x1;
                ny1 = y1;
            }

            if (isRange(nx2, ny2) && map[ny2][nx2] == '#') {
                nx2 = x2;
                ny2 = y2;
            }

            dfs(time + 1, nx1, ny1, nx2, ny2);
        }
    }

    static boolean isRange(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
