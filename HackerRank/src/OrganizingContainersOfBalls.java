import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class OrganizingContainersOfBalls {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(br.readLine());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(br.readLine());

            int[] containers = new int[n];
            int[] balls = new int[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    int ball = Integer.parseInt(st.nextToken());
                    containers[i] += ball;
                    balls[j] += ball;
                }
            }
            Arrays.sort(containers);
            Arrays.sort(balls);

            for (int i = 0; i < n; i++) {
                if (containers[i] != balls[i]) {
                    bw.write("Impossible");
                    break;
                } else if (i == (n - 1)) {
                    bw.write("Possible");
                }
            }
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
