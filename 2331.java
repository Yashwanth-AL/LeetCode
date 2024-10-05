class Solution {
    public boolean evaluateTree(TreeNode root) {
        if(root.val == 0) return false;
        if(root.val == 1) return true;
        
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if(root.val == 2){
            return left || right;
        }if(root.val == 3){
            return left && right;
        }
        return false;
    }
}

/**
 * Definition for a binary tree root.
 * public class Treeroot {
 *     int val;
 *     Treeroot left;
 *     Treeroot right;
 *     Treeroot() {}
 *     Treeroot(int val) { this.val = val; }
 *     Treeroot(int val, Treeroot left, Treeroot right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
