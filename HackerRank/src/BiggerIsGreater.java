import java.io.*;

public class BiggerIsGreater {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        char[] chars = w.toCharArray();

        int pivot = chars.length - 1;
        while (pivot > 0 && chars[pivot - 1] >= chars[pivot])
            pivot--;

        if (pivot <= 0)
            return "no answer";
        else
            pivot--;

        int rightmost = chars.length - 1;
        while (chars[pivot] >= chars[rightmost])
            rightmost--;

        swap(chars, pivot, rightmost);

        rightmost = chars.length - 1;
        while (pivot + 1 < rightmost) {
            swap(chars, pivot + 1, rightmost);
            pivot++;
            rightmost--;
        }

        return String.valueOf(chars);
    }

    static void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int TItr = 0; TItr < T; TItr++) {
            String w = br.readLine();

            String result = biggerIsGreater(w);

            bw.write(result);
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
