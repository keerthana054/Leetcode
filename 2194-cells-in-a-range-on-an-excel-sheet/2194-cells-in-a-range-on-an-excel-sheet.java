class Solution {
    public List<String> cellsInRange(String s) {
        List<String> AL = new ArrayList();
        StringBuilder SB = new StringBuilder();
        char arr[] = s.toCharArray();
        for(char ch = arr[0]; ch <= arr[3]; ch = (char)(ch + 1)) {
            SB.append(ch);
            for(char num = arr[1]; num <= arr[4]; num++) {
                SB.append(num);
                AL.add(SB.toString());
                SB.deleteCharAt(1);
            }
            SB.deleteCharAt(0);
        }
        return AL;
    }
}