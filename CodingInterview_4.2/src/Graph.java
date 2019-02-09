import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertexList;

    public Graph(){
        vertexList = new ArrayList<>();
    }

    public void addVertex(Vertex v){ vertexList.add(v); }

    public void connectVertex(int from, int to){
        Vertex fromVertex = vertexList.get(from);
        Vertex toVertex = vertexList.get(to);
        fromVertex.connectEdge(toVertex);
    }

    public ArrayList<Vertex> getVertex(){ return vertexList; }

}
