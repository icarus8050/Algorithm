import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 찍기 (https://www.acmicpc.net/problem/2966)
 */
public class BOJ_2966 {

    static char[] Adrian = {'A', 'B', 'C'};
    static int adrianAns = 0;

    static char[] Bruno = {'B', 'A', 'B', 'C'};
    static int brunoAns = 0;

    static char[] Goran = {'C', 'C', 'A', 'A', 'B', 'B'};
    static int goranAns = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        char[] problems = br.readLine().toCharArray();
        int size = problems.length;

        for (int i = 0; i < size; i++) {
            if (problems[i] == Adrian[i % 3]) {
                adrianAns++;
            }

            if (problems[i] == Bruno[i % 4]) {
                brunoAns++;
            }

            if (problems[i] == Goran[i % 6]) {
                goranAns++;
            }
        }

        int max = Math.max(adrianAns, Math.max(brunoAns, goranAns));

        bw.write(max + "\n");
        if (adrianAns == max) bw.write("Adrian\n");
        if (brunoAns == max) bw.write("Bruno\n");
        if (goranAns == max) bw.write("Goran\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
