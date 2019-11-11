import java.io.*;
import java.util.StringTokenizer;

public class SaveThePrisoner {

    // Complete the saveThePrisoner function below.
    static int saveThePrisoner(int n, int m, int s) {
        return ((m + s - 2) % n) + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tItr = 0; tItr < t; tItr++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int m = Integer.parseInt(st.nextToken());

            int s = Integer.parseInt(st.nextToken());

            int result = saveThePrisoner(n, m, s);

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
