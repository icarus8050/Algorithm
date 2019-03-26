import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        
        PriorityQueue<Integer> max_queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> min_queue = new PriorityQueue<Integer>();
        StringTokenizer st;
        
        for (int i = 0; i < operations.length; i++) {
        	st = new StringTokenizer(operations[i]);
        	String command = st.nextToken();
        	int num = Integer.parseInt(st.nextToken());
        	
        	if (command.equals("I")) {
        		max_queue.offer(num);
        		min_queue.offer(num);
        	} else if (!max_queue.isEmpty()){
        		if (num == 1) {
        			int element = max_queue.poll();
        			min_queue.remove(element);
        		} else {
        			int element = min_queue.poll();
        			max_queue.remove(element);
        		}
        	}
        }
        if (!max_queue.isEmpty()) {
        	answer[0] = max_queue.poll();
        	answer[1] = min_queue.poll();
        }
        return answer;
    }
}
