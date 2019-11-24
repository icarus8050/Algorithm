import java.io.*;

public class EqualizeTheArray {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        int[] arrCnt = new int[101];

        for (int i = 0; i < arr.length; i++)
            arrCnt[arr[i]]++;

        int maxCnt = 0;
        for (int i = 0; i < arrCnt.length; i++) {
            maxCnt = Math.max(maxCnt, arrCnt[i]);
        }

        return arr.length - maxCnt;
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

        int result = equalizeArray(arr);

        bw.write(String.valueOf(result));
        bw.newLine();

        bw.close();
        br.close();
    }
}
