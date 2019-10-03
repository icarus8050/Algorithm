import java.util.HashMap;
import java.util.Map;

public class Camouflage {

    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> attire = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (attire.containsKey(clothes[i][1])) {
                attire.put(clothes[i][1], attire.get(clothes[i][1]) + 1);
            } else {
                attire.put(clothes[i][1], 1);
            }
        }

        for (Integer value : attire.values()) {
            answer *= (value + 1);
        }

        return answer - 1;
    }
}
