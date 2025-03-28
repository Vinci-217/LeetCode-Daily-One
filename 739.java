class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=n-1;i>=0;i--){
            int tmp = temperatures[i];
            while(!stack.isEmpty()&&tmp>=temperatures[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                ans[i] = stack.peek()-i;
            }
            stack.push(i);
        }
        return ans;
    }
}