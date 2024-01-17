class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> nums = new HashMap<>();
        for (int j : arr) {
            if (nums.containsValue(j)) continue;
            int count = 0;
            for (int k : arr)
                if (j == k)
                    count++;
            if (nums.containsKey(count))
                return false;
            else nums.put(count, j);
        }
        return true;
    }
}