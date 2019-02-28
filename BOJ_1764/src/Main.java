import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		Set<String> member = new HashSet<String>();
		
		for (int i = 0; i < N; i++)
			member.add(br.readLine());
		
		int cnt = 0;
		ArrayList<String> list = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (member.contains(str)) {
				cnt++;
				list.add(str);
			}
		}
		Collections.sort(list);
		sb.append(cnt).append("\n");
		for (String name : list)
			sb.append(name).append("\n");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
