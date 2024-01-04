import java.util.HashMap;
import java.util.Map;
import java.lang.Math;

class Solution {
    public int minOperations(int[] v) {
        Map<Integer, Integer> m = new HashMap<>();
        int n = v.length;
        
        for (int i : v) {
            m.put(i, m.getOrDefault(i, 0) + 1);
        }
        
        int c = 0;
        
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int count = entry.getValue();
            
            if (count == 1) {
                return -1;
            }
            
            c += Math.ceil(count / (3.0));
        }
        
        return c;
    }
}