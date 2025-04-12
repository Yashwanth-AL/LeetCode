class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return result;
    }

    public void traverse(TreeNode root) {
        if(root == null) return;
        traverse(root.left);
        result.add(root.val);
        traverse(root.right);
    }
}
