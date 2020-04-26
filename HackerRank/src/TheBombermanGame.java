import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * The Bomberman Game (https://www.hackerrank.com/challenges/bomber-man/problem)
 */
public class TheBombermanGame {
    static int r, c;
    static long n;
    static char[][] input_pattern, full_pattern, first_pattern, second_pattern;
    //input_pattern 은 초기 입력된 폭탄 배열 패턴
    //full_pattern 은 모든 셀이 폭탄으로 채워져 있는 패턴
    //first_pattern 은 input_pattern 에서 폭탄이 터지고 난 후의 패턴
    //second_pattern 은 first_pattern 에서 폭탄이 터지고 난 후의 패턴
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] rcn = br.readLine().split(" ");
        r = Integer.parseInt(rcn[0]);
        c = Integer.parseInt(rcn[1]);
        n = Long.parseLong(rcn[2]);
        input_pattern = new char[r][c];
        full_pattern = new char[r][c];
        first_pattern = new char[r][c];
        second_pattern = new char[r][c];

        //pattern init
        for (int i = 0; i < r; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                input_pattern[i][j] = chars[j];
                full_pattern[i][j] = 'O';
                first_pattern[i][j] = 'O';
                second_pattern[i][j] = 'O';
            }
        }

        //processing first_pattern using input_pattern
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (input_pattern[i][j] == 'O') {
                    first_pattern[i][j] = '.';
                    if (i < r - 1) first_pattern[i + 1][j] = '.';
                    if (i > 0) first_pattern[i - 1][j] = '.';
                    if (j < c - 1) first_pattern[i][j + 1] = '.';
                    if (j > 0) first_pattern[i][j - 1] = '.';
                }
            }
        }

        //processing second_pattern using first_pattern
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (first_pattern[i][j] == 'O') {
                    second_pattern[i][j] = '.';
                    if (i < r - 1) second_pattern[i + 1][j] = '.';
                    if (i > 0) second_pattern[i - 1][j] = '.';
                    if (j < c - 1) second_pattern[i][j + 1] = '.';
                    if (j > 0) second_pattern[i][j - 1] = '.';
                }
            }
        }

        if (n == 0 || n == 1) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    bw.write(input_pattern[i][j]);
                }
                bw.newLine();
            }
        } else if ((n - 1) % 4 == 0) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    bw.write(second_pattern[i][j]);
                }
                bw.newLine();
            }
        } else if ((n - 1) % 2 == 0) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    bw.write(first_pattern[i][j]);
                }
                bw.newLine();
            }
        } else {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    bw.write(full_pattern[i][j]);
                }
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }
}
