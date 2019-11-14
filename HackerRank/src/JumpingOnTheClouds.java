import java.io.*;
import java.util.StringTokenizer;

public class JumpingOnTheClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int len = c.length;
        int step = k % len;

        energy -= (c[step] * 2 + 1);

        while (step != 0) {
            step = (step + k) % len;
            energy -= (c[step] * 2 + 1);
        }

        return energy;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] c = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        int result = jumpingOnClouds(c, k);

        bw.write(String.valueOf(result));
        bw.newLine();

        bw.close();
        br.close();
    }
}
