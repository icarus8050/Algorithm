import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> pri_queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        Queue<Print> queue = new LinkedList<Print>();
        
        for (int i = 0; i < priorities.length; i++) {
        	pri_queue.offer(priorities[i]);
        	queue.offer(new Print(i, priorities[i]));
        }
        while (!queue.isEmpty()) {
        	Print cur = queue.poll();
        	
        	if (cur.importance >= pri_queue.peek()) {
        		answer++;
        		pri_queue.poll();
        		if (cur.location == location)
        			break;
        	}
        	else
        		queue.offer(cur);
        }
        return answer;
    }
}

class Print {
	int location;
	int importance;
	
	public Print(int location, int importance) {
		this.location = location; this.importance = importance;
	}
}