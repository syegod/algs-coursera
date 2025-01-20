package module8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsBSTTest {
    @Test
    void testIsBSTBasic() {
        TreeNode root = new TreeNode(10, new TreeNode(7, new TreeNode(4, new TreeNode(2, null, null), new TreeNode(6, null, null)), new TreeNode(9, null, null)), new TreeNode(12, new TreeNode(11, null, null), new TreeNode(28, new TreeNode(17, null, new TreeNode(25, null, null)), new TreeNode(32, null, null))));

        assertTrue(IsBST.isBST(root));
    }

}