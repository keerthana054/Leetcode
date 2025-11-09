class Solution {
    public static int calculateOperations(int num1, int num2) {
        if (num1==0 || num2==0) return 0;
        if (num1>=num2) {
                return 1 + calculateOperations(num1-num2, num2);
            }
            else {
                return 1 + calculateOperations(num1, num2-num1);
            }
    }

    public int countOperations(int num1, int num2) {
            return calculateOperations(num1, num2);
    }
}