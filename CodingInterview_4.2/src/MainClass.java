import java.util.*;

public class MainClass {
    public static boolean BFS(Graph g, int start, int end){
        LinkedList<Vertex> queue = new LinkedList<>();  //Queue 역할
        /*Iterator<Vertex> vertexIterator = g.getVertex().iterator();
        while(vertexIterator.hasNext()) vertexIterator.next().state = State.unvisited;*/
        for(Vertex v: g.getVertex()){
            v.state = State.unvisited;
        }

        Vertex startVertex = g.getVertex().get(start);
        Vertex endVertex = g.getVertex().get(end);
        Vertex currentVertex;

        queue.add(startVertex);
        while(!queue.isEmpty()){
            currentVertex = queue.removeFirst();
            System.out.print(currentVertex.getData() + " -> ");
            for(Vertex v: currentVertex.adjacentList){
                if(v.state == State.unvisited){
                    if(v == endVertex){
                        System.out.println(v.getData());
                        return true;
                    }else{
                        queue.add(v);
                    }
                }
            }
            currentVertex.state = State.visited;
        }

        return false;
    }

    public static boolean DFS(Graph g, int start, int end){
        //망한 DFS 함수
        Stack<Vertex> stack = new Stack<>();
        boolean completeFlag = false;
        for(Vertex v: g.getVertex()){
            v.state = State.unvisited;
        }
        Vertex startVertex = g.getVertex().get(start);
        Vertex endVertex = g.getVertex().get(end);
        Vertex currentVertex = startVertex;

        do{
            System.out.print(currentVertex.getData() + " -> ");
            currentVertex.state = State.visited;
            if(!currentVertex.adjacentList.isEmpty()){
                for(Vertex v: currentVertex.adjacentList){
                    if(v.state == State.unvisited){
                        if(v == endVertex){
                            System.out.print(v.getData() + " -> ");
                            return true;
                        }
                        stack.push(currentVertex);
                        currentVertex = v;
                        break;
                    }
                }
                //currentVertex = stack.pop();
            }else{
                currentVertex = stack.pop();
            }
        }while(!stack.isEmpty());

        return false;
    }
    public static boolean DFS_2(Graph g, int start, int end){
        //Stack 의 Top 에 있는 Vertex 를 검사하여 DFS 를 수행하는 방식
        Stack<Vertex> stack = new Stack<>();
        boolean completeFlag = false;
        for(Vertex v: g.getVertex()){
            v.state = State.unvisited;
        }
        Vertex startVertex = g.getVertex().get(start);
        Vertex endVertex = g.getVertex().get(end);

        stack.push(startVertex);
        while(!stack.isEmpty()){
            stack.peek().state = State.visited;
            System.out.print(stack.peek().getData() + " -> ");
            if (stack.peek().adjacentList.size() != 0) {
                //인접 리스트가 있다면 방문하지 않는 Vertex 가 있는지 검사
                for(int i = 0; i < stack.peek().adjacentList.size(); i++){
                    //방문하지 않은 Vertex 가 있는 경우 Destination Vertex 인지 검사
                    if(stack.peek().adjacentList.get(i).state == State.unvisited){
                        if (stack.peek().adjacentList.get(i) == endVertex) {
                            System.out.println(stack.peek().adjacentList.get(i).getData());
                            return true;
                        }
                        stack.push(stack.peek().adjacentList.get(i));   //그 다음 Vertex 방문을 위해 Stack 에 push.
                        break;
                    }
                    if(i == stack.peek().adjacentList.size() - 1){
                        completeFlag = true;
                    }
                }
            }else stack.pop();  //Stack 의 Top 에 인접 리스트가 없다면 복귀
            if(completeFlag == true){
                completeFlag = false;
                stack.pop();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex(new Vertex(0));
        graph.addVertex(new Vertex(1));
        graph.addVertex(new Vertex(2));
        graph.addVertex(new Vertex(3));
        graph.addVertex(new Vertex(4));
        graph.addVertex(new Vertex(5));
        graph.addVertex(new Vertex(6));
        graph.addVertex(new Vertex(7));
        graph.addVertex(new Vertex(8));
        graph.connectVertex(0, 1);
        graph.connectVertex(1, 2);
        graph.connectVertex(1, 3);
        graph.connectVertex(2, 4);
        graph.connectVertex(2, 5);
        graph.connectVertex(5, 4);
        graph.connectVertex(5, 6);
        graph.connectVertex(5, 7);
        graph.connectVertex(5, 8);
        System.out.println(DFS_2(graph, 4, 0));
    }
}
