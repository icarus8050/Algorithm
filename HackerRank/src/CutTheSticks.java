import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CutTheSticks {
    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        List<Integer> ansList = new ArrayList<>();

        Arrays.sort(arr);
        int i = 0;
        int shortLen = arr[i];
        while (i < arr.length) {
            ansList.add(arr.length - i);

            while (i < arr.length && shortLen == arr[i]) {
                i++;
            }

            if (i < arr.length) {
                shortLen = arr[i];
            }
        }

        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        String[] arrItems = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bw.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();
        bw.close();
        br.close();
    }
}
