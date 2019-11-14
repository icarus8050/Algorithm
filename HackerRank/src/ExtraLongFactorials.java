import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {

        BigInteger bigInteger = BigInteger.ONE;

        for (long i = n; i > 0; i--) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }

        System.out.println(bigInteger.toString());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();

        extraLongFactorials(n);

        scanner.close();
    }
}
