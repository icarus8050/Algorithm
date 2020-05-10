import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Intro to Tutorial Challenge (https://www.hackerrank.com/challenges/tutorial-intro/problem)
 */
public class IntroToTutorialChallenges {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int v = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        String[] inputs = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int searchValue = Integer.parseInt(inputs[i]);

            if (searchValue == v) {
                bw.write(i + "\n");
                break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
