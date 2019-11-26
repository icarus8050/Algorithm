import java.io.*;
import java.util.StringTokenizer;

public class QueensAttack2 {

    static int rT_obstacle = -1;
    static int cT_obstacle = -1;

    static int rTR_obstacle = -1;
    static int cTR_obstacle = -1;

    static int rR_obstacle = -1;
    static int cR_obstacle = -1;

    static int rBR_obstacle = -1;
    static int cBR_obstacle = -1;

    static int rB_obstacle = -1;
    static int cB_obstacle = -1;

    static int rBL_obstacle = -1;
    static int cBL_obstacle = -1;

    static int rL_obstacle = -1;
    static int cL_obstacle = -1;

    static int rTL_obstacle = -1;
    static int cTL_obstacle = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r_q = Integer.parseInt(st.nextToken());
        int c_q = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int row_obstacle = Integer.parseInt(st.nextToken());
            int col_obstacle = Integer.parseInt(st.nextToken());

            //top
            if (isTopMinObstacle(r_q, c_q, row_obstacle, col_obstacle)) {
                rT_obstacle = row_obstacle;
                cT_obstacle = col_obstacle;
            }

            //top right
            if (isTopRightMinObstacle(r_q, c_q, row_obstacle, col_obstacle)) {
                rTR_obstacle = row_obstacle;
                cTR_obstacle = col_obstacle;
            }

            //right
            if (isRightMinObstacle(r_q, c_q, row_obstacle, col_obstacle)) {
                rR_obstacle = row_obstacle;
                cR_obstacle = col_obstacle;
            }

            //bottom right
            if (isBottomRightMinObstacle(r_q, c_q, row_obstacle, col_obstacle)) {
                rBR_obstacle = row_obstacle;
                cBR_obstacle = col_obstacle;
            }

            //bottom
            if (isBottomMinObstacle(r_q, c_q, row_obstacle, col_obstacle)) {
                rB_obstacle = row_obstacle;
                cB_obstacle = col_obstacle;
            }

            //bottom left
            if (isBottomLeftMinObstacle(r_q, c_q, row_obstacle, col_obstacle)) {
                rBL_obstacle = row_obstacle;
                cBL_obstacle = col_obstacle;
            }

            //left
            if (isLeftMinObstacle(r_q, c_q, row_obstacle, col_obstacle)) {
                rL_obstacle = row_obstacle;
                cL_obstacle = col_obstacle;
            }

            //top left
            if (isTopLeftMinObstacle(r_q, c_q, row_obstacle, col_obstacle)) {
                rTL_obstacle = row_obstacle;
                cTL_obstacle = col_obstacle;
            }
        }

        result += (rT_obstacle != -1) ? (rT_obstacle - r_q - 1) : n - r_q;  //top
        result += (cR_obstacle != -1) ? (cR_obstacle - c_q - 1) : n - c_q;  //right
        result += (rB_obstacle != -1) ? (r_q - rB_obstacle - 1) : r_q - 1;  //bottom
        result += (cL_obstacle != -1) ? (c_q - cL_obstacle - 1) : c_q - 1;  //left

        result += (rTR_obstacle != -1) ? (cTR_obstacle - c_q - 1) : Math.min(n - c_q, n - r_q); //top right
        result += (rBR_obstacle != -1) ? (cBR_obstacle - c_q - 1) : Math.min(n - c_q, r_q - 1); //bottom right
        result += (rBL_obstacle != -1) ? (c_q - cBL_obstacle - 1) : Math.min(c_q - 1, r_q - 1); //bottom left
        result += (cTL_obstacle != -1) ? (c_q - cTL_obstacle - 1) : Math.min(c_q - 1, n - r_q); //top left

        bw.write(String.valueOf(result));
        bw.newLine();

        bw.close();
        br.close();
    }

    private static boolean isTopMinObstacle(int r_q, int c_q, int row_obstacle, int col_obstacle) {
        return (row_obstacle > r_q && col_obstacle == c_q) && (rT_obstacle > row_obstacle || rT_obstacle == -1);
    }

    private static boolean isTopRightMinObstacle(int r_q, int c_q, int row_obstacle, int col_obstacle) {
        return (row_obstacle - r_q == col_obstacle - c_q && row_obstacle > r_q && col_obstacle > c_q)
                && ((rTR_obstacle > row_obstacle && cTR_obstacle > col_obstacle) || rTR_obstacle == -1);
    }

    private static boolean isRightMinObstacle(int r_q, int c_q, int row_obstacle, int col_obstacle) {
        return (col_obstacle > c_q && row_obstacle == r_q) && (cR_obstacle > col_obstacle || cR_obstacle == -1);
    }

    private static boolean isBottomRightMinObstacle(int r_q, int c_q, int row_obstacle, int col_obstacle) {
        return (r_q - row_obstacle == col_obstacle - c_q && r_q > row_obstacle && col_obstacle > c_q)
                && ((row_obstacle > rBR_obstacle && cBR_obstacle > col_obstacle) || rBR_obstacle == -1);
    }

    private static boolean isBottomMinObstacle(int r_q, int c_q, int row_obstacle, int col_obstacle) {
        return (r_q > row_obstacle && col_obstacle == c_q) && (row_obstacle > rB_obstacle || rB_obstacle == -1);
    }

    private static boolean isBottomLeftMinObstacle(int r_q, int c_q, int row_obstacle, int col_obstacle) {
        return (r_q - row_obstacle == c_q - col_obstacle && r_q > row_obstacle && c_q > col_obstacle)
                && ((row_obstacle > rBL_obstacle && col_obstacle > cBL_obstacle) || rBL_obstacle == -1);
    }

    private static boolean isLeftMinObstacle(int r_q, int c_q, int row_obstacle, int col_obstacle) {
        return (c_q > col_obstacle && r_q == row_obstacle) && (col_obstacle > cL_obstacle || cL_obstacle == -1);
    }

    private static boolean isTopLeftMinObstacle(int r_q, int c_q, int row_obstacle, int col_obstacle) {
        return (row_obstacle - r_q == c_q - col_obstacle && row_obstacle > r_q && c_q > col_obstacle)
                && ((rTL_obstacle > row_obstacle && col_obstacle > cTL_obstacle) || rTL_obstacle == -1);
    }
}
