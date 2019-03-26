import java.util.ArrayList;
import java.util.Collections;

public class Solution {

	public String[] solution(String[][] tickets) {
        String[] answer;
        ArrayList<Node> nodeList = new ArrayList<Node>();
        ArrayList<String> route = new ArrayList<String>();
        
        for (int i = 0; i < tickets.length; i++) {
        	nodeList.add(new Node(tickets[i][0], tickets[i][1]));
        }
        
        Collections.sort(nodeList, (o1, o2) -> o1.departure.compareTo(o2.departure) != 0
					        					? o1.departure.compareTo(o2.departure)
					        					: o1.destination.compareTo(o2.destination));
        
        dfs("ICN", nodeList, route, 0);
        answer = new String[route.size()];
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = route.get(i);
        }
        return answer;
    }
	
	public boolean dfs(String from, ArrayList<Node> nodeList, ArrayList<String> route, int cnt) {
		route.add(from);
		
		if (cnt == nodeList.size()) {
			return true;
		}
		
		for (int i = 0; i < nodeList.size(); i++) {
			if (nodeList.get(i).departure.equals(from) && !nodeList.get(i).visited) {
				nodeList.get(i).visited = true;
				boolean flag = dfs(nodeList.get(i).destination, nodeList, route, cnt + 1);
				if (flag)
					return true;
				nodeList.get(i).visited = false;
			}
		}
		route.remove(route.size() - 1);
		return false;
	}
}

class Node {
	String departure;
	String destination;
	boolean visited;
	public Node(String departure, String destination) {
		this.departure = departure; this.destination = destination;
		visited = false;
	}
}