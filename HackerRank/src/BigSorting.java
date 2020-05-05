import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Big Sorting (https://www.hackerrank.com/challenges/big-sorting/problem)
 */
public class BigSorting {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> nums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nums.add(br.readLine());
        }

        nums.sort((a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }

            return a.length() - b.length();
        });

        for (String num : nums) {
            bw.write(num);
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
