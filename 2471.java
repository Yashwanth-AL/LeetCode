class Solution {
    public int minimumOperations(TreeNode root) {
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int[] nums = new int[size], sorted = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                nums[i] = sorted[i] = cur.val;
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res += countSwap(nums, sorted);
        }
        return res;
    }

    public int countSwap(int[] nums, int[] sorted) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(sorted);
        int swap = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sorted[i]) {
                swap++;
                map.put(nums[i], map.get(sorted[i]));
                nums[map.get(sorted[i])] = nums[i];
            }
        }
        return swap;
    }
}
