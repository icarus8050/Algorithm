/**
 * 36. Valid Sudoku (https://leetcode.com/problems/valid-sudoku/)
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (!checkRow(board) || !checkCol(board) || !checkSubBoxes(board))
            return false;
        return true;
    }

    private boolean checkRow(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] reputitionCheck = new boolean[10];

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int val = board[i][j] - '0';
                    if (reputitionCheck[val])
                        return false;

                    reputitionCheck[val] = true;
                }
            }
        }

        return true;
    }

    private boolean checkCol(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] reputitionCheck = new boolean[10];

            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int val = board[j][i] - '0';
                    if (reputitionCheck[val])
                        return false;

                    reputitionCheck[val] = true;
                }
            }
        }

        return true;
    }

    private boolean checkSubBoxes(char[][] board) {
        int[][] points = {
                {0, 0}, {0, 3}, {0, 6},
                {3, 0}, {3, 3}, {3, 6},
                {6, 0}, {6, 3}, {6, 6}
        };

        for (int p = 0; p < 9; p++) {
            boolean[] reputitionCheck = new boolean[10];
            int x = points[p][1];

            for (int i = points[p][0]; i < points[p][0] + 3; i++) {
                for (int j = points[p][1]; j < points[p][1] + 3; j++) {
                    if (board[i][j] != '.') {
                        int val = board[i][j] - '0';
                        if (reputitionCheck[val])
                            return false;

                        reputitionCheck[val] = true;
                    }
                }
            }
        }

        return true;
    }
}
