import java.io.*;

public class ViralAdvertising {

    static int viralAdvertising(int n) {
        int shared = 5;
        int liked = 0;
        int cumulative = 0;

        for (int i = 0; i < n; i++) {
            liked = shared / 2;
            cumulative += liked;
            shared = liked * 3;
        }

        return cumulative;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int result = viralAdvertising(n);

        bw.write(Integer.toString(result));

        bw.flush();
        bw.close();
        br.close();
    }
}
