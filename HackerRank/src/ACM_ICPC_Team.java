import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class ACM_ICPC_Team {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        BigInteger[] bits = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            bits[i] = new BigInteger(br.readLine(), 2);
        }

        int max = 0;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int knows = bits[i].or(bits[j]).bitCount();

                if (knows > max) {
                    max = knows;
                    cnt = 1;
                } else if (knows == max) {
                    cnt++;
                }
            }
        }
        bw.write(max + "\n");
        bw.write(cnt + "\n");

        br.close();
        bw.close();
    }
}
