import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 색종이 붙이기 (https://www.acmicpc.net/problem/17136)
 */
public class BOJ_17136 {

    static int MAX = 10;
    static int[][] map = new int[MAX][MAX];
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < MAX; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < MAX; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        dfs(0, 0, 0);
        if (ans == Integer.MAX_VALUE) bw.write("-1\n");
        else bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int x, int y, int cnt) {
        if (y >= 9 && x > 9) {
            ans = Math.min(ans, cnt);
            return;
        }

        if (cnt >= ans) return;

        if (x > 9) {
            dfs(0, y + 1, cnt);
            return;
        }

        if (map[y][x] == 1) {
            for (int i = 5; i >= 1; i--) {
                if (paper[i] > 0 && paperCheck(x, y, i)) {
                    paper[i]--;
                    paperCover(x, y, i, 0);

                    dfs(x + 1, y, cnt + 1);

                    paper[i]++;
                    paperCover(x, y, i, 1);
                }
            }
        } else {
            dfs(x + 1, y, cnt);
        }
    }

    static boolean paperCheck(int x, int y, int size) {
        if (!isRange(x + size - 1, y + size - 1)) return false;

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] == 0) return false;
            }
        }

        return true;
    }

    static void paperCover(int x, int y, int size, int flag) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                map[i][j] = flag;
            }
        }
    }

    static boolean isRange(int x, int y) {
        return x >= 0 && x < MAX && y >= 0 && y < MAX;
    }
}
