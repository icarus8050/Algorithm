import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 직각삼각형 (https://www.acmicpc.net/problem/4153)
 */
public class BOJ_4153 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();
            if (input.equals("0 0 0")) break;

            String[] split = input.split(" ");
            int[] ints = Arrays.stream(split)
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            if ((ints[0] * ints[0] + ints[1] * ints[1]) == (ints[2] * ints[2])) {
                bw.write("right\n");
            } else {
                bw.write("wrong\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
