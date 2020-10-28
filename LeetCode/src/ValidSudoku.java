import java.util.HashSet;
import java.util.Set;

/**
 * 36. Valid Sudoku (https://leetcode.com/problems/valid-sudoku/)
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();
            Set<Character> subBoxes = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;

                if (board[j][i] != '.' && !cols.add(board[j][i]))
                    return false;

                int subBoxRow = 3 * (i / 3);
                int subBoxCol = 3 * (i % 3);
                if (board[subBoxRow + j / 3][subBoxCol + j % 3] != '.'
                        && !subBoxes.add(board[subBoxRow + j / 3][subBoxCol + j % 3]))
                    return false;
            }
        }
        return true;
    }
}
