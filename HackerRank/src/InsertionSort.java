import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Insertion Sort - Part 1 (https://www.hackerrank.com/challenges/insertionsort1/problem)
 */
public class InsertionSort {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        int temp = arr[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (i == 0) {
                arr[i] = temp;
            } else if (arr[i - 1] > temp) {
                arr[i] = arr[i - 1];
            } else {
                arr[i] = temp;
                for (int j = 0; j < n; j++) {
                    bw.write(arr[j] + " ");
                }
                bw.newLine();
                break;
            }

            for (int j = 0; j < n; j++) {
                bw.write(arr[j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
