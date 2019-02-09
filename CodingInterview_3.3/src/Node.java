public class Node {
    private int data;
    private Node above;
    private Node below;

    public Node(int data){
        this.data = data;
        above = null;
        below = null;
    }
    public int getData(){ return data; }
    public void linkToAbove(Node top){ above = top; }
    public void linkToBelow(Node bottom){ below = bottom; }
    public Node getBelow(){ return below; }
    public Node getAbove(){ return above; }
}
