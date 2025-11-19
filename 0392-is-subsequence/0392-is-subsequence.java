class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        int sL = s.length();
        int tL = t.length();
        char sA[] = s.toCharArray();
        char tA[] = t.toCharArray();

        if (sL < 1){
            return true;
        }

        while(i<tL) {
            if(tA[i] == sA[j]) {
                j++;
            }
            i++;

            if(j==sL){
                return true;
            }
        }
        return false;
    }
}