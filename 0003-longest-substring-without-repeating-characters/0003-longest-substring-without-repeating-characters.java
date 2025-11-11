class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charFrequency = new int[128];

        int maxLength = 0;
        int stringLength = s.length();
        int left = 0;

        for ( int right = 0; right < stringLength; right++ ) {
            char currentChar = s.charAt(right);

            charFrequency[currentChar]++;

            while ( charFrequency[currentChar] > 1 ) {
                charFrequency[s.charAt(left)]--;
                left++;
            }  
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}