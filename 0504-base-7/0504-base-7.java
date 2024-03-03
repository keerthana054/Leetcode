class Solution {
    public String convertToBase7(int num) {
        if(num==0)
        return "0";
        String s="";
        String o="-";
        int y=num;
        num=Math.abs(num);
        while(num>0)
        {
            s+=num%7;
            num/=7;
        }
        StringBuilder k=new StringBuilder();
        k.append(s);
        String z=String.valueOf(k.reverse());
        o+=z;
        if(y<0)
        return o;
        return z;
        
    }
}