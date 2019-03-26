import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

	public int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
        
        Map<String, PriorityQueue<Music>> musicMap = new HashMap<>();
        Map<String, Integer> genreMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
        	if (musicMap.containsKey(genres[i])) {
        		musicMap.get(genres[i]).add(new Music(i, plays[i]));
        		
        		genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);
        	} else {
        		musicMap.put(genres[i], new PriorityQueue<Music>());
        		musicMap.get(genres[i]).add(new Music(i, plays[i]));
        		
        		genreMap.put(genres[i], plays[i]);
        	}
        }
        
        List<Integer> result = new ArrayList<>();
        List<String> keySetList = new ArrayList<>(genreMap.keySet());
        Collections.sort(keySetList, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return genreMap.get(o2).compareTo(genreMap.get(o1));
			}
        });
        
        for (String key : keySetList) {
        	PriorityQueue<Music> queue = musicMap.get(key);
        	for (int i = 0; i < 2; i++) {
        		if (!queue.isEmpty()) {
        			result.add(queue.poll().id);
        		}
        	}
        }
        answer = new int[result.size()];
        int idx = 0;
        for (int id: result)
        	answer[idx++] = id;
        
        return answer;
    }

}

class Music implements Comparable<Music> {
	int id, plays;
	
	public Music(int id, int plays) {
		this.id = id; this.plays = plays;
	}
	
	@Override
	public int compareTo(Music target) {
		// TODO Auto-generated method stub
		if (target.plays == this.plays)
			return this.id - target.id;
		else
			return target.plays - this.plays;
	}
}