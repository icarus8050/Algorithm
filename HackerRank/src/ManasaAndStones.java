import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Manasa and Stones (https://www.hackerrank.com/challenges/manasa-and-stones/problem)
 */
public class ManasaAndStones {

    static int n, a, b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            a = Integer.parseInt(br.readLine());
            b = Integer.parseInt(br.readLine());

            int small = Math.min(a, b);
            int big = Math.max(a, b);
            int add = big - small;
            int current = small * (n - 1);
            int max = big * (n - 1);

            bw.write(current + " ");
            while (current < max) {
                current += add;
                bw.write(current + " ");
            }

            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
