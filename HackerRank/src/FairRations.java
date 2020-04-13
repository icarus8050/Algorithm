import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Fair Rations (https://www.hackerrank.com/challenges/fair-rations/problem)
 */
public class FairRations {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] items = br.readLine().split(" ");

        int[] arr = new int[n];
        int positiveCheck = 0;
        for (int i = 0; i < items.length; i++) {
            arr[i] = Integer.parseInt(items[i]);
            positiveCheck += arr[i];
        }

        if (positiveCheck % 2 != 0) {
            bw.write("NO");
        } else {
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 != 0) {
                    arr[i] = arr[i] + 1;
                    arr[i + 1] = arr[i + 1] + 1;
                    cnt += 2;
                }
            }

            bw.write(String.valueOf(cnt));
        }

        bw.newLine();
        bw.close();
        br.close();
    }
}
