class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        final int[][] result = new int[m][n];
        int x = 0, y = 0;

        while(m > y && n > x) {
            for(int i = x; i < n; ++i) {
                int val = -1;

                if(head != null) {
                    val = head.val;
                    head = head.next;   
                }

                result[y][i] = val;
            }

            y++;

            for(int i = y; i < m; ++i) {
                int val = -1;

                if(head != null) {
                    val = head.val;
                    head = head.next;   
                }

                result[i][n - 1] = val;
            }

            n--;

            for(int i = n - 1; i >= x && y < m; --i) {
                int val = -1;

                if(head != null) {
                    val = head.val;
                    head = head.next;   
                }

                result[m - 1][i] = val;
            }

            m--;


            for(int i = m - 1; i >= y && x < n; --i) {
                int val = -1;

                if(head != null) {
                    val = head.val;
                    head = head.next;   
                }

                result[i][x] = val;
            }

            x++;
        }

        return result;
    }
}