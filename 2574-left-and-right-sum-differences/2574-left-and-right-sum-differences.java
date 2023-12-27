class Solution {
    public int[] leftRightDifference(int[] arr) {
        int n=arr.length;
        int[] prefix=new int[n];
        int[] suffix=new int[n];
        prefix[0]=0;
        suffix[n-1]=0;
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+arr[i-1];
        }
        for(int i=n-2;i>=0;i--){
            suffix[i]=suffix[i+1]+arr[i+1];
        }
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            res[i]=Math.abs(prefix[i]-suffix[i]);
        }
        return res;
    }
}