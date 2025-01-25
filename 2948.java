import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        int[] numsSorted = nums.clone();
        Arrays.sort(numsSorted);

        Map<Integer, Integer> numToGroup = new HashMap<>();
        Map<Integer, List<Integer>> groupToList = new HashMap<>();

        int currGroup = 0; 
        numToGroup.put(numsSorted[0], currGroup);  
        groupToList.put(currGroup, new ArrayList<>());
        groupToList.get(currGroup).add(numsSorted[0]);

        for (int i = 1; i < n; i++) {
            
            if (Math.abs(numsSorted[i] - numsSorted[i - 1]) > limit) {
                currGroup++;
            }
            numToGroup.put(numsSorted[i], currGroup);
            groupToList.computeIfAbsent(currGroup, k -> new ArrayList<>()).add(numsSorted[i]);
        }

        for (Map.Entry<Integer, List<Integer>> entry : groupToList.entrySet()) {
            Collections.sort(entry.getValue());
        }

        int[] result = new int[n];
        Map<Integer, Integer> groupToIndex = new HashMap<>();  
        for (int i = 0; i < n; i++) {
            int group = numToGroup.get(nums[i]);
            result[i] = groupToList.get(group).get(groupToIndex.getOrDefault(group, 0));
            groupToIndex.put(group, groupToIndex.getOrDefault(group, 0) + 1);
        }

        return result;
    }
}
