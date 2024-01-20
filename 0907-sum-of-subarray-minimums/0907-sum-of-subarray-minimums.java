class Solution {
    public static int sumSubarrayMins(int[] arr) {
        final int MOD = 1000000007;
        int n = arr.length;

        long[] left = new long[n];
        long[] right = new long[n];

        Stack<Integer> stack = new Stack<>();

        // Calculate the number of subarrays where the current element is the minimum on its left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Calculate the number of subarrays where the current element is the minimum on its right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        long result = 0;

        // Calculate the sum of minimums for each subarray
        for (int i = 0; i < n; i++) {
            result = (result + arr[i] * left[i] * right[i]) % MOD;
        }

        return (int) result;
}
}