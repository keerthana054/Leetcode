class Solution {
    public boolean exist(char[][] maze, String word) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
               
                if (maze[i][j] == word.charAt(0)) {
                    boolean ans = search(maze, word, i, j, 0);
                    if (ans) {
                        return ans; 
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean search(char[][] maze, String word, int row, int col, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || maze[row][col] != word.charAt(idx)) {
            return false;
        }

        maze[row][col] = '*';
        int[] r = { -1, 1, 0, 0 };
        int[] c = { 0, 0, -1, 1 };
        for (int i = 0; i < c.length; i++) {
            boolean ans = search(maze, word, row + r[i], col + c[i], idx + 1);
            if (ans == true) {
                return ans;
            }
        }

        maze[row][col] = word.charAt(idx);
        return false; 
    }
}
