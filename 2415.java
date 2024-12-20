/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOdd = false; // Start from level 0 (even)

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> levelNodes = new ArrayList<>();

            // Traverse the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isOdd) levelNodes.add(node); // Only store nodes on odd levels

                if (node.left != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }

            // Reverse values on odd levels
            if (isOdd) {
                int left = 0, right = levelNodes.size() - 1;
                while (left < right) {
                    int temp = levelNodes.get(left).val;
                    levelNodes.get(left).val = levelNodes.get(right).val;
                    levelNodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }

            // Toggle odd/even flag
            isOdd = !isOdd;
        }

        return root;
    }
}
