import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17492 {

    static final int BLANK = 0;
    static final int WALL = 1;
    static final int STONE = 2;
    static final int[] oneX = {1, 1, 1, 0, -1, -1, -1, 0};
    static final int[] oneY = {-1, 0, 1, 1, 1, 0, -1, -1};
    static final int[] twoX = {2, 2, 2, 0, -2, -2, -2, 0};
    static final int[] twoY = {-2, 0, 2, 2, 2, 0, -2, -2};

    static int N;
    static int[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (solve()) {
            bw.write("Possible\n");
        } else {
            bw.write("Impossible\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean solve() {

        if (stoneCheck())
            return true;

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {

                if (board[i][j] == STONE) {

                    for (int k = 0; k < 8; k++) {
                        int nx = j + twoX[k];
                        int ny = i + twoY[k];
                        int ax = j + oneX[k];
                        int ay = i + oneY[k];

                        if (isMovable(nx, ny, ax, ay)) {
                            board[i][j] = BLANK;
                            board[ay][ax] = BLANK;
                            board[ny][nx] = STONE;

                            if (solve()) {
                                return true;
                            }

                            board[i][j] = STONE;
                            board[ay][ax] = STONE;
                            board[ny][nx] = BLANK;
                        }
                    }

                }

            }
        }

        return false;
    }

    static boolean isMovable(int nx, int ny, int ax, int ay) {
        return (nx > 0 && nx < N - 1)
                && (ny > 0 && ny < N - 1)
                && (board[ay][ax] == STONE)
                && (board[ny][nx] == BLANK);
    }

    static boolean stoneCheck() {
        int count = 0;

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {

                if (board[i][j] == STONE)
                    count++;

                if (count > 1)
                    return false;
            }
        }

        return true;
    }
}
