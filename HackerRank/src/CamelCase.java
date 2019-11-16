import java.io.*;

public class CamelCase {
    // Complete the camelcase function below.
    static int camelcase(String s) {
        int ans = 1;
        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            if (aChar >= 65 && aChar <= 90)
                ans++;
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int result = camelcase(s);

        bw.write(String.valueOf(result));
        bw.newLine();

        bw.close();
        br.close();
    }
}
