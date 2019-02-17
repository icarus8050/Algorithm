import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Meeting[] meeting = new Meeting[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			meeting[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(meeting, new Comparator<Meeting>() {

			@Override
			public int compare(Meeting o1, Meeting o2) {
				// TODO Auto-generated method stub
				if (o1.end == o2.end)
					return o1.start - o2.start;
				return o1.end - o2.end;
			}
		});
		
		int count = 0;
		int end = -1;
		for (int i = 0; i < N; i++) {
			if (meeting[i].start >= end) {
				count++;
				end = meeting[i].end;
			}
		}
		System.out.println(count);
		br.close();
	}
}

class Meeting {
	int start, end;
	public Meeting(int start, int end) {
		this.start = start; this.end = end;
	}
}