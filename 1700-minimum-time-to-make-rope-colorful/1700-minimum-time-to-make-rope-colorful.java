class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalCost = 0;
        int n = neededTime.length;
      
        for (int groupStart = 0, groupEnd = 0; groupStart < n; groupStart = groupEnd) {
            groupEnd = groupStart;
            int groupSum = 0;
            int maxTimeInGroup = 0;
          
            while (groupEnd < n && colors.charAt(groupEnd) == colors.charAt(groupStart)) {
                groupSum += neededTime[groupEnd];
                maxTimeInGroup = Math.max(maxTimeInGroup, neededTime[groupEnd]);
                groupEnd++;
            }
          
            if (groupEnd - groupStart > 1) {
                totalCost += groupSum - maxTimeInGroup;
            }
        }
      
        return totalCost;
    }
}