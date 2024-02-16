class Solution {
    public int sumCounts(List<Integer> nums) {
        int c = 0;
        List<Integer> l1 = new ArrayList<>();
        //SubArray Logic
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i; j < nums.size(); j++) {
                for (int k = i; k <= j; k++) {
                    l1.add(nums.get(k));
                }
                Set<Integer> set = new HashSet<>(l1); //For finding distinct elements
                c += Math.pow(set.size(), 2);
                l1.clear();
            }
        }
        return c;
        
    }
}