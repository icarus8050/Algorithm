import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N, ans = 0;
	static char[] lights, tempLights, objLights;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		lights = br.readLine().toCharArray();
		objLights = br.readLine().toCharArray();
		
		tempLights = lights.clone();
		solve();
		
		if (ans == -1) {
			ans = 1;
			tempLights = lights.clone();
			switching(0);
			switching(1);
			solve();
		}
		System.out.println(ans);
		br.close();
	}
	
	public static void solve() {
		
		for (int i = 1; i < N; i++) {
			if (tempLights[i - 1] != objLights[i - 1]) {
				push(i);
				ans++;
			}
		}
		
		if (tempLights[N - 1] != objLights[N - 1])
			ans = -1;
	}
	
	public static void push(int i) {
		switching(i - 1);
		switching(i);
		
		if (i != N - 1)
			switching(i + 1);
	}
	
	public static void switching(int i) {
		if (tempLights[i] == '0')
			tempLights[i] = '1';
		else
			tempLights[i] = '0';
	}
}
