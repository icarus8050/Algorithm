import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Ema's Supercomputer (https://www.hackerrank.com/challenges/two-pluses/problem)
 */
public class EmaSupercomputer {

    static int r, c;
    static String[] map;
    static List<Plus> pluses = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] rc = br.readLine().split(" ");
        r = Integer.parseInt(rc[0]);
        c = Integer.parseInt(rc[1]);
        map = new String[r];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i].charAt(j) != 'B') {
                    findPlus(j, i);
                }
            }
        }

        int max = 0;
        int plusesSize = pluses.size();
        for (int i = 0; i < plusesSize - 1; i++) {
            Plus plus_1 = pluses.get(i);

            for (int j = i + 1; j < plusesSize; j++) {
                Plus plus_2 = pluses.get(j);

                if (!plus_1.overlaps(plus_2)) {
                    max = Math.max(max, (plus_1.size * plus_2.size));
                }
            }
        }

        bw.write(max + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void findPlus(int x, int y) {
        Plus plus = new Plus(x, y);
        int len = 1;

        while (y - len >= 0 && map[y - len].charAt(x) != 'B'
                && y + len < r && map[y + len].charAt(x) != 'B'
                && x - len >= 0 && map[y].charAt(x - len) != 'B'
                && x + len < c && map[y].charAt(x + len) != 'B') {
            pluses.add(new Plus(plus.x, plus.y, plus.len, plus.size));
            plus.grow();
            len++;
        }

        pluses.add(plus);
    }

    static class Plus {
        int x;
        int y;
        int len;
        int size;

        public Plus(int x, int y) {
            this.x = x;
            this.y = y;
            this.len = 0;
            this.size = 1;
        }

        public Plus(int x, int y, int len, int size) {
            this.x = x;
            this.y = y;
            this.len = len;
            this.size = size;
        }

        public void grow() {
            this.len++;
            this.size += 4;
        }

        public boolean overlaps(Plus target) {
            boolean[][] grid = new boolean[r][c];

            for(int i = this.x - this.len; i <= this.x + this.len; i++) {
                grid[this.y][i] = true;
            }

            for(int i = this.y - this.len; i <= this.y + this.len; i++) {
                grid[i][this.x] = true;
            }

            for(int i = target.x - target.len; i <= target.x + target.len; i++) {
                if(grid[target.y][i]) return true;
            }

            for(int i = target.y - target.len; i <= target.y + target.len; i++) {
                if(grid[i][target.x]) return true;
            }

            return false;
        }
    }
}
