import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		String str = "CBD";
		String[] str_2 = {"BACDE", "CBADF", "AECB", "BDA"};
		int a = solution(str, str_2);
		System.out.println(a);
	}
	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        boolean[] check = new boolean[skill.length()];
        int[] alpha = new int[26];
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < skill.length(); i++) {
        	char cur = skill.charAt(i);
        	set.add(cur);
        	alpha[cur - 'A'] = i;
        }
        	
        
        for (int t = 0; t < skill_trees.length; t++) {
        	Arrays.fill(check, false);
        	for (int i = 0; i < skill_trees[t].length(); i++) {
        		char cur = skill_trees[t].charAt(i);
        		if (set.contains(cur)) {
        			int idx = alpha[cur - 'A'];
        			if (idx == 0)
        				check[idx] = true;
        			else {
        				boolean flag = true;
        				for (int k = idx - 1; k >= 0; k--) {
        					if (check[k] == false) {
        						flag = false;
        						break;
        					}
        				}
        				if (flag)
        					check[idx] = true;
        				else
        					break;
        			}
        		}
        		if (i == skill_trees[t].length() - 1)
        			answer++;
        	}
        }
        return answer;
    }
}
