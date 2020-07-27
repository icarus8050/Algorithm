import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 숨바꼭질 4 (https://www.acmicpc.net/problem/13913)
 */
public class BOJ_13913 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[] trace = new int[100_001];
        Arrays.fill(trace, -1);

        Queue<Node> queue = new LinkedList<>();
        int ans = 0;


        queue.offer(new Node(n, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.pos == m) {
                ans = current.time;
                break;
            }

            if (current.pos - 1 >= 0 && trace[current.pos - 1] == -1) {
                trace[current.pos - 1] = current.pos;
                queue.offer(new Node(current.pos - 1, current.time + 1));
            }

            if (current.pos + 1 <= 100_000 && trace[current.pos + 1] == -1) {
                trace[current.pos + 1] = current.pos;
                queue.offer(new Node(current.pos + 1, current.time + 1));
            }

            if (current.pos * 2 <= 100_000 && trace[current.pos * 2] == -1) {
                trace[current.pos * 2] = current.pos;
                queue.offer(new Node(current.pos * 2, current.time + 1));
            }
        }
        bw.write(ans + "\n");

        Stack<Integer> stack = new Stack<>();

        int pos = m;
        while (pos != n) {
            stack.push(trace[pos]);
            pos = trace[pos];
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }
        bw.write(m + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int pos;
        int time;

        Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }
}
