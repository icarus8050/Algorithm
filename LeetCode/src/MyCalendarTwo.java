import java.util.Map;
import java.util.TreeMap;

/**
 * My Calendar II (https://leetcode.com/problems/my-calendar-ii/)
 */
public class MyCalendarTwo {

    TreeMap<Integer, Integer> calendar;

    public MyCalendarTwo() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : calendar.entrySet()) {
            cnt += entry.getValue();

            if (cnt > 2) {
                calendar.put(start, calendar.get(start) - 1);
                if (calendar.get(start) == 0) {
                    calendar.remove(start);
                }

                calendar.put(end, calendar.get(end) + 1);
                if (calendar.get(end) == 0) {
                    calendar.remove(end);
                }

                return false;
            }
        }
        return true;
    }
}
