import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 유레카 이론 (https://www.acmicpc.net/problem/10448)
 */
public class BOJ_10448 {

    static int k;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            k = Integer.parseInt(br.readLine());
            if (dfs(0, 1, 0)) {
                bw.write(1 + "\n");
            } else {
                bw.write(0 + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean dfs(int count, int idx, int total) {
        if (count > 3) return false;
        if (count == 3 && total == k) return true;
        if (total > k) return false;

        for (int i = idx; i <= k; i++) {
            boolean ans = dfs(count + 1, i, total + (i * (i + 1) / 2));

            if (ans) return true;
        }

        return false;
    }
}
