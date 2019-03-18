import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		int[] pro = {93, 30, 55};
		int[] sp = {1, 30, 5};
		int[] res = solution(pro, sp);
		for (int num : res)
			System.out.print(num + " ");
	}
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        int idx = 0;
        int cnt = 0;
        int len = progresses.length;
        while (0 != len) {
        	for (int i = 0; i < progresses.length; i++) {
        		if (progresses[i] > 0 && progresses[i] < 100) {
        			progresses[i] += speeds[i];
        		}
        	}
        	
        	if (progresses[idx] >= 100) {
        		for (int i = idx; i < progresses.length; i++) {
        			if (progresses[i] >= 100) {
        				progresses[i] = -1;
        				cnt++;
        			}
        			else {
        				idx = i;
        				break;
        			}
        		}
        		list.add(cnt);
        		len -= cnt;
        		cnt = 0;
        	}
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	
	public static int[] solution_2(int[] progresses, int[] speeds) {
		Queue<Integer> progress_queue = new LinkedList<Integer>();
		Queue<Integer> answer_queue = new LinkedList<Integer>();
		
		for (int i = 0; i < progresses.length; i++) {
			int need = (100 - progresses[i]) / speeds[i];
			if ((100 - progresses[i]) % speeds[i] > 0)
				need++;
			progress_queue.offer(need);
		}
		
		while (!progress_queue.isEmpty()) {
			int cur = progress_queue.poll();
			int cnt = 1;
			while (!progress_queue.isEmpty() && cur >= progress_queue.peek()) {
				progress_queue.poll();
				cnt++;
			}
			answer_queue.offer(cnt);
		}
		int size = answer_queue.size();
		int[] answer = new int[size];
		for (int i = 0; i < size; i++)
			answer[i] = answer_queue.poll();
		
		return answer;
	}
}
