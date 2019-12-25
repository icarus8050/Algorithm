import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14502
 */
public class BOJ_14502 {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int ans = 0;
    static final int EMPTY = 0;
    static final int WALL = 1;
    static final int VIRUS = 2;

    static final int[] dy = {1, 0, -1, 0};
    static final int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth) {
        if (depth == 3) {
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == VIRUS && !visited[i][j]) {
                        spreadsTheVirus(j, i);
                    }
                }
            }

            ans = Math.max(ans, checkSafeArea());

        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == EMPTY) {
                        map[i][j] = WALL;
                        dfs(depth + 1);
                        map[i][j] = EMPTY;
                    }
                }
            }
        }
    }

    public static void spreadsTheVirus(int x, int y) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValidArea(nx, ny) && map[y][x] == VIRUS) {
                spreadsTheVirus(nx, ny);
            }
        }
    }

    public static int checkSafeArea() {
        int res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == WALL) res++;
            }
        }

        return res;
    }

    public static boolean isValidArea(int x, int y) {
        return (x >= 0 && x < M) && (y >= 0 && y < N);
    }
}
