class Solution {
    List<Integer> result = new ArrayList<>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return result;
    }

    public void traverse(TreeNode root) {
        if(root == null) return;
        traverse(root.left);
        traverse(root.right);
        result.add(root.val);
    }
}
