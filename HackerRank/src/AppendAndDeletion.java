import java.io.*;

public class AppendAndDeletion {

    static String YES = "Yes";
    static String NO = "No";

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();
        int sLen = s.length();
        int tLen = t.length();

        int index;

        for (index = 0; index < Math.min(sLen, tLen); index++) {
            if (chS[index] != chT[index]) {
                break;
            }
        }

        if (sLen + tLen - 2 * index > k) {
            return NO;
        } else if ((sLen + tLen - 2 * index) % 2 == k % 2) {
            return YES;
        } else if ((sLen + tLen - k) < 0) {
            return YES;
        } else {
            return NO;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String t = br.readLine();

        int k = Integer.parseInt(br.readLine());

        String result = appendAndDelete(s, t, k);

        bw.write(result);
        bw.newLine();

        br.close();
        bw.close();
    }
}
