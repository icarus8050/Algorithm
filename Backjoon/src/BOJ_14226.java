import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

/**
 * 이모티콘 (https://www.acmicpc.net/problem/14226)
 */
public class BOJ_14226 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[2000][2000];

        queue.offer(new Node(1, 0, 0));
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.sticker == S) {
                System.out.println(current.time);
                break;
            }

            if (current.sticker > 0 && current.sticker < 2000) {
                if (!visited[current.sticker][current.sticker]) {
                    visited[current.sticker][current.sticker] = true;
                    queue.offer(new Node(current.sticker, current.sticker, current.time + 1));
                }

                if (!visited[current.sticker - 1][current.clip]) {
                    visited[current.sticker - 1][current.clip] = true;
                    queue.offer(new Node(current.sticker - 1, current.clip, current.time + 1));
                }
            }

            if (current.clip > 0 && current.sticker + current.clip < 2000) {
                if (!visited[current.sticker + current.clip][current.clip]) {
                    visited[current.sticker + current.clip][current.clip] = true;
                    queue.offer(new Node(current.sticker + current.clip, current.clip, current.time + 1));
                }
            }
        }

        sc.close();
    }

    static class Node {
        int sticker;
        int clip;
        int time;

        public Node(int sticker, int clip, int time) {
            this.sticker = sticker;
            this.clip = clip;
            this.time = time;
        }
    }
}
