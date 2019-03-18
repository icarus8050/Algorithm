
public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] arr = sol.solution(10, 2);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
	}
	public int[] solution(int brown, int red) {
        int[] answer = {0, 0};
        
        for (int h = 1; h <= red; h++) {
        	if (red % h == 0) {
        		int col = red / h;
        		int cnt = h * 2 + col * 2 + 4;
        		if (cnt == brown) {
        			answer[0] = col + 2;
        			answer[1] = h + 2;
        			break;
        		}
        	}
        }
        return answer;
    }
}
