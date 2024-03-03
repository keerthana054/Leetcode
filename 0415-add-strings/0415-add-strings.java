class Solution {
    public String addStrings(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();
        int i=len1-1;
        int j=len2-1;
        String ans="";
        int carry=0;
        while(i>=0 && j>=0){
            int n1=Integer.parseInt(String.valueOf(num1.charAt(i)));
            int n2=Integer.parseInt(String.valueOf(num2.charAt(j)));
            int n3=n1+n2+carry;
            ans=Integer.toString(n3%10)+ans;
            carry=n3/10;
            i--;
            j--;
        }
        while(i>=0){
            int n1=Integer.parseInt(String.valueOf(num1.charAt(i)));
            int x=n1+carry;
            carry=x/10;
            if(carry>0){
                ans=Integer.toString(x%10)+ans;
            }else{
                ans=Integer.toString(x)+ans;
            }
            i--;
        }
        while(j>=0){
            int n2=Integer.parseInt(String.valueOf(num2.charAt(j)));
            int x=n2+carry;
            carry=x/10;
            if(carry>0){
                ans=Integer.toString(x%10)+ans;
            }else{
                ans=Integer.toString(x)+ans;
            }
            j--;
        }
        if(carry>0){
            return Integer.toString(carry)+ans;
        }
        return ans;
    }
}