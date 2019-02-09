public class Stack {
    private int capacity;
    private int size;
    private Node top, bottom;

    public Stack(int capacity){
        this.capacity = capacity;
        size = 0;
        top = null;
        bottom = null;
    }

    public boolean isFull(){ return capacity == size; }
    public boolean isEmpty(){ return size == 0; }
    public int getSize(){ return size; }

    public void join(Node above, Node below){
        if(below != null) below.linkToAbove(above);
        if(above != null) above.linkToBelow(below);
    }

    public boolean push(int value){
        if (size >= capacity) return false;
        size++;
        Node newNode = new Node(value);
        if (size == 1) bottom = newNode;
        join(newNode, top);
        top = newNode;

        return true;
    }

    public int pop(){
        Node returnNode = top;
        top = top.getBelow();
        size--;
        return returnNode.getData();
    }
}
