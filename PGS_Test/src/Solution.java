import java.util.ArrayList;

public class Solution {

	public int[] solution(int[] answers) {
        int[] answer;
        int[] p_1 = {1, 2, 3, 4, 5};
        int[] p_2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        
        int size = answers.length;
        for (int i = 0; i < size; i++) {
        	if (answers[i] == p_1[i % 5])
        		score[0]++;
        	
        	if (answers[i] == p_2[i % 8])
        		score[1]++;
        	
        	if (answers[i] == p_3[i % 10])
        		score[2]++;
        }
        int Max = Math.max(score[0], Math.max(score[1], score[2]));
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < score.length; i++) {
        	if (Max == score[i])
        		list.add(i + 1);
        }
        answer = new int[list.size()];
        int cnt = 0;
        for (int num : list)
        	answer[cnt++] = num;
        return answer;
    }
}
