class Solution {
    public int subtractProductAndSum(int n) {
        String num = Integer.toString(n);
        int [] dgt = new int[num.length()];

        for(int i=0; i<num.length(); i++){
            dgt[i] = Character.getNumericValue(num.charAt(i));
        }

        int pdt = 1;
        int sum = 0;
        for(int e : dgt){
            pdt*=e;
            sum+=e;
        }
        return pdt-sum;
    
     }
}