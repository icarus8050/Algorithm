import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MinimumDistances {

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        int minValue = Integer.MAX_VALUE;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                int index = map.get(a[i]);
                int dist = i - index;

                if (dist < minValue) {
                    minValue = dist;
                }

                map.put(a[i], i);
            } else {
                map.put(a[i], i);
            }
        }

        if (minValue == Integer.MAX_VALUE)
            return -1;

        return minValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];

        String[] aItems = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        bw.write(String.valueOf(result));
        bw.newLine();

        bw.close();
        br.close();
    }
}
