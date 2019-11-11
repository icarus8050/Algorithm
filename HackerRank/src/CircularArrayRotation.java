import java.io.*;
import java.util.*;

public class CircularArrayRotation {

    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            result[i] = a[(a.length - (k % a.length) + queries[i]) % a.length];
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(st.nextToken());
            a[i] = aItem;
        }

        int[] queries = new int[q];

        for (int i = 0; i < q; i++) {
            int queriesItem = Integer.parseInt(br.readLine());
            queries[i] = queriesItem;
        }

        int[] result = circularArrayRotation(a, k, queries);

        for (int i = 0; i < result.length; i++) {
            bw.write(Integer.toString(result[i]));

            if (i != result.length - 1) {
                bw.write("\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
