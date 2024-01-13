class Solution {
    public int trap(int[] height) {
        if(height.length==0){
            return 0;
        }
        int maxht = 0,index=0;
        for(int i=0;i<height.length;i++){
            if(height[i]>maxht){
                maxht=height[i];
                index=i;
            }
        }
        int localmax=height[0];
        int globalmax=height[index];
        int water=0;
        for(int i=0;i<index;i++){
            if(height[i]<localmax){
                water+=localmax-height[i];
            }
            localmax=Math.max(localmax,height[i]);
        }
         localmax=height[height.length-1];
        for(int i=height.length-1;i>index;i--){
            if(height[i]<localmax){
                water+=localmax-height[i];
            }
            localmax=Math.max(localmax,height[i]);
        }
        return water;
    }
}