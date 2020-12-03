/**
 * 삼각 달팽이 (https://programmers.co.kr/learn/courses/30/lessons/68645?language=java)
 */
public class TriangleSnail {
    public int[] solution(int n) {
        if (n == 1) return new int[]{1};
        int size = n * (n + 1) / 2;
        int[][] mat = new int[n][n];
        int[] answer = new int[size];

        int startR = 0, startC = 0;
        int endR = n - 2, endC = n - 2;
        int r = 0, c = 0;
        int val = 1;

        while (val <= size) {
            while (r <= endR && mat[r][c] == 0 && val <= size) {
                mat[r++][c] = val++;
            }

            while (c <= endC && mat[r][c] == 0 && val <= size) {
                mat[r][c++] = val++;
            }

            while (r > startR && c > startC && mat[r][c] == 0 && val <= size) {
                mat[r--][c--] = val++;
            }
            startR += 2;
            startC += 1;
            endR -= 1;
            endC -= 2;
            if (startR > endR)
                endR = startR;
            if (startC > endC)
                endC = startC;
            r = startR;
            c = startC;
        }

        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                answer[k++] = mat[i][j];
            }
        }

        return answer;
    }
}
