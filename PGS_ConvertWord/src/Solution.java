
public class Solution {

	static boolean[] visited;
	static int ans;
	public int solution(String begin, String target, String[] words) {
        ans = Integer.MAX_VALUE;
        visited = new boolean[words.length];
        boolean check = false;
        for (String word: words) {
        	if (target.compareTo(word) == 0)
        		check = true;
        }
        
        if (check)
        	dfs(begin, target, words, 0);
        
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
	
	public void dfs(String begin, String target, String[] words, int cnt) {
		
		if (begin.compareTo(target) == 0) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		for (int i = 0; i < words.length; i++) {
			if (!visited[i] && compareWord(begin, words[i])) {
				visited[i] = true;
				dfs(words[i], target, words, cnt + 1);
				visited[i] = false;
			}
		}
	}
	
	public boolean compareWord(String a, String b) {
		int cnt = 0;
		
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				cnt++;
		}
		
		if (cnt > 1)
			return false;
		else
			return true;
	}
}
