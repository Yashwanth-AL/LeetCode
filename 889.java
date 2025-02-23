class Solution {
    int preIndex = 0;
    int[] preorder, postorder;
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;
        return buildTree(0, postorder.length - 1);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) return null;
        
        TreeNode root = new TreeNode(preorder[preIndex++]);

        if (left == right) return root;
        
        int leftRoot = left;
        while (postorder[leftRoot] != preorder[preIndex]) {
            leftRoot++;
        }

        root.left = buildTree(left, leftRoot);
        root.right = buildTree(leftRoot + 1, right - 1);

        return root;
    }
}
