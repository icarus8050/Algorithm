import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BOJ_6679 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 2992; i < 10000; i++) {
            int ten = calc(10, i);
            int twelve = calc(12, i);
            int sixteen = calc(16, i);

            if (ten == twelve && twelve == sixteen) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static int calc(int notation, int num) {
        int res = 0;

        while (num != 0) {
            res += (num % notation);
            num /= notation;
        }

        return res;
    }
}
