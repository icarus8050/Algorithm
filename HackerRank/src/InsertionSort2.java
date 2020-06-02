import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Insertion Sort - Part2 (https://www.hackerrank.com/challenges/insertionsort2/problem)
 */
public class InsertionSort2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                arr[j + 1] = arr[j];
            }

            arr[j + 1] = temp;

            for (j = 0; j < n; j++) {
                bw.write(arr[j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
