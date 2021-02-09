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
            map.put(i, map.getOrDefault(i, 0) + 1);
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

    public static boolean awesomeSolve(int[] hand, int W) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) > 0) {
                for (int i = W - 1; i >= 0; i--) {
                    if (map.getOrDefault(key + i, 0) < map.get(key)) {
                        return false;
                    }
                    map.put(key + i, map.get(key + i) - map.get(key));
                }
            }
        }

        return true;
    }
}
