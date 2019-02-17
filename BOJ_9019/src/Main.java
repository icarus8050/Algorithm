import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int MAX = 10000;
	static boolean[] numCheck;
	static String result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			dfs(A, B);
			System.out.println(result);
			
		}
		br.close();
	}

	public static void dfs(int A, int B) {
		numCheck = new boolean[MAX];
		numCheck[A] = true;
		Queue<Command> queue = new LinkedList<Command>();
		queue.offer(new Command(A, ""));
		
		while (!queue.isEmpty()) {
			Command cmd = queue.poll();
			
			if (cmd.num == B) {
				result = cmd.str;
				return;
			}
			
			int dNum = (cmd.num * 2) % MAX;
			if (!numCheck[dNum]) {
				queue.offer(new Command(dNum, cmd.str + "D"));
				numCheck[dNum] = true;
			}
			
			int sNum = cmd.num - 1;
			if (sNum < 0) sNum = 9999;
			if (!numCheck[sNum]) {
				queue.offer(new Command(sNum, cmd.str + "S"));
				numCheck[sNum] = true;
			}
			
			int lNum = (cmd.num % 1000) * 10 + (cmd.num / 1000);
			if (!numCheck[lNum]) {
				queue.offer(new Command(lNum, cmd.str + "L"));
				numCheck[lNum] = true;
			}
			
			int rNum = (cmd.num / 10) + (cmd.num % 10) * 1000;
			if (!numCheck[rNum]) {
				queue.offer(new Command(rNum, cmd.str + "R"));
				numCheck[rNum] = true;
			}
		}
	}
}

class Command {
	int num; String str;
	public Command(int num, String str) {
		this.num = num; this.str = str;
	}
}