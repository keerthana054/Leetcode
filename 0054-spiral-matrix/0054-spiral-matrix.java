class Solution {
    List<Integer> res = new ArrayList<>();
    int[][] matrix;
    int m;
    int n;
    
    private void borderFrom(int r, int c) {
        for (int i = c; i <= c + n - 1; i++) {
            res.add(matrix[r][i]);
        }
        for (int i = r + 1; i <= r + m - 2; i++) {
            res.add(matrix[i][c + n - 1]);
        }
        if (m > 1) {
            for (int i = c + n - 1; i >= c; i--) {
                res.add(matrix[r + m - 1][i]);
            }
        }
        if (n > 1) {
            for (int i = r + m - 2; i >= r + 1; i--) {
                res.add(matrix[i][c]);
            }
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        int p = 0;
        while (n > 0 && m > 0) {
            borderFrom(p, p);
            p++;
            m -= 2;
            n -= 2;
        }
        return res;
    }
}