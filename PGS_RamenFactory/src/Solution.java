import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] a = {4, 10, 15};
		int[] b = {20, 5, 10};
		System.out.println(sol.solution(4, a, b, 30));
	}
	public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        
        PriorityQueue<Integer> pri_queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        int i = 0;
        while (stock < k) {
        	while (i < dates.length && dates[i] <= stock)
        		pri_queue.offer(supplies[i++]);
        	stock += pri_queue.poll();
        	answer++;
        }
        
        return answer;
    }
}