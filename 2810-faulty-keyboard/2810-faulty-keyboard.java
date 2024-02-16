class Solution {
    public String finalString(String s) {
        StringBuilder res = new StringBuilder();
        for(var c : s.toCharArray()){
            if(c == 'i'){
                if(res.length() > 0){
                    res.reverse();
                }
                
            }else
             res.append(c);
        }
        return res.toString();
    }
}
