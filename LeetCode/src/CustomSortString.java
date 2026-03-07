import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 791. Custom Sort String (https://leetcode.com/problems/custom-sort-string/description/)
 */
public class CustomSortString {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> sList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int priority = 1;
        for (char c : order.toCharArray()) {
            map.putIfAbsent(c, priority++);
        }

        for (char c : s.toCharArray()) {
            sList.add(c);
        }
        sList.sort((c1, c2) -> {
            int c1Priority = map.getOrDefault(c1, 99);
            int c2Priority = map.getOrDefault(c2, 99);
            return c1Priority - c2Priority;
        });

        sList.forEach(sb::append);
        return sb.toString();
    }

    public String customSortString_2(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : order.toCharArray()) {
            if (map.containsKey(c)) {
                sb.append(String.valueOf(c).repeat(map.get(c)));
                map.remove(c);
            }
        }
        for (Character c : map.keySet()) {
            sb.append(String.valueOf(c).repeat(map.get(c)));
        }
        return sb.toString();
    }
}
