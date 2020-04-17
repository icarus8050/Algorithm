import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Happy Ladybugs (https://www.hackerrank.com/challenges/happy-ladybugs/problem)
 */
public class HappyLadyBugs {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int g = Integer.parseInt(br.readLine());

        while (g-- > 0) {
            int n = Integer.parseInt(br.readLine());
            char[] board = br.readLine().toCharArray();
            Character[] wrappedBoard = new Character[n];

            for (int i = 0; i < n; i++) {
                wrappedBoard[i] = board[i];
            }

            bw.write(solve(wrappedBoard));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    public static String solve(Character[] wrappedBoard) {

        Map<Character, Long> collect = Arrays.stream(wrappedBoard)
                .collect(Collectors.groupingBy(
                        Character::charValue,
                        Collectors.counting())
                );

        if (collect.containsKey('_')) {
            for (Map.Entry<Character, Long> next : collect.entrySet()) {
                if (!next.getKey().equals('_') && next.getValue() < 2)
                    return "NO";
            }
        } else {
            Character prev = wrappedBoard[0];
            int cnt = 0;

            for (Character character : wrappedBoard) {
                if (character.equals(prev)) {
                    cnt++;
                } else {
                    if (cnt < 2) return "NO";

                    prev = character;
                    cnt = 1;
                }
            }

            if (cnt < 2) return "NO";
        }

        return "YES";
    }
}
