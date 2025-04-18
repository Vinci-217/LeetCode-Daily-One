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

// 第三次做法
class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(!map.containsKey(c)){ // 是左括号
                stack.push(c);
            }
            else if(stack.isEmpty()||stack.pop()!=map.get(c)){ // 如果是右括号则自动弹出并跳过循环，不是右括号就返回false
                return false;
            }
        }
        return stack.isEmpty();
    }
}

// 第四次做法
class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for(char c : s.toCharArray()){
            if(!map.containsKey(c)) stack.push(c);
            else if (stack.isEmpty()||!map.get(c).equals(stack.pop())) return false;
        }
        return stack.isEmpty();
    }
}