import java.util.ArrayList;

public class Solution {

	public String[] solution(String[][] tickets) {
        String[] answer = {};
        ArrayList<Node> nodeList = new ArrayList<Node>();
        
        for (int i = 0; i < tickets.length; i++) {
        	nodeList.add(new Node(tickets[i][0], tickets[i][1]));
        }
        
        return answer;
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