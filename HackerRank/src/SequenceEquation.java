import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SequenceEquation {

    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {
        int[] result = new int[p.length];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < p.length; i++) {
            map.put(p[i], i + 1);
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(map.get(i + 1));
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] p = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(st.nextToken());
            p[i] = pItem;
        }

        int[] result = permutationEquation(p);

        for (int i = 0; i < result.length; i++) {
            bw.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
