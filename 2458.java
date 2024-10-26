class Solution {

    int[] depth = new int[100001];       
    int[] nodeLevel = new int[100001];     
    int[] max1 = new int[100001]; 
    int[] max2 = new int[100001]; 

    public int[] treeQueries(TreeNode root, int[] queries) {

        calculateDepth(root, 0);

        for (int i = 0; i < queries.length; i++) {
            int nodeValue = queries[i];
            int level = nodeLevel[nodeValue];
            queries[i] = (max1[level] == depth[nodeValue] ? max2[level] : max1[level]) + level - 1;
        }
        return queries;
    }


    public int calculateDepth(TreeNode root, int level) {
        if (root == null) return 0;

        nodeLevel[root.val] = level;

        depth[root.val] = 1 + Math.max(
            calculateDepth(root.left, level + 1),
            calculateDepth(root.right, level + 1)
        );

        if (max1[level] < depth[root.val]) {
            max2[level] = max1[level];
            max1[level] = depth[root.val];
        } else if (max2[level] < depth[root.val]) {
            max2[level] = depth[root.val];
        }
        return depth[root.val];
    }
}
