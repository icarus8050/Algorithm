public class BST {
    private Node rootNode;

    public BST(){
        rootNode = null;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public void preorderSearch(Node rootNode){
        if(rootNode == null) return;

        System.out.print(rootNode.getData() + " ");
        preorderSearch(rootNode.getLeftChild());
        preorderSearch(rootNode.getRightChild());
    }

    public void insertNode(Node node){
        if(rootNode == null) rootNode = node;
        else{
            Node currentNode = rootNode;
            while (true) {
                if(currentNode.getData() > node.getData()){
                    if(currentNode.getLeftChild() == null){
                        currentNode.setLeftChild(node);
                        return;
                    }
                    else currentNode = currentNode.getLeftChild();
                }else{
                    if(currentNode.getRightChild() == null){
                        currentNode.setRightChild(node);
                        return;
                    }else currentNode = currentNode.getRightChild();
                }
            }
        }
    }
}
