import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Quicksort 1 - Partition (https://www.hackerrank.com/challenges/quicksort1/problem)
 */
public class Quicksort1_Partition {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int pivot = arr[0];
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > pivot) {
                right.add(arr[i]);
            } else {
                left.add(arr[i]);
            }
        }

        left.add(pivot);
        left.addAll(right);

        for (Integer integer : left) {
            bw.write(integer + " ");
        }
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
