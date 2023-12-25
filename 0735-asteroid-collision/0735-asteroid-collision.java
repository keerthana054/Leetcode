class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>stack=new Stack<>();
        for(int i:asteroids){
            if(stack.isEmpty() || i>0){
                stack.add(i);
            }
            else{
                while(true){
                    int peek=stack.peek();
                    if(peek<0){
                        stack.add(i);
                        break;
                    }
                    else if(peek== -i){
                        stack.pop();
                        break;
                    }
                    else if(peek > -i){
                        break;
                    }
                    else{
                        stack.pop();
                        if(stack.isEmpty()){
                            stack.add(i);
                            break;
                        }
                    }
                }
            }
        }
        int []ans=new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            ans[i]=stack.pop();
        }
        return ans;
    }
}