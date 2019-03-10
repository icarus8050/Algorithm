import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		String strNum = input[0];
		int target = Integer.parseInt(input[1]);
		
		Set<String> set = new HashSet<String>();
		Queue<Node> queue = new LinkedList<Node>();
		
		int result = -1;
		queue.offer(new Node(strNum, 1));
		while (!queue.isEmpty()) {
			Node curNode = queue.poll();
			Long curNum = Long.parseLong(curNode.strNum);
			
			if (curNum > target)
				continue;
			
			if (curNum == target) {
				result = curNode.cnt;
				break;
			}
			
			String a = curNode.strNum + "1";
			String b = Long.toString(curNum * 2);
			
			if (!set.contains(a)) {
				set.add(a);
				queue.offer(new Node(a, curNode.cnt + 1));
			}
			
			if (!set.contains(b)) {
				set.add(b);
				queue.offer(new Node(b, curNode.cnt + 1));
			}
		}
		System.out.println(result);
		br.close();
	}
}
class Node {
	String strNum; int cnt;
	public Node(String strNum, int cnt) {
		this.strNum = strNum; this.cnt = cnt;
	}
}