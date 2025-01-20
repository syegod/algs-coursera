package module8;

public class IsBST {
    public static boolean isBST(TreeNode node) {
        return recIsBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean recIsBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        boolean isLeftBST = true;
        boolean isRightBST = true;
        if (node.left != null) {
            if (node.left.value <= min || node.left.value > node.value) {
                isLeftBST = false;
            } else {
                isLeftBST = recIsBST(node.left, min, node.value);
            }
        }
        if (node.right != null) {
            if (node.right.value > max || node.right.value <= node.value) {
                isRightBST = false;
            } else {
                isRightBST = recIsBST(node.right, node.value, max);
            }
        }

        return isLeftBST && isRightBST;
    }


}
