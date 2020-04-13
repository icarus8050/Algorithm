import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Cavity Map (https://www.hackerrank.com/challenges/cavity-map/problem)
 */
public class CavityMap {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, -1, 0, 1};
    static int n;
    static int[][] mat;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split("");

            for (int j = 0; j < n; j++) {
                mat[i][j] = Integer.parseInt(row[j]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isBorder(j, i) && isCell(j, i)) {
                    sb.append("X");
                } else {
                    sb.append(mat[i][j]);
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static boolean isBorder(int x, int y) {
        return (x == 0 || x == n - 1) || (y == 0 || y == n - 1);
    }

    public static boolean isCell(int x, int y) {
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (mat[ny][nx] >= mat[y][x])
                return false;
        }

        return true;
    }
}
