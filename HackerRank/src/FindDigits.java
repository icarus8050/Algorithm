import java.io.*;

public class FindDigits {

    // Complete the findDigits function below.
    static int findDigits(int n) {
        int ans = 0;
        int val = n;

        while (n != 0) {
            int digit = n % 10;

            if ((digit != 0) && (val % digit == 0)){
                ans++;
            }

            n /= 10;
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(br.readLine());
            int result = findDigits(n);

            bw.write(String.valueOf(result));
            bw.newLine();
        }

        bw.close();
        br.close();

    }
}
