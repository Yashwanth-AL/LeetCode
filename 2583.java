class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if(root == null){
            return -1;
        }

        PriorityQueue<Long> heap = new PriorityQueue<>(Comparator.reverseOrder());

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            int levelSize = q.size();
            long levelSum = 0;

            for(int i = 0; i < levelSize; i++){

                TreeNode current = q.poll();
                levelSum += current.val;

                if(current.left != null){
                    q.add(current.left);
                }
                if(current.right != null){
                    q.add(current.right);
                }

            }
            heap.add(levelSum);
        }

        for(int i = 1; i < k && !heap.isEmpty(); i++){
            heap.poll();
        }

        return heap.isEmpty() ? -1 : heap.poll();
    }
}

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
