import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Point> list = new ArrayList<Point>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(st.nextToken());
			Point p = getP(num);
			list.add(p);
		}
		
		Collections.sort(list, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.three != o2.three)
					return (int) (o1.three - o2.three);
				return (int) (o1.two - o2.two);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (Point p : list)
			sb.append(p.num).append(" ");
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);
		br.close();
	}
	
	public static Point getP(long n) {
		Point p = new Point();
		p.num = n;
		while (n % 2 == 0 && n != 0) {
			p.two++;
			n /= 2;
		}
		while (n % 3 == 0 && n != 0) {
			p.three--;
			n /= 3;
		}
		return p;
	}
}

class Point {
	long num = 0, two = 0, three = 0;
}