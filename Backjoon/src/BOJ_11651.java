import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 좌표 정렬하기 2 (https://www.acmicpc.net/problem/11651)
 */
public class BOJ_11651 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            points.add(new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        Collections.sort(points);
        for (Point point : points) {
            bw.write(point.x + " " + point.y + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (y == o.y) {
                return x - o.x;
            }

            return y - o.y;
        }
    }
}

