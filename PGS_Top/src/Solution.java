
public class Solution {

	public static void main(String[] args) {
		int[] test = {6, 9, 5, 7, 4};
		int[] a = solution(test);
		for (int n : a)
			System.out.print(n + " ");
	}
	public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        
        answer[0] = 0;
        for (int i = 1; i < heights.length; i++) {
        	for (int j = i - 1; j >= 0; j--) {
        		if (heights[j] > heights[i]) {
        			answer[i] = j + 1;
        			break;
        		}
        	}
        }
        
        return answer;
    }
}
