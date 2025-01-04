public class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        swap(root.left, root.right, 0);
        return root;
    }

    public void swap(TreeNode r1, TreeNode r2, int level) {
        if(r1 == null || r2 == null) return;

        if(level % 2 == 0) {
            int val = r1.val;
            r1.val = r2.val;
            r2.val = val;
        }

        swap(r1.left, r2.right, level + 1);
        swap(r1.right, r2.left, level + 1);
    }
}
