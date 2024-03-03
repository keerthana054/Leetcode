import java.math.BigInteger;
class Solution {
    public int hammingDistance(int x, int y) {
        String x_bin = Integer.toBinaryString(x);
        String y_bin = Integer.toBinaryString(y);

        int max_len = x_bin.length()>y_bin.length()?x_bin.length():y_bin.length();
        String max_str = x_bin.length()>y_bin.length()?x_bin: y_bin;
        String min_str = x_bin.length()>y_bin.length()?y_bin: x_bin;

        int result = 0;
        BigInteger min_bi;
        min_bi  = new BigInteger(min_str);
        System.out.println("min_bi = "+ min_bi);
        String min_format_str = String.format("%0"+max_len+"d", min_bi);
        for(int i=0; i<max_len; i++){
            if(max_str.charAt(i)!=min_format_str.charAt(i))
            {
                result+=1;
            }
        }
        System.out.println(max_str);
        System.out.println(min_format_str);

        return result;
    }
}