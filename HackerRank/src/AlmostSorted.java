import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Almost Sorted (https://www.hackerrank.com/challenges/almost-sorted/problem)
 */
public class AlmostSorted {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        if (isSorted(arr)) {
            bw.write("yes\n");
        } else {
            int i, j;
            for (i = 0; i < n - 1 && arr[i] < arr[i + 1] ; i++);
            for (j = n - 1; j > 0 && arr[j - 1] < arr[j] ; j--);

            swap(arr, i, j);
            if (isSorted(arr)) {
                bw.write("yes\nswap " + (i + 1) + " " + (j + 1) + "\n");
            } else {
                int k = i + 1, l = j - 1;
                while (l > k) {
                    swap(arr, k++, l--);
                }

                if (isSorted(arr)) {
                    bw.write("yes\nreverse " + (i + 1) + " " + (j + 1) + "\n");
                } else {
                    bw.write("no\n");
                }
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean isSorted(int[] arr) {
        int len = arr.length - 1;
        for (int i = 0; i < len; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
