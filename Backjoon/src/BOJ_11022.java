import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * A + B - 8 (https://www.acmicpc.net/problem/11022)
 */
public class BOJ_11022 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            bw.write(String.format("Case #%d: %d + %d = %d", i, a, b, a + b));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
