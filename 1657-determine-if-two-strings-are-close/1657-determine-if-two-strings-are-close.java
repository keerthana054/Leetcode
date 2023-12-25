class Solution {
    public int co(char arr[],int key){
        int c=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                c++;
                arr[i]='-';
            }
        }
        return c;
    }
    public int[] count(char arr[]){
        int n=arr.length;
        int[] arrN=new int[n];
        for(int i=0;i<n;i++){
            if(arr[i]=='-'){
                continue;
            }
            arrN[i]=co(arr,arr[i]);
        }

        Arrays.sort(arrN);

        return arrN;
    }
    public boolean closeStrings(String w1, String w2) {
        char[] c1 = w1.toCharArray();
        char[] c2 = w2.toCharArray();
        for(int i=0;i<c1.length&&i<c2.length;i++){
            if(w1.indexOf(c2[i])==-1){
                return false;
            }
        }
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(Arrays.equals(c1, c2)){
            return true;
        }
        
        int arr1[]=count(c1);
        int arr2[]=count(c2);
        if(Arrays.equals(arr1, arr2)){
            return true;
        }
        return false;
    }
}