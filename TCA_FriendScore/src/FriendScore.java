
public class FriendScore {

	public int highestScore(String[] friends) {
		int N = friends.length;
		
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				if (friends[i].charAt(j) == 'Y') {
					cnt++;
				}
				else {
					for (int k = 0; k < N; k++) {
						if (friends[j].charAt(k) == 'Y' && friends[k].charAt(i) == 'Y') {
							cnt++;
							break;
						}
					}
				}
			}
			result = Math.max(result, cnt);
		}
		
		return result;
	}
}
