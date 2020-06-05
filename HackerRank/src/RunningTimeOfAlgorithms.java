import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Running time of algorithms (https://www.hackerrank.com/challenges/runningtime/problem)
 */
public class RunningTimeOfAlgorithms {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] inputs = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];

            int j;
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                arr[j + 1] = arr[j];
                ans++;
            }

            arr[j + 1] = temp;
        }

        bw.write(ans + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
