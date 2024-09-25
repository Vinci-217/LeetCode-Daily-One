class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else {
                if (stack.size() != 0) {
                    if (stack.peek() - s.charAt(i) == '(' - ')' || stack.peek() - s.charAt(i) == '[' - ']'
                            || stack.peek() - s.charAt(i) == '{' - '}') {
                        stack.pop();
                    }
                    else
                        return false;

                }
                else
                    return false;

                
            }
        }
        if (stack.size() != 0)
            return false;
        else
            return true;

    }
}
// 第二次做法
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
                stack.push(s.charAt(i));
            else{
                if(stack.isEmpty())
                    return false;
                Character ch = stack.peek();
                if(s.charAt(i)-ch==1||s.charAt(i)-ch==2){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;

    }
}