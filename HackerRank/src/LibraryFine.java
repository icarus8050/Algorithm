import java.io.*;
import java.util.StringTokenizer;

public class LibraryFine {

    // Complete the libraryFine function below.
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        if (y1 > y2)
            return 10000;

        if (y1 == y2) {
            if (m1 > m2) {
                return (m1 - m2) * 500;
            }

            if (m1 == m2 && d1 > d2) {
                return (d1 - d2) * 15;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int d1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int d2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        int result = libraryFine(d1, m1, y1, d2, m2, y2);

        bw.write(String.valueOf(result));
        bw.newLine();

        bw.close();
        br.close();
    }
}
