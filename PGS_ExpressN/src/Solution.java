
public class Solution {
	static int answer = 987654;
	public static void main(String[] args) {
		solution(5, 12);
	}
	public static int solution(int N, int number) {
        recursive(N, number, 0, 0);
        if (answer == 987654)
        	answer = -1;
        return answer;
    }
	public static void recursive(int N, int number, int cur, int cnt) {
		
		if (cnt > 8 || cnt > answer) {
			return;
		}
		
		if (cur == number) {
			answer = Math.min(answer, cnt);
			return;
		}
		int next = 0;
		for (int i = 1; i + cnt < 8; i++) {
			next = next * 10 + N;
			
			recursive(N, number, cur + next, cnt + i);
			recursive(N, number, cur - next, cnt + i);
			recursive(N, number, cur * next, cnt + i);
			recursive(N, number, cur / next, cnt + i);
		}
	}
}
