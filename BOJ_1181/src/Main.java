import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Set<String> set = new HashSet<>();
		
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			set.add(br.readLine());
		}
		
		List<String> list = new ArrayList<>(set);
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if (o1.length() == o2.length())
					return o1.compareTo(o2);
				return o1.length() - o2.length();
			}
		});
		
		for (String str: list) {
			bw.write(str + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
