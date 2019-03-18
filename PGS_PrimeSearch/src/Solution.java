import java.util.HashSet;
import java.util.Set;

public class Solution {

	static boolean[] prime;
	static boolean[] visited;
	static int res = 0;
	static int len;
	static Set<Integer> set = new HashSet<Integer>();
	static int[] arr;
	static final int MAX = 9999999;
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("17"));
	}
	public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        prime = new boolean[MAX + 1];
        prime[0] = prime[1] = true;
        len = numbers.length();
        arr = new int[numbers.length()];
        for (int i = 2; i * i <= MAX; i++) {
        	for (int j = i * i; j <= MAX; j += i) {
        		if (prime[j] == false)
        			prime[j] = true;
        	}
        }
        
        for (int i = 0; i < numbers.length(); i++)
        	arr[i] = numbers.charAt(i) - '0';
        search(0, 0);
        
        return res;
    }
	public void search(int n, int num) {
		
		if (!prime[num] && !set.contains(num)) {
			set.add(num);
			res++;
		}
		
		if (n == len)
			return;
		
		for (int i = 0; i < len; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				search(n + 1, num * 10 + arr[i]);
				visited[i] = false;
			}
		}
	}
}
