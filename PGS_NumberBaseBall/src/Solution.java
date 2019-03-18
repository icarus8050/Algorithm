
public class Solution {

	static int[][] hint;
	public static void main(String[] args) {
		int[][] a = new int[2][2];
		a[0][0] = 245;
		a[0][1] = 3;
		System.out.println(a[0].toString());
	}
	public int solution(int[][] baseball) {
        int answer = 0;
        hint = baseball;
        for (int i = 123; i <= 987; i++) {
        	if(isPossible(Integer.toString(i)))
        		answer++;
        }
        return answer;
    }
	
	public boolean isPossible(String str) {
		
		char[] num = str.toCharArray();
		
		if (num[0] == '0' || num[1] == '0' || num[2] == '0')
			return false;
		
		if (num[0] == num[1] || num[1] == num[2] || num[0] == num[2])
			return false;
		
		for (int i = 0; i < hint.length; i++) {
			int[] temp = getStrikeAndBall(Integer.toString(hint[i][0]), num);
			if (hint[i][1] != temp[0] || hint[i][2] != temp[1])
				return false;
		}
		
		return true;
	}
	
	public int[] getStrikeAndBall(String num, char[] ch) {
		int[] result = new int[2];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (num.charAt(i) == ch[j]) {
					if (i == j)
						result[0]++;
					else
						result[1]++;
				}
			}
		}
		return result;
	}
}
