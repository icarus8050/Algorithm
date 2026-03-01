import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 590. N-ary Tree Postorder Traversal
 * (https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/)
 */
public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, result);
        return result;
    }

    public void dfs(Node cur, List<Integer> result) {
        for (Node child : cur.children) {
            dfs(child, result);
        }
        result.add(cur.val);
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
