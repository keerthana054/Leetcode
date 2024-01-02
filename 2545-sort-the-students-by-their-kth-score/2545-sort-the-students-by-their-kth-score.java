class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score,(int[] a,int[] b)-> Integer.compare(b[k],a[k]));
        return score;
    }
}