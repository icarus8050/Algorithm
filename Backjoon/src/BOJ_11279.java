import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 최대 힙 (https://www.acmicpc.net/problem/11279)
 */
public class BOJ_11279 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Heap heap = new Heap(n);

        while (n-- > 0) {
            int a = Integer.parseInt(br.readLine());

            if (a == 0) {
                bw.write(heap.pop() + "\n");
            } else {
                heap.push(a);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Heap {
        int[] arr;
        int lastPos;

        public Heap(int size) {
            this.arr = new int[size];
            this.lastPos = -1;
        }

        void push(int n) {
            lastPos++;
            int currentPos = lastPos;
            int parentPos = (currentPos - 1) / 2;

            while (currentPos > 0 && n > arr[parentPos]) {
                arr[currentPos] = arr[parentPos];
                currentPos = parentPos;
                parentPos = (currentPos - 1) / 2;
            }

            arr[currentPos] = n;
        }

        int pop() {
            if (lastPos == -1) return 0;

            int res = arr[0];
            int currentPos = 0;
            int currentVal = arr[lastPos];
            arr[lastPos] = 0;

            int left = currentPos * 2 + 1;
            int right = currentPos * 2 + 2;
            while (left < lastPos && (arr[left] > currentVal || arr[right] > currentVal)) {

                if (arr[left] > arr[right]) {
                    arr[currentPos] = arr[left];
                    currentPos = left;
                } else {
                    arr[currentPos] = arr[right];
                    currentPos = right;
                }
                left = currentPos * 2 + 1;
                right = currentPos * 2 + 2;
            }
            lastPos--;
            arr[currentPos] = currentVal;
            return res;
        }
    }
}
