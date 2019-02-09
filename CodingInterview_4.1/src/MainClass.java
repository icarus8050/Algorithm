public class MainClass {

    public static void main(String[] args){
        BinaryTree root = new BinaryTree(2);

        //2 layer
        root.addLeft(1);
        root.addRight(5);

        //3 layer
        root.left.addLeft(12);
        root.left.addRight(14);

        root.right.addLeft(10);
        root.right.addRight(9);

        //4 layer
        root.left.left.addLeft(53);
        root.left.left.addRight(39);

        root.left.right.addLeft(40);
        root.left.right.addRight(48);

        //5 layer
        root.left.left.left.addLeft(43);
        root.left.left.left.addRight(75);

        //6 layer
        root.left.left.left.right.addRight(57);

        System.out.println(isBalanced(root));
    }
    /*
    public static boolean isBalanced(BinaryTree root){
        if (root == null) return true;

        int heightDifferent = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDifferent) > 1){
            return false;
        }else{
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public static int getHeight(BinaryTree root){
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    */

    public static boolean isBalanced(BinaryTree root){
        if (checkHeight(root) == -1) return false;
        else return true;
    }

    public static int checkHeight(BinaryTree root){
        if (root == null) return 0;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) return -1;

        int heightDifferent = Math.abs(leftHeight - rightHeight);
        if (heightDifferent > 1) return -1;
        else return Math.max(leftHeight, rightHeight) + 1;
    }
}
