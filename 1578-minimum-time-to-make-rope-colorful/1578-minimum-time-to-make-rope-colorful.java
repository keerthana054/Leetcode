class Solution {
    public int minCost(String colors, int[] neededTime) {
        int count=0, prev=0;
        char[] color = colors.toCharArray();
        for(int i=1;i<color.length;i++){
            if(color[prev]!=color[i]){
                prev=i;
            }
            else{
                if(neededTime[prev]<=neededTime[i]){
                    count+=neededTime[prev];
                    prev=i;
                }
                   else{
                       count+=neededTime[i];
                   }
                    
                }
            }
        return count;
        } 
    }