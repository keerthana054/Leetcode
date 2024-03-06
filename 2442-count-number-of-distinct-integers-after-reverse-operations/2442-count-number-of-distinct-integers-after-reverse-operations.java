class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n > 9) {
                int r = 0;
                while (n > 0) {
                    r += n % 10;
                    if (n > 9) {
                        r *= 10;
                    }
                    n /= 10;
                }
                unique.add(r);
            }
            unique.add(nums[i]);
        }
        return unique.size();
    }
}
