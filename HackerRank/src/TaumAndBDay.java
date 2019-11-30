import java.io.*;
import java.math.BigDecimal;
import java.util.stream.IntStream;

public class TaumAndBDay {

    /*
     * Complete the 'taumBday' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER b
     *  2. INTEGER w
     *  3. INTEGER bc
     *  4. INTEGER wc
     *  5. INTEGER z
     */

    public static BigDecimal taumBday(int b, int w, int bc, int wc, int z) {
        // Write your code here

        int blackCost = Math.min(bc, wc + z);
        int whiteCost = Math.min(wc, bc + z);

        BigDecimal totalBlackCost = new BigDecimal(blackCost);
        BigDecimal totalWhiteCost = new BigDecimal(whiteCost);

        totalBlackCost = totalBlackCost.multiply(BigDecimal.valueOf(b));
        totalWhiteCost = totalWhiteCost.multiply(BigDecimal.valueOf(w));

        return totalBlackCost.add(totalWhiteCost);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = br.readLine().replaceAll("\\s+$", "").split(" ");

                int b = Integer.parseInt(firstMultipleInput[0]);

                int w = Integer.parseInt(firstMultipleInput[1]);

                String[] secondMultipleInput = br.readLine().replaceAll("\\s+$", "").split(" ");

                int bc = Integer.parseInt(secondMultipleInput[0]);

                int wc = Integer.parseInt(secondMultipleInput[1]);

                int z = Integer.parseInt(secondMultipleInput[2]);

                BigDecimal result = TaumAndBDay.taumBday(b, w, bc, wc, z);

                bw.write(result.toString());
                bw.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        br.close();
        bw.close();
    }

}