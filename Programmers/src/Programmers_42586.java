import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 기능개발 (https://programmers.co.kr/learn/courses/30/lessons/42586)
 */
public class Programmers_42586 {
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        int len = progresses.length;
        for (int i = 0; i < len; i++) {
            int remainsJob = 100 - progresses[i];
            int days =  remainsJob / speeds[i];
            if (remainsJob % speeds[i] > 0) {
                days++;
            }
            queue.add(days);
        }

        while (!queue.isEmpty()) {
            int days = queue.poll();
            int cnt = 1;

            while (!queue.isEmpty() && days >= queue.peek()) {
                queue.poll();
                cnt++;
            }

            ans.add(cnt);
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}
