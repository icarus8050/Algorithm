import java.io.*;

public class BeautifulTriplets {

    // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {
        int ans = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {

                if (arr[j] - arr[i] > d) break;
                else if (arr[j] - arr[i] < d) continue;

                boolean flag = false;

                for (int k = j + 1; k < arr.length; k++) {

                    if (arr[k] - arr[j] > d)
                        break;
                    else if (arr[k] - arr[j] == d) {
                        flag = true;
                        ans++;
                        break;
                    }
                }

                if (flag) break;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nd = br.readLine().split(" ");

        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrItems[i]);
        }

        int result = beautifulTriplets(d, arr);

        bw.write(String.valueOf(result));
        bw.newLine();

        bw.close();
        br.close();
    }
}
