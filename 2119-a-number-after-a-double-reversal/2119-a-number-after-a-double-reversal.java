class Solution {
    public boolean isSameAfterReversals(int num) {
      
        int num1=reverseNum(num);
        int num2=reverseNum(num1);
        
        return num==num2 ? true : false;

    }
    
    public int reverseNum(int x){
        int result =0;
        int pop;
        
        while(x!=0){
            pop=x%10;
            x/=10;
            
            result=(result*10)+pop;
        }
        
        return result;
    }
    
}