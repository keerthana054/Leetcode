class Solution {
    public String truncateSentence(String s, int k) {
        int count = 0;
        int index = 0;
        for(index = 0; index < s.length(); index++){
            if(s.charAt(index) == ' ')
                count++;   
            if(count==k)
                break;   
        }
        return s.substring(0,index);
    }
}