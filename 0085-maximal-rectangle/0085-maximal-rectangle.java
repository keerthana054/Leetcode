class Solution {
    public int maximalRectangle(char[][] mat) {
        int[][] matrix = new int[mat.length][mat[0].length];
        for(int i = 0; i < matrix.length; i ++) {
            for(int j = 0; j < matrix[0].length; j ++) {
                matrix[i][j] = mat[i][j] - '0';
            }
        }
        for(int i = 1; i < matrix.length; i ++) {
            for(int j = 0; j < matrix[0].length; j ++) {
                matrix[i][j] += matrix[i][j] == 0 ? 0 : matrix[i - 1][j];
            }
        }
        
        int ans = 0;
        for(int[] t : matrix) ans = Math.max(ans, getMaxArea(t, t.length));
        return ans;
    }
    
    public int[] nsr(int[] arr, int n) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i --){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            ans[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return ans;
    }
    
    public int[] nsl(int[] arr, int n) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i ++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    
    public int getMaxArea(int[] arr, int n) {
        int[] left = nsl(arr, n);
        int[] right = nsr(arr, n);
        int maxArea = 0;
        for(int i = 0; i < arr.length; i ++) 
            maxArea = Math.max(maxArea, arr[i]*(right[i] - left[i] - 1));
        return maxArea;
    }
}