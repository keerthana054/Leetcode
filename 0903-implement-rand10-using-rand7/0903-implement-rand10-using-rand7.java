/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int column = rand7();
        int row = rand7();

        int val = (column) + (row-1) * 7;

        if(val<=40) {
            return (val-1) % 10 +1;
        }
        else {
            return rand10();
        }
    }
}