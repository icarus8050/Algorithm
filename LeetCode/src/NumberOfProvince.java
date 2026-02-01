import java.util.LinkedList;
import java.util.Queue;

/**
 * 547. Number Of Province (https://leetcode.com/problems/number-of-provinces/description/)
 */
public class NumberOfProvince {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean [] isVisited = new boolean[n];
        int provinceCnt = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (isVisited[i]) {
                continue;
            }
            provinceCnt++;

            queue.add(i);
            while (!queue.isEmpty()) {
                int current = queue.poll();
                isVisited[current] = true;

                for (int j = i + 1; j < n; j++) {
                    if (isConnected[current][j] == 1 && !isVisited[j]) {
                        queue.add(j);
                    }
                }
            }
        }
        return provinceCnt;
    }
}
