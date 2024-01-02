class Solution {
    public int xorOperation(int n, int start) {
        // create an array of size n
        int[] nums = new int[n];

        // initialize the values in array according to question 
        for(int i=0; i<n; i++) {
            nums[i] = start + (2 * i); 
        }

        int xor = 0;
        // Calculate the bitwise XOR of all elements
        for (int i=0; i<n; i++) {
            xor ^= nums[i];
        }

        // Return the xor value
        return xor;
    }
}