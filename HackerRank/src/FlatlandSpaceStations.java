import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Flatland Space Stations (https://www.hackerrank.com/challenges/flatland-space-stations/problem)
 */
public class FlatlandSpaceStations {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] cItems = br.readLine().split(" ");
        int[] c = new int[m];
        for (int i = 0; i < c.length; i++) {
            c[i] = Integer.parseInt(cItems[i]);
        }

        int[] a = new int[n];
        Arrays.fill(a, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            int station = c[i];

            for (int j = 0; j < n; j++) {
                if (j == station) {
                    a[j] = 0;
                } else if (a[j] > Math.abs(j - station)) {
                    a[j] = Math.abs(j - station);
                }
            }
        }
        Arrays.sort(a);
        bw.write(String.valueOf(a[n - 1]));
        bw.newLine();
        br.close();
        bw.close();
    }
}
