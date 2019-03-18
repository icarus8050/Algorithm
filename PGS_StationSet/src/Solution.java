
public class Solution {

	public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int size = stations.length;
        int left = 1; int right = n + 1;
        for (int i = 0; i < size; i++) {
        	int station = stations[i];
        	if (station == 1) {
        		left = station + w + 1;
        		continue;
        	} else if (station == n - 1) {
        		right = station - w;
        		continue;
        	}
        	int station_left = station - w;
        	answer += install(left, station_left, w);
        	
        	left = station + w + 1;
        }
    	answer += install(left, right, w);
        
        return answer;
    }
	
	public int install(int left, int right, int w) {
		int res = 0;
		int citys = right - left;
    	if (citys > 0) {
    		res += citys / (w * 2 + 1);
    		if (citys % (w * 2 + 1) != 0)
    			res++;
    	}
    	return res;
	}
}
