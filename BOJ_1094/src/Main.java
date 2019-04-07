import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		while (X != 0) {
			if (X % 2 == 1)
				cnt++;
			X /= 2;
		}
		
		System.out.println(cnt);
		br.close();		
	}
}
