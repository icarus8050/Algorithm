import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		char[] num = str.toCharArray();
		int temp = 0;
		
		boolean exist_Zero = false;
		
		for (int i = 0; i < num.length; i++) {
			if (num[i] == '0') exist_Zero = true;
			temp += num[i] - '0';
		}
		
		if (exist_Zero && (temp % 3 == 0)) {
			Arrays.sort(num);
			for (int i = num.length - 1; i >= 0; i--)
				System.out.print(num[i]);
			System.out.println();
		}
		else System.out.println(-1);
		
		br.close();
	}
}
