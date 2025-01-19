class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        char[] ch = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for(int i = 0;i<ch.length;i++){
            if(ch[i]=='(') stack.push(i);
            else{
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                else ans = Math.max(ans,i-stack.peek());
            }
        }
        return ans;
    }
}