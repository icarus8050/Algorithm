public class MainClass {

    public static void main(String[] args){
        int[] array = {1, 4, 5, 9, 15, 25, 50, 63, 86, 100, 125, 326, 530, 603, 869, 1003, 1184, 1240};
        BST bst = new BST();
        createMinimalBST(bst, array, 0, array.length - 1);
        bst.preorderSearch(bst.getRootNode());
    }

    public static void createMinimalBST(BST bst, int[] array, int start, int end){

        if(start > end) return;

        int mid = (start + end) / 2;
        bst.insertNode(new Node(array[mid]));
        createMinimalBST(bst, array, start, mid - 1);
        createMinimalBST(bst, array, mid + 1, end);
    }
}
