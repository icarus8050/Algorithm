import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class NonDivisibleSubset {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        int res = 0;

        int[] remainder = new int[k];

        for (Integer i : s) {
            remainder[i % k]++;
        }

        if (remainder[0] > 0) res++;

        for (int i = 1; i <= k / 2; i++) {
            if (i != k - i) res += Math.max(remainder[i], remainder[k - i]);
            else if (remainder[i] > 0) res++;
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = br.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(br.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = nonDivisibleSubset(k, s);

        bw.write(String.valueOf(result));
        bw.newLine();

        br.close();
        bw.close();
    }
}
