import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {
        int col = (int) Math.ceil(Math.sqrt(s.length()));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < col; i++) {
            for (int j = i; j < s.length(); j += col) {
                sb.append(s.charAt(j));
            }
            sb.append(" ");
        }

        return sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String result = encryption(s);

        bw.write(result);
        bw.newLine();

        bw.close();

        scanner.close();
    }
}
