public class BinaryTree {
    public int data;
    public BinaryTree left, right;

    public BinaryTree(int data){
        this.data = data;
        left = null; right = null;
    }

    public void addLeft(int value){
        BinaryTree newNode = new BinaryTree(value);
        left = newNode;
    }

    public void addRight(int value){
        BinaryTree newNode = new BinaryTree(value);
        right = newNode;
    }
}
