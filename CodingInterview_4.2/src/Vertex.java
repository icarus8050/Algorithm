import java.util.ArrayList;

public class Vertex {
    public State state;
    private int data;
    public ArrayList<Vertex> adjacentList;

    public Vertex(int data){
        this.data = data;
        adjacentList = new ArrayList<>();
    }

    public int getData(){ return data; }

    public void connectEdge(Vertex v){
        adjacentList.add(v);
    }

    public void disconnectEdge(int index){
        adjacentList.remove(index);
    }
}
