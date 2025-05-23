class Solution {
    List<Integer> result = new ArrayList<>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return result;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);
        return result;
    }
}
