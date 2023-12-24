class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int count = 0;

        for(int i=0; i<chars.length; i++) {
            count++;

            if(i+1 == chars.length || chars[i]!= chars[i+1]) {
                chars[index] = chars[i];
                index++;
                if(count != 1) {
                    for(char ch : Integer.toString(count).toCharArray()) {
                        chars[index] = ch;
                        index++;
                    }
                }
                count = 0;
            }
        }
        return index;

    }
}