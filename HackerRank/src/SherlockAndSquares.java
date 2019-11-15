import java.io.*;
import java.util.StringTokenizer;

public class SherlockAndSquares {

    // Complete the squares function below.
    static int squares(int a, int b) {
        int start = (int) Math.ceil(Math.sqrt(a));
        int end = (int) Math.floor(Math.sqrt(b));

        return end - start + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int q = Integer.parseInt(br.readLine());

        for (int qItr = 0; qItr < q; qItr++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = squares(a, b);

            bw.write(String.valueOf(result));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
