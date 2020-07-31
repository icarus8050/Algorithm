import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 행렬 곱셈 순서 (https://www.acmicpc.net/problem/11049)
 */
public class BOJ_11049 {

    static int[][] dp;
    static Matrix[] mat;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        mat = new Matrix[n];
        dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            String[] RC = br.readLine().split(" ");
            int r = Integer.parseInt(RC[0]);
            int c = Integer.parseInt(RC[1]);
            mat[i] = new Matrix(r, c);
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        bw.write(solve(0, n - 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int solve(int x, int y) {
        if (x == y) return 0;
        if (dp[x][y] != -1) return dp[x][y];
        
        int min = Integer.MAX_VALUE;

        for (int k = x; k < y; k++) {
            min = Math.min(min, solve(x, k) + solve(k + 1, y) + mat[x].r * mat[k].c * mat[y].c);
        }

        return dp[x][y] = min;
    }

    static class Matrix {
        int r;
        int c;

        Matrix(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
