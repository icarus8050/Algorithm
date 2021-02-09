import java.util.*;

/**
 * 846. Hand of Straights (https://leetcode.com/problems/hand-of-straights/)
 */
public class HandOfStraights {
    public static void main(String[] args) {
        int[] t = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        boolean result = isNStraightHand(t, 3);
        System.out.println(result);
    }

    public static boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i : hand) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        while (!map.isEmpty()) {
            if (W > map.keySet().size()) {
                return false;
            }

            Deque<Map.Entry<Integer, Integer>> deque = new LinkedList<>();
            for (int i = 0; i < W; i++) {
                Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
                if (!deque.isEmpty() && entry.getKey() - deque.peekLast().getKey() != 1) {
                    return false;
                }
                deque.add(entry);
            }

            while (!deque.isEmpty()) {
                Map.Entry<Integer, Integer> entry = deque.pollFirst();

                if (entry.getValue() - 1 != 0) {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
        }

        return true;
    }
}
