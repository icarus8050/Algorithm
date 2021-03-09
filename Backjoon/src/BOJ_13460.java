import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 구슬 탈출 2 (https://www.acmicpc.net/problem/13460)
 */
public class BOJ_13460 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        map = new char[n][m];
        int ans = -1;
        int targetX = 0, targetY = 0;
        boolean[][][][] visited = new boolean[n][m][n][m];
        Position position = new Position();
        Queue<Position> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                char c = input.charAt(j);
                map[i][j] = c;

                if (c == 'R') {
                    position.redX = j;
                    position.redY = i;
                }

                if (c == 'B') {
                    position.blueX = j;
                    position.blueY = i;
                }

                if (c == 'O') {
                    targetX = j;
                    targetY = i;
                }
            }
        }

        queue.add(position);
        visited[position.redY][position.redX][position.blueY][position.blueX] = true;
        while (!queue.isEmpty()) {
            Position cur = queue.poll();

            if (cur.count > 10) {
                break;
            }

            if (cur.redY == targetY && cur.redX == targetX) {
                ans = cur.count;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int[] nextRed = move(cur.redX, cur.redY, i);
                int[] nextBlue = move(cur.blueX, cur.blueY, i);
                int nextRedX = nextRed[0];
                int nextRedY = nextRed[1];
                int nextBlueX = nextBlue[0];
                int nextBlueY = nextBlue[1];

                if (nextBlueX == targetX && nextBlueY == targetY) {
                    continue;
                }

                if (nextRedX == nextBlueX && nextRedY == nextBlueY) {
                    if (i == 0) {
                        if (cur.redX < cur.blueX) nextBlueX++;
                        else nextRedX++;

                    } else if (i == 1) {
                        if (cur.redY < cur.blueY) nextBlueY++;
                        else nextRedY++;

                    } else if (i == 2) {
                        if (cur.redX < cur.blueX) nextRedX--;
                        else nextBlueX--;

                    } else {
                        if (cur.redY < cur.blueY) nextRedY--;
                        else nextBlueY--;
                    }
                }

                if (!visited[nextRedY][nextRedX][nextBlueY][nextBlueX]) {
                    Position nextPos = new Position();
                    nextPos.redX = nextRedX;
                    nextPos.redY = nextRedY;
                    nextPos.blueX = nextBlueX;
                    nextPos.blueY = nextBlueY;
                    nextPos.count = cur.count + 1;
                    queue.add(nextPos);
                    visited[nextRedY][nextRedX][nextBlueY][nextBlueX] = true;
                }
            }
        }

        System.out.println(ans);
    }

    private static int[] move(int x, int y, int d) {
        int[] result = new int[2];

        while (true) {
            x += dx[d];
            y += dy[d];
            if (map[y][x] == '#') {
                x -= dx[d];
                y -= dy[d];
                break;
            }

            if (map[y][x] == 'O') {
                break;
            }
        }

        result[0] = x;
        result[1] = y;
        return result;
    }

    static class Position {
        int redY;
        int redX;
        int blueY;
        int blueX;
        int count = 0;
    }
}
