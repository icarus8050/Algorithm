import java.util.Arrays;

public class Solution {

	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int t = 0; t < commands.length; t++) {
        	int i = commands[t][0] - 1;
        	int j = commands[t][1];
        	int k = commands[t][2] - 1;
        	int[] temp = Arrays.copyOfRange(array, i, j);
        	Arrays.sort(temp);
        	answer[t] = temp[k];
        }
        return answer;
    }
}
