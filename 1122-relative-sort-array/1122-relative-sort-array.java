class Solution {
     public int search(int arr[],int target)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] == target)
                return i;
        }
        return -1;
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        int result [] = new int[arr1.length];
        Arrays.sort(arr1);
        int j=0;
        int k=0;
        while(j < arr1.length)
        {
            int temp = search(arr1,arr2[k]);
            if(temp!= -1)
            {
               result[j] = arr1[temp];
               arr1[temp]=-1;
               j++;
            }
            else
            {
                k++;
            }
            if(k==arr2.length && j<arr1.length)
            {
                for(int i=0;i<arr1.length;i++)
                {
                    if(arr1[i] != -1)
                    {
                        result[j] = arr1[i];
                        j++;
                    }
                } 
            }
        }
        return result;
    }
}