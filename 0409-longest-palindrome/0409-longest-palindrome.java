class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();

        char arr[] = new char[52];

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch>=65 && ch<=90){
                arr[ch-'A']++;
            }else{
                arr[26+ch-'a']++;
            }
        }

        int ans = 0;
        boolean odd = false;

        for(int i=0; i<52; i++){
            ans = ans+ (arr[i]/2)*2;
            if(arr[i]%2==1) odd = true;
        }
        
        if(odd) ans++;
        return ans;
    }
}