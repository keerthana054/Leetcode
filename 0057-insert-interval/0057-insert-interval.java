class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int[][]{newInterval}; 
        int first  = newInterval[0];
        int second = newInterval[1];
        boolean isFind = false;    
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        for(int a = 0; a < n; a++){
            if(isFind){ list.add(intervals[a]); continue;}  
            int subF = intervals[a][0];
            int subS = intervals[a][1];

            if(first >= subF && first <= subS){ 
                int[] priory = new int[2];
                priory[0] = subF;  

                for(int b = a; b < n; b++){
                    if(second >= intervals[b][0]){
                        if(intervals[b][1] >= second){
                            priory[1] = intervals[b][1]; list.add(priory);
                            a = b; isFind = true; break;
                        }
                    }else{
                        priory[1] = second; list.add(priory); 
                        a = b-1; isFind = true; break;
                    }
                    if(b == n-1){
                        priory[1] = second; list.add(priory);
                        a = b; isFind = true; break;
                    }
                }
            }
            
            else if(first < subF){
                int[] priory = new int[2];
                priory[0] = first; 
                
                if(second < subF){
                    priory[1] = second; list.add(priory);
                    a --; isFind = true; continue;
                }
                else{
                    for(int b = a; b < n; b++){
                        if(second >= intervals[b][0]){
                            if(second <= intervals[b][1]){
                                priory[1] = intervals[b][1];
                                list.add(priory); isFind = true; a = b; break; 
                            }
                        }
                        else{
                            a = b-1; priory[1] = second;
                            list.add(priory); isFind = true; break;
                        }
                        if(b == n-1 && !isFind){
                            priory[1] = second; list.add(priory);
                            a = b; isFind = true; break;
                        }
                    }
                }
            }
            else{
                list.add(intervals[a]);
            }
            if(a == n-1 && !isFind) list.add(newInterval);
        }
        int l = list.size();
        int[][] ret = new int[l][2];
        for(int a = 0; a < l; a++){
            ret[a] = list.get(a);
        }
        return ret;
    }
}