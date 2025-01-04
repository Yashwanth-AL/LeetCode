class Solution {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                max = Math.max(current.val, max);

                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
            
            list.add(max);
        }

        return list;
        
    }
}
