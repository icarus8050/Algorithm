import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 유레카 이론 (https://www.acmicpc.net/problem/10448)
 */
public class BOJ_10448 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[][] table = new boolean[3][1001];
        int u;
        for (int i = 1; (u = i * (i + 1) / 2) < 1000; i++) {
            table[0][u] = true;

            for (int j = 1; j <= 2; j++) {
                for (int k = u + 1; k <= 1000; k++) {
                    if (table[j - 1][k - u]) table[j][k] = true;
                }
            }
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (table[2][num]) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
