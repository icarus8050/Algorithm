
public class KiwiJuiceEasy {

	public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
		for (int i = 0; i < fromId.length; i++) {
			int from = fromId[i];
			int to = toId[i];
			
			bottles[to] += bottles[from];
			if (capacities[to] >= bottles[to]) {
				bottles[from] = 0;
			}
			else {
				int rest = bottles[to] - capacities[to];
				bottles[from] = rest;
				bottles[to] = capacities[to];
			}
		}
		return bottles;
	}
}
