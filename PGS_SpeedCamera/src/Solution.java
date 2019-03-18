import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	
	public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
        });
        
        int exit = -300000;
        for (int i = 0; i < routes.length; i++) {
        	if (exit < routes[i][0]) {
        		answer++;
        		exit = routes[i][1];
        	}
        }
        return answer;
    }
}
