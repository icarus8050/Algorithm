import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Absolute Permutation (https://www.hackerrank.com/challenges/absolute-permutation/problem)
 */
public class AbsolutePermutation {

    static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] nk = br.readLine().split(" ");
            n = Integer.parseInt(nk[0]);
            k = Integer.parseInt(nk[1]);

            if (k == 0) {
                for (int i = 1; i <= n; i++) {
                    bw.write(i + " ");
                }
            } else if (n % (2 * k) == 0) {
                for (int i = 1; i <= n; i++) {
                    bw.write((i + k) + " ");
                    if (i % k == 0) k *= -1;
                }
            } else {
                bw.write("-1");
            }

            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
