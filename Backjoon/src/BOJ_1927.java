import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 최소 힙 (https://www.acmicpc.net/problem/1927)
 */
public class BOJ_1927 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Heap heap = new Heap(n);

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                bw.write(heap.pop() + "\n");
            } else {
                heap.push(num);
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static class Heap {
        int[] arr;
        int lastPos;

        public Heap(int size) {
            this.arr = new int[size];
            this.lastPos = -1;
        }

        void push(int num) {
            lastPos++;

            int currentPos = lastPos;
            int parentPos = (currentPos - 1) / 2;
            while (currentPos > 0 && arr[parentPos] > num) {
                arr[currentPos] = arr[parentPos];
                currentPos = parentPos;
                parentPos = (currentPos - 1) / 2;
            }

            arr[currentPos] = num;
        }

        int pop() {
            if (lastPos == -1) return 0;

            int res = arr[0];
            int lastData = arr[lastPos--];
            int currentPos = 0;
            arr[currentPos] = lastData;

            while (true) {
                int parent = currentPos;
                int left = (parent * 2) + 1;
                int right = (parent * 2) + 2;

                if (left <= lastPos && arr[parent] > arr[left]) {
                    parent = left;
                }

                if (right <= lastPos && arr[parent] > arr[right]) {
                    parent = right;
                }

                if (currentPos == parent) break;

                arr[currentPos] = arr[parent];
                arr[parent] = lastData;
                currentPos = parent;
            }

            return res;
        }
    }
}
