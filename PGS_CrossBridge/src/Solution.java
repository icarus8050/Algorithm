import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) {
		int b = 2;
		int weight = 10;
		int[] arr = {3, 4, 1};
		System.out.println(solution(b, weight, arr));
	}
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int size = truck_weights.length;
        int cur_weight = 0;
        
        Queue<Integer> bridge = new LinkedList<Integer>();
        for (int i = 0; i < bridge_length; i++)
        	bridge.offer(0);
        Queue<Integer> trucks = new LinkedList<Integer>();
        for (int i = 0; i < truck_weights.length; i++)
        	trucks.offer(truck_weights[i]);
        
        while (!bridge.isEmpty()) {
        	answer++;
        	int truck = bridge.poll();
        	cur_weight -= truck;
        	if (!trucks.isEmpty()) {
        		if (weight >= cur_weight + trucks.peek()) {
        			truck = trucks.poll();
        			bridge.offer(truck);
        			cur_weight += truck;
        		} else {
        			bridge.offer(0);
        		}
        	}
        }
        return answer;
    }
}
