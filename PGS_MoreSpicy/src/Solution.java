import java.util.PriorityQueue;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] a = {1, 2, 3, 9, 10, 12};
		System.out.println(sol.solution(a, 7));
	}
	public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pri_queue = new PriorityQueue<Integer>();
        
        int size = scoville.length;
        for (int i = 0; i < size; i++)
        	pri_queue.offer(scoville[i]);
        
        while (!pri_queue.isEmpty()) {
        	if (K > pri_queue.peek()) {
        		if (pri_queue.size() >= 2) {
        			int a = pri_queue.poll();
        			int b = pri_queue.poll() * 2;
        			pri_queue.offer(a + b);
        			answer++;
        		} else {
        			answer = -1;
        			break;
        		}
        	} else
        		break;
        }
        return answer;
    }
}
