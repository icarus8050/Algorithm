import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 최소, 최대 (https://www.acmicpc.net/problem/10818)
 */
public class BOJ_10818 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] numbers = br.readLine().split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(numbers[i]);

            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        bw.write(min + " " + max);
        bw.newLine();
        bw.close();
        br.close();
    }
}
