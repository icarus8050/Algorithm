import java.util.Arrays;

public class Solution {

	public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int size = people.length;
        int i = 0, j = 0;
        for (i = size - 1; i > j; i--) {
        	if (people[i] + people[j] <= limit) {
        		j++;
        		answer++;
        	} else
        		answer++;
        }
        if (i == j)
        	answer++;
        return answer;
    }
}
