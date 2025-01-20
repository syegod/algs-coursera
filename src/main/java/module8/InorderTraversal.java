package module8;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10, new TreeNode(7, new TreeNode(4, new TreeNode(2, null, null), new TreeNode(6, null, null)), new TreeNode(9, null, null)), new TreeNode(12, new TreeNode(11, null, null), new TreeNode(28, new TreeNode(17, null, new TreeNode(25, null, null)), new TreeNode(32, null, null))));

        System.out.println(inorder(root));
    }

    public static List<Integer> inorder(TreeNode node) {
        if (node == null) {
            return null;
        }
        List<Integer> arr = new ArrayList<>();
        List<Integer> left = inorder(node.left);
        if (left != null) {
            arr.addAll(left);
        }

        arr.add(node.value);

        List<Integer> right = inorder(node.right);
        if (right != null) {
            arr.addAll(right);
        }
        return arr;
    }
}
