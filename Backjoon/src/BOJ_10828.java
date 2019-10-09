import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10828 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Stack stack = new Stack(N);

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write(stack.pop() + "\n");
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                case "empty":
                    bw.write(stack.isEmpty() + "\n");
                    break;
                case "top":
                    bw.write(stack.peek() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class Stack {
    private int[] arr;
    private int top;

    public Stack(int n) {
        arr = new int[n];
        top = -1;
    }

    public int isEmpty() {
        return (top == -1) ? 1 : 0;
    }

    public void push(int v) {
        if (arr.length - 1 == top) {
            int[] temp = new int[arr.length * 2];
            temp = Arrays.copyOf(arr, temp.length);
            arr = temp;
        }

        arr[++top] = v;
    }

    public int pop() {
        if (isEmpty() == 1) {
            return -1;
        }

        return arr[top--];
    }

    public int size() {
        return top + 1;
    }

    public int peek() {
        return (top != -1) ? arr[top] : top;
    }
}