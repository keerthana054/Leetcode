class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() <= 1) return true;
        int a = word.charAt(0) - 'A';
        if(a >= 32){
            for(int i=1; i<word.length(); i++){
                if(word.charAt(i) - 'A' < 32) return false;
            }
        }
        else{
            if(word.charAt(1) - 'A' < 32){
                for(int i=2; i<word.length(); i++){
                    if(word.charAt(i) - 'A' >= 32) return false;
                }
            }
            else{
                for(int i=1; i<word.length(); i++){
                    if(word.charAt(i) - 'A' < 32) return false;
                }
            }
        }

        return true;
    }
}