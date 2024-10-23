class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root == null){
            return null;
        }

        HashMap<TreeNode, Integer> siblingSum = new HashMap<>();

        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[] {root, null});

        while(!queue.isEmpty()){

            int levelSize = queue.size();
            int levelSum = 0;

            List<TreeNode[]> levelNodes = new LinkedList<>();

            for(int i = 0; i < levelSize; i++){

                TreeNode[] current = queue.poll();
                TreeNode node = current[0];
                TreeNode parent = current[1];

                levelNodes.add(current);

                levelSum += node.val;

                if(node.left != null){
                    queue.offer(new TreeNode[] {node.left, node});
                    siblingSum.put(node, siblingSum.getOrDefault(node, 0) + node.left.val);
                }

                if(node.right != null){
                    queue.offer(new TreeNode[] {node.right, node});
                    siblingSum.put(node, siblingSum.getOrDefault(node, 0) + node.right.val);
                }
            }

            for(TreeNode[] node : levelNodes){
                int siblingValue = siblingSum.getOrDefault(node[1], 0);
                int nodeValue = levelSum - siblingValue;
                node[0].val = nodeValue;
            }
        }
        root.val = 0;
        return root;
    }
}
