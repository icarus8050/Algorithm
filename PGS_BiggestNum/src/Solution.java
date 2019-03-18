import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] ar = {0, 0, 0, 0};
		System.out.println(sol.solution(ar));
	}
	public String solution(int[] numbers) {
        
        String[] str = new String[numbers.length];
        for (int i = 0 ; i < str.length; i++)
        	str[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
        
        StringBuilder sb = new StringBuilder();
        if (str[0].equals("0"))
        	sb.append("0");
        else {
        	for (int i = 0; i < str.length; i++)
            	sb.append(str[i]);
        }
        
        return sb.toString();
    }
}
