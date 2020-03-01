import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 부녀회장이 될테야 (https://www.acmicpc.net/problem/2775)
 */
public class BOJ_2775 {

    static int[][] apart;
    static int k, n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());

            apart = new int[k + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                apart[0][i] = i;
            }

            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    apart[i][j] = apart[i][j - 1] + apart[i - 1][j];
                }
            }

            bw.write(apart[k][n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
