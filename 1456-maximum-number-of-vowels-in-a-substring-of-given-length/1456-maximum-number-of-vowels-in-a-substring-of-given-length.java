class Solution {
    public int maxVowels(String s, int k) {
        int i =0;
int j =0;
int omax = 0;
int max = 0;

    while( j < s.length()){

        if(j < k){
            if(s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' || s.charAt(j) == 'o' || s.charAt(j) == 'u'){
                omax++;
            }
            j++;
            
        }
		
        else{
            if(j == k){
                max = omax;
            }
            if(s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' || s.charAt(j) == 'o' || s.charAt(j) == 'u'){
                max++;
            }
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
                max--;
            }
            if(max > omax){
                omax = max;
            }
            i++;
            j++;
        }
    }
    return omax;
    }
}