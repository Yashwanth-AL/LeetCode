class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                TreeNode polled = queue.poll();
                list.add(polled.val);
                if(polled.left != null) queue.offer(polled.left);
                if(polled.right != null) queue.offer(polled.right);
            }
            result.add(list);
        }
        return result;
    }
}
