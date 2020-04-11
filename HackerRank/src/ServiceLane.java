import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

/**
 * Service Lane (https://www.hackerrank.com/challenges/service-lane/problem)
 */
public class ServiceLane {

    static int width[];

    static int[] serviceLane(int n, int[][] cases) {
        int[] result = new int[cases.length];

        for (int i = 0; i < cases.length; i++) {
            int min = IntStream.rangeClosed(cases[i][0], cases[i][1])
                    .map(operand -> width[operand])
                    .min()
                    .getAsInt();
            result[i] = min;
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nt = br.readLine().split(" ");
        int n = Integer.parseInt(nt[0]);
        int t = Integer.parseInt(nt[1]);

        width = new int[n];

        String[] widthItems = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int widthItem = Integer.parseInt(widthItems[i]);
            width[i] = widthItem;
        }

        int[][] cases = new int[t][2];

        for (int i = 0; i < t; i++) {
            String[] casesRowItems = br.readLine().split(" ");

            for (int j = 0; j < 2; j++) {
                int casesItem = Integer.parseInt(casesRowItems[j]);
                cases[i][j] = casesItem;
            }
        }

        int[] result = serviceLane(n, cases);

        for (int i = 0; i < result.length; i++) {
            bw.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();
        bw.close();
        br.close();
    }
}
